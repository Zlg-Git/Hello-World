/*用户列表   js 文件*/
layui.use(['form','jquery','table','layer','laydate','layedit'],function(){
	//初始化对象
	var form = layui.form;
	var $ = layui.jquery;
	var table = layui.table;
	var layer = layui.layer;
	var laydate = layui.laydate;
	//创建layedit 对象
	var layedit = layui.layedit;
	

	$.ajaxSetup({
		complete:function(XHR, TS){
			console.log("全局设置");
			console.log(XHR.responseJSON);
			console.log(TS);
			var rs = XHR.responseJSON;
			if(rs.code == 402){
				window.parent.location.href="login.html";
			}
		}
	});
	
	//初始化时间组件
	laydate.render({
		elem:"#minTime",
	});
	laydate.render({
		elem:"#maxTime",
	});
	//初始化表格
	var t = table.render({
		id:"dataTableId",
		elem:"#dataTable", //表格容器
		url:"customer.do?service=list",//数据接口
		page:true,//开启分页
		width:"1200",
		height:"520",
		toolbar:"#headerBtns",
		cols:[[
			{type:"checkbox",width:"80"},
			{field:"id",title:"ID",width:"60"},
			{field:"custName",title:"客户名称",width:"120"},
			{field:"custCompany",title:"客户公司",width:"120"},
			{field:"custPosition",title:"客户职位",width:"150"},
			{field:"custPhone",title:"客户电话",width:"120"},
			{field:"custBirth",title:"客户生日",width:"120"},
			{field:"custSex",title:"性别",width:"60",templet:function(d){
				if(d.custSex==1){
					return "<font color='green'>男</font>";
				}else if(d.custSex==2){
					return "<font color='green'>女</font>";
				}
			}},
			{field:"userRealName",title:"业务员",width:"120"},
			{title:"操作",width:"250",toolbar:"#rowBtns",fixed:"right"}
		]],//表格头信息
		parseData:function(rs){//数据格式解析
			if(rs.code == 200){
				return {
					"code":rs.code,
					"msg":rs.msg,
					"count":rs.data.total,
					"data":rs.data.data
				}
			}
		},
		response:{	// 设置响应码
		        statusCode: 200 //规定成功的状态码，默认：0
		} 
	});
	
	//为搜索按钮绑定事件
	$("#searchBtn").click(function(){
		var custName = $("#custName").val();
		var position = $("#position").val();
		var minTime = $("#minTime").val();
		var maxTime = $("#maxTime").val();
		var company = $("#company").val();
		var custPhone = $("#custPhone").val();
		var userId = $("#userId").val();
		//表格重载
		t.reload({
			where:{
				'custName':custName,
				'position':position,
				'minTime':minTime,
				'maxTime':maxTime,
				'company':company,
				'custPhone':custPhone,
				'userId':userId
			}
		});
	});
	//表格头监听事件
	// 新增===================================
	table.on("toolbar(dataTableFilter)",function(obj){
		var event = obj.event;
		if(event == "add"){
			//弹出层  让管理员输入 用户信息
			add();
		}else if(event == "setSales"){
			//获取选中的信息
			var checkStatus = table.checkStatus('dataTableId');
			var data = checkStatus.data;
			if(data.length == 0){
				layer.msg("请先选择客户");
				return false;
			}
			setSales(data);
		}
	});
	
	//行监听   重置密码========================================
	table.on("tool(dataTableFilter)",function(d){
		var event = d.event; //获取事件类型
		var data = d.data;// 获取当前行数据
		if(event == "update"){
			//调用reset方法
			update(data);
		}else if(event == "visit"){
			layer.msg("新增拜访记录");
			addVisitLog(data);
		}
	});
	//客户新增具体方法
	function add(){
		layer.open({
			id:"add",
			title:'编辑',
			type:1,//页面层
			content:$("#editForm").html(),
			btn:['提交','取消'],
			area:['790px','600px'],
			yes:function(layero,index){//点击提交时触发
				$("#submitFormBtn").click();
			},
			btnAlign:'c',
			success:function(layero,index){// 页面弹出成功触发
				//渲染客户生日
				laydate.render({
					elem:"#custBirth"
				});
				//重新渲染表单
				form.render();
				// 初始化layedit
				var custDescEditIndex = layedit.build("custDesc",{
					height:'250px',//设置富文本高度
					hideTool:['image'] ,// 设置隐藏的工具栏
				});
				//为form绑定提交事件
				//为表单新增监听提交事件
				form.on("submit(submitFormFilter)",function(d){
					d.field.custDesc = layedit.getContent(custDescEditIndex);
					$.post("customer.do",d.field,function(rs){
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
	// 修改客户信息=====================================
	function update(data){
		layer.open({
			id:"add",
			title:'编辑',
			type:1,//页面层
			content:$("#editForm").html(),
			btn:['提交','取消'],
			area:['790px','600px'],
			yes:function(layero,index){//点击提交时触发
				$("#submitFormBtn").click();
			},
			btnAlign:'c',
			success:function(layero,index){// 页面弹出成功触发
				//为form表单赋值
				form.val("editFormFilter",{
					'custName':data.custName,
					'custCompany':data.custCompany,
					'custPosition':data.custPosition,
					'custPhone':data.custPhone,
					'custBirth':data.custBirth,
					'custSex':data.custSex,
					'custDesc':data.custDesc
				});
				//渲染客户生日
				laydate.render({
					elem:"#custBirth"
				});
				//重新渲染表单
				form.render();
				// 初始化layedit
				var custDescEditIndex = layedit.build("custDesc",{
					height:'250px',//设置富文本高度
					hideTool:['image'] ,// 设置隐藏的工具栏
				});
				//为form绑定提交事件
				//为表单新增监听提交事件
				form.on("submit(submitFormFilter)",function(d){
					d.field.custDesc = layedit.getContent(custDescEditIndex);
					d.field.service = "update"; //业务类型
					d.field.id = data.id;//客户ID
					$.post("customer.do",d.field,function(rs){
						//业务正常
						if(rs.code == 200){
							layer.msg("更新成功");
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
	// 设置业务员方法 : data 被设置业务员的客户信息
	function setSales(data){
		layer.open({
			id:"setSales",
			title:'设置业务员',
			type:1,//页面层
			content:$("#setSalesTemp").html(),
			btn:['提交','取消'],
			area:['500px','500px'],
			yes:function(layero,index){//点击提交时触发
				$("#setSalesFormBtn").click();
			},
			btnAlign:'c',
			success:function(layero,index){// 页面弹出成功触发
				//获取所有的业务员
				$.ajax({
					url:"user.do",
					data:{'service':'sales'},
					async:false,//设置为同步 ===================  由于form表单需要重新渲染,若使用异步,可能数据没有添加进去,渲染已经执行了.此时会出现页面没有业务员的情况,所以使用同步
					success:function(rs){
						if(rs.code != 200){
							layer.msg(rs.msg);
							return false;
						}
						var sales = rs.data;
						var select = $("#changeUserId");
						$.each(sales,function(index,value){
							select.append("<option value='"+value.id+"'>"+value.realName+"</option>");
						});
					}
				});
				//重新渲染表单
				form.render();
				//监听form表单的提交
				form.on("submit(setSalesFormFilter)",function(d){
					var ids = "";
					$.each(data,function(index,value){
						ids = ids + "id="+value.id+"&"
					});
					//提交数据
					$.post("customer.do?service=setSales&"+ids,{'userId':d.field.userId},function(rs){
						//业务正常
						if(rs.code == 200){
							layer.msg("设置成功");
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
	//==新增拜访记录===========================
	function addVisitLog(data){
		
		layer.open({
			id:"addVisitLog",
			title:'拜访记录',
			type:1,//页面层
			content:$("#visitLogTemp").html(),
			btn:['提交','取消'],
			area:['500px','500px'],
			yes:function(layero,index){//点击提交时触发
				$("#visitLogBtn").click();
			},
			btnAlign:'c',
			success:function(layero,index){// 页面弹出成功触发
				//为拜访的客户赋值
				form.val("visitLogFormFilter",{
					'custName':data.custName
				});
				laydate.render({
					elem:"#visitTime",
					trigger:'click' 
				});
				//重新渲染表单
				form.render();
				//监听form表单的提交
				form.on("submit(visitLogBtnFilter)",function(d){
					d.field.id=data.id;
					//提交数据
					$.post("customer.do?service=addVisitLog",d.field,function(rs){
						//业务正常
						if(rs.code == 200){
							layer.msg("添加成功");
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
});