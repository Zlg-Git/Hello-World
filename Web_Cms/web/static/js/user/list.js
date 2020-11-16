/*用户列表   js 文件*/
layui.use(['form','jquery','table','layer'],function(){
	//初始化对象
	var form = layui.form;
	var $ = layui.jquery;
	var table = layui.table;
	var layer = layui.layer;

	//初始化表格
	var t = table.render({
		id:"dataTableId",
		elem:"#dataTable", //表格容器
		url:"user.do?service=list",//数据接口
		page:true,//开启分页
		width:"1009",
		height:"520",
		toolbar:"#headerBtns",
		cols:[[
			{type:"checkbox",width:"80"},
			{field:"id",title:"用户ID",width:"80"},
			{field:"userName",title:"账号",width:"120"},
			{field:"password",title:"密码",width:"120"},
			{field:"realName",title:"姓名",width:"150"},
			{field:"type",title:"角色",width:"100",templet:function(d){
				if(d.type==1){
					return "管理员";
				}else if(d.type==2){
					return "业务员";
				}
			}},
			{field:"isDel",title:"状态",width:"100",templet:function(d){
				if(d.isDel==1){
					return "<font color='green'>有效</font>";
				}else if(d.isDel==2){
					return "<font color='gray'>无效</font>";
				}
			}},
			{title:"操作",width:"250",toolbar:"#rowBtns"}
		]],//表格头信息
		parseData:function(rs){//数据格式解析

			if(rs.code == 200){
				console.log("rs===="+rs.toString()+"---"+rs.data.totalCount+"---"+rs.data.data+"---"+rs.msg)
				return {
					"code":rs.code,	//返回状态码200
					"msg":rs.msg,	//
					"count":rs.data.totalCount,	//总条目
					"data":rs.data.data	//具体内容
				}
			}

		},
		response:{	// 设置响应码
		        statusCode: 200 //规定成功的状态码，layui默认值是：0
		}
	});
	
	//为搜索按钮绑定事件
	$("#searchBtn").click(function(){
		var userName = $("#userName").val();
		var realName = $("#realName").val();
		var type = $("#type").val();
		//表格重载
		t.reload({
			where:{
				'userName':userName,
				'realName':realName,
				'type':type
			}
		});
	});
	// 新增===================================
	table.on("toolbar(dataTableFilter)",function(obj){
		var event = obj.event;
		if(event == "add"){
			//弹出层  让管理员输入 用户信息
			add();
		}else if(event == "del"){
			//获取被选中的数据的ID
			var checkStatus = table.checkStatus('dataTableId');
			var data = checkStatus.data;
			if(data.length == 0){
				layer.msg("请先选择要删除的数据!");
				return false;
			}
			//获取选中的数据  传给服务器 进行更新状态
			layer.confirm("你确定要删除吗?",function(index){
				
				console.log("删除了!==========");
				del(data,index);
			});
		}
		
	});
	//行监听   重置密码========================================
	table.on("tool(dataTableFilter)",function(d){
		var event = d.event; //获取事件类型
		var data = d.data;// 获取当前行数据
		if(event == "reset"){
			//调用reset方法
			reset(data);
		}
	});
	//用户新增具体方法
	function add(){
		layer.open({
			id:"add",
			title:'编辑',
			type:1,//页面层
			content:$("#editForm").html(),
			btn:['提交','取消'],
			area:['500px','450px'],
			yes:function(layero,index){//点击提交时触发
				$("#submitFormBtn").click();
			},
			btnAlign:'c',
			success:function(layero,index){// 页面弹出成功触发
				//重新渲染表单
				form.render();
				//为表单新增监听提交事件
				form.on("submit(submitFormFilter)",function(d){
					$.post("user.do",d.field,function(rs){
						//业务正常
						if(rs.code == 200){
							layer.msg("新增成功");
							//让搜索按钮进行点击  刷新table
							$("#searchBtn").click();
							//关闭弹层
							layer.close(index);
							return false;
						}
						layer.msg(rs.msg);
					});
					return false;//阻止表单默认提交
				});
			}
			
		});
	}
	// 删除用户的方法
	function del(data,index){
		var ids = "";
		//jquery 中each循环
		$.each(data,function(index,value){
			ids = ids+"id="+value.id+"&";
		});
		$.post("user.do?service=del&"+ids,function(rs){
			if(rs.code == 200){
				layer.msg("删除成功!");
				//让搜索按钮进行点击  刷新table
				$("#searchBtn").click();
				//关闭弹层
				layer.close(index);
				return false;
			}
			//显示 失败信息
			layer.msg(rs.msg);
			//关闭弹层
			layer.close(index);
		});
	}
	//重置密码方法
	function reset(data){
		layer.confirm("你确定要重置密码吗?",function(index){
			$.post("user.do?service=reset",{"id":data.id},function(rs){
				if(rs.code == 200){
					layer.msg("密码重置成功!");
					//让搜索按钮进行点击  刷新table
					$("#searchBtn").click();
					//关闭弹层
					layer.close(index);
					return false;
				}
				layer.msg(rs.msg);
				//关闭弹层
				layer.close(index);
			});
		});
	}
});