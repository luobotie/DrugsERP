<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>总店销售单(总店收款)</title>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
<script src="../layui/layui.js"></script>
<style type="text/css">

body {
	margin: 0 auto;
	width: 100%;
	height: 100%;
}
.demoTable {
	width: 100%;
	height: 50px;
	margin: 0px auto;
	line-height: 50px;
}
label{
	font-size: 13px;
}
</style>


<script>
	//头工具栏时间器渲染
	layui.use(['table','form','laydate','jquery'], function(){
		  var table = layui.table;
		  var form = layui.form;
		  var laydate = layui.laydate;
		  var $=layui.jquery;
		  
		  //给分店下拉框动态赋值
		  $(function () {
       		 GetBScontract();
    		})
    	//获取类别
    	function GetBScontract() {
			  var bsNameSelect=$("#bsName");
			//给下拉框赋值
	    	  bsNameSelect.empty();//清空下拉列表数据
	    	  $.ajax({
					url:'../../getAllBSContract.do',
					success:function(back){
						if(back != null){
			                for (var i = 0; i < back.length; i++) {
			                	//alert(back[i].conName)
			                	//bsNameSelect.add(new Option(back[i].partyB,back[i].partyB));
			                	bsNameSelect.append("<option value="+back[i].partyB+">"+back[i].partyB+"</option>");
							} 
			                form.render();
			            }
					}
				})    
			  
    	}
		  //日期时间选择器
			  laydate.render({
			    elem: '#test5'
			    ,type: 'date'
			  });
		});
	
		var table2 = null ;
		layui.use(['table','form','laydate','jquery'], function(){
			 var table = layui.table;
		     var form = layui.form;
		    var laydate = layui.laydate;
		    var $=layui.jquery;
		  //执行一个 table 实例
		 	table2 =  table.render({
		    elem: '#demo'
		    ,height:563
		    ,url:  '../json/demo1.json'//数据接口
		    ,title: '分店退货单'
		    ,page: true //开启分页
		    ,limit:5 //默认行数
		    ,limits:[5,10,15] //显示行数
		    ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
		    ,totalRow: true //开启合计行
		    ,cols: [[ //表头
		    	{type:'checkbox', fixed: 'left'}
		        ,{field: 'orderId', title: '订单号', width:150, sort: true,unresize:true}
		        ,{field: 'orderTime', title: '下单日期', unresize:true}
		        ,{field: 'branchName', title: '分店', unresize:true}
		        ,{field: 'merchantName', title: '商品名称', unresize:true}
		        , {field: 'merchantQuantity', title: '商品数量', unresize:true}
		        , {field: 'tatal', title: '合计',unresize:true}
		        ,{field: 'payStatus', title: '支付状态', unresize:true}
		        , {field: 'payMethod', title: '付款方式', unresize:true}
		        ,{field: 'receverStutas', title: '收货状态', unresize:true}
		        ,{field: 'checkStatus', title: '审核状态', unresize:true}
		        ,{
		    		fixed: 'right', title:'操作',width:178, align:'center', toolbar: '#barDemo',unresize:true
		          }
		    ]]
		  });
		  
		 	$(function() {
			 	//查询
		 		$("#seachTable").on("click",function(){
		 			//iframe层
		 			console.info("111");
		 			table2.reload({
		 				where : {
		 					flowerName:$("#name").val(),
		 				},
		 				page : {
		 					curr : 1
		 				}
		 			});
		 		});
		 	});
		  
	 	//监听头工具栏事件
	 	  table.on('select', function(data){
	 		 console.log(data.elem);
	 		 console.log(data.value);
	 		 $('#audit').val(data.value);
	 		 console.log(data.othis);
	 		 var audit=$('#audit').val();
	 		 alert(audit);
	 	  });
	 	
		//监听操作
		table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
	
			if (layEvent === 'del') { //查看
				layer.confirm('真的删除行么',function(index) {
					obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					//向服务端发送删除指令
					var url = "flowerServlet?action=delect";
					var data$ = {flowerId : data.flowerId};
					$.post(url,data$,function(obj) {
						layer.msg(obj.msg);//提示
						table2.reload(); //也是刷新父页面的
 				},"json");
				});
			} else if (layEvent === 'edit') { //编辑
				var data = obj.data;//行数据
				//iframe层
				layer.open({
					type : 2,
					title : '修改页面',//标题
					shadeClose : true,
					shade : 0.3,//背景阴影
					area : [ '50%', '60%' ],//大小
					content : 'pages/flower/flowerFrom.jsp?id='
							+ data.flowerId, //iframe的url
					end : function() {
						table2.reload();
					}
				});
			}
		});
		
	});
</script>

</head>
<body>
<!-- 头工具栏模糊搜索 -->
<script type="text/html" id="toolbarDemo">
	<form class="layui-form" action="" >
			<div class="layui-inline" style="margin-left:20px;">
					<label >下单日期：</label>
				<div class="layui-input-inline" style="margin-left:5px;">
					<input type="text"  class="layui-input" name="orderTime" id="orderTimeLike"
						placeholder="年--月--日 ">
				</div>
			</div>

	<div class="layui-inline" style="margin-left:20px;">
      <label >审核状态：</label>
      <div class="layui-input-inline" style="margin-left:5px;">
        <select name="orderCheckStatus" id="orderCheckStatusLike"  lay-search="required">
          <option value="1">请选择</option>
          <option value="2">未审核</option>
		<option value="2">已审核</option>
        </select>
      </div>
    </div>	

 <div class="layui-inline" style="margin-left:20px;">
      <label >分店：</label>
      <div class="layui-input-inline" style="margin-left:5px;">
        <select id="bsName" name="bsName" onchange="changeCity()"
		lay-verify="bsName" placeholder="请选择分店" required="required">
      </div>
    </div>

	<div class="layui-inline" >
			<button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>		
		</div>    
</form>
</script>
<!-- 数据表格 -->
<table id="demo" lay-filter="test"></table>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="check" style="width:60px;height:30px;line-height:30px">审核</a>
</script>

 
</body>
</html>