/*用户列表   js 文件*/
layui.use(['form','jquery','layer'],function(){
	//初始化对象
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	// 全局的ajax 结果的处理
	$.ajaxSetup({
		complete:function(XHR, TS){
			console.log("全局设置");
			console.log(XHR.responseJSON);
			console.log(TS);
			var rs = XHR.responseJSON;
			//统一的登录超时处理
			if(rs.code == 402){
				window.parent.location.href="login.html";
			}
		}
	});
	//为表单添加提交监听事件
	form.on("submit(submitBtnFilter)",function(d){
		var data = d.field;//表单数据
		if(data.newPassword != data.confirmPassword){
			layer.msg("两次密码不一致,请保持一致");
			return false;
		}
		$.post("user.do?service=updatePwd",data,function(rs){
			if(rs.code == 200){
				layer.msg("密码修改成功!请重新登录");
				setTimeout(function(){
					//window.parent
					window.parent.location.href="index.jsp";
			    },1000);
				return false;
			}
			layer.msg(rs.msg);
		});
		return false;// 阻止表单默认提交
	});
		
});