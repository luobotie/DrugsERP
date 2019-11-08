<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
<title>layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>
	<div id="v6" style="display: none;">
		<form class="layui-form" action="" lay-filter="EnterWarehouse">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">订单编号</label>
					<div class="layui-input-inline">
						<input type="text" name="orderId" id="orderId" lay-verify=""
							 autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" Style="display:none;">
						<input type="text" name="finishNumber" id="finishNumber" lay-verify=""
							 autocomplete="off" class="layui-input">
						<input type="text" name="statusMan" id="statusMan" lay-verify=""
							 autocomplete="off" class="layui-input">
						<input type="text" name="produceMoney" id="produceMoney" lay-verify=""
							 autocomplete="off" class="layui-input">
						<input type="text" name="qualitystatus" id="qualitystatus" lay-verify=""
							 autocomplete="off" class="layui-input">
						<input type="text" name="statustime" id="statustime" lay-verify=""
							 autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label">审核人</label>
					<div class="layui-input-inline">
						<select id="employeeId" name="employeeId" lay-filter="employeeId" lay-verify="">
							<%--<c:forEach var="a" items=${Emps}>
								<option value="${a.Employeeid}">${a.empName}</option>
							</c:forEach> --%>
						</select>
					</div>
				</div>


				<div class="layui-inline">
					<label class="layui-form-label">入库仓库</label>
					<div class="layui-input-inline">
						<select id="warId" name="warId" lay-filter="warId" lay-verify="">
							<%--<c:forEach var="w" items=${Warehouses}>
								<option value="${w.warId}">${w.warName}</option>
							</c:forEach>--%>
						</select>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">入库时间</label>
					<div class="layui-input-inline">
						<input type="text" name="fpsTime" id="fpsTime" lay-verify="fpsTime"
							placeholder="yyyy-MM-dd HH:mm:ss" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-inline"">
						<input type=" tel" name="remark" lay-verify=""
							autocomplete="off" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>


	<div style="display: none;" id="div13">
		<select name="rmoStatus" lay-verify="">
			<option value="未审核" selected>未审核</option>
			<option value="已审核">已审核</option>
			<option value="未审核">未审核</option>
		</select>
		<button type="button" class="layui-btn layui-btn-normal">提交</button>
	</div>
	<!-- 采购订单明细弹出层 -->
	<div style="display: none;" id="div14">
		<table class="layui-hide" id="detail" lay-filter="detail"></table>
	</div>


	<script type="text/html" id="toolbarDemo">
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<select name="city" lay-verify="">
						<option value="">审核状态</option>
						<option value="" selected>全部</option>
						<option value="已审核">已审核</option>
						<option value="未审核">未审核</option>
					</select>  
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <a href="http://www.layui.com" class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
	 			</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="title" required lay-verify="required" placeholder="请输入订单编号" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <a href="http://www.layui.com"class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
				</div>
			</div>
</script>

	<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
			<a class="layui-btn layui-btn-xs" lay-event="shenhe">入库</a>
</script>


	<script src="../layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

	<script>
	layui.use(['form', 'table', 'layedit', 'laydate','jquery'], function() {
		var table = layui.table;
		var form  = layui.form;
		var layer = layui.layer;
		var layedit = layui.layedit;
		var laydate = layui.laydate;
		var $=layui.jquery;
		// 获取仓库
		$.ajax({
			url : "../../getWarehouseSelects.do"
			, data : {warType : '成品仓库'}
			, dataType : "json"
			, error : function(xhr, err){alert(err);}
			, success : function(data){
				for(var i in data.data){
					var s = "<option value='";
					s += data.data[i].warId;
					s += "'>";
					s += data.data[i].warName;
					s += "</option>";
					$("#warId").prepend(s);
				}
				//渲染下拉框
				form.render();
			}
		});
		// 获取审核员工
			$.ajax({
			url : "../../getEmployeeSelects.do"
			, dataType : "json"
			, error : function(xhr, err){alert(err);}
			, success : function(data){
				for(var i in data.data){ 
					//alert(data.data[i].employeeName+data.data[i].employeeId);
				// if(data){
					var s = "<option value='";
					s += data.data[i].employeeId;
					s += "'>";
					s += data.data[i].employeeName;
					s += "</option>";
					$("#employeeId").prepend(s);
				}	
				//渲染下拉框
				form.render();
				}
			});
			tableIns=table.render({
				elem : '#test',
				url : '../../getQualityhxb.do',
				toolbar : '#toolbarDemo',
				title : '生产订单表',
				page : true,
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'orderId',
					title : '订单编号'
				}, {
					field : 'finishNumber',
					title : '订单数量'
				}, {
					field : 'produceMoney',
					title : '订单金额'
				}, {
					field : 'qualitystatus',
					title : '质检状态'
				}, {
					field : 'statusMan',
					title : '质检人'
				}, {
					field : 'statustime',
					title : '质检时间'
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 180
				} ] ]
			});
			<!--弹出层表数据 -->
			var detailtable = table.render({
				elem : '#detail',
				url : '../../getQualityDetailshxb.do',
				title : '质检详情表',
				page : true,
				cols : [ [ {
					field : 'proId',
					title : '药品ID'
				}, {
					field : 'chineseName',
					title : '药品名'
				}, {
					field : 'packaging',
					title : '包装'
				}, {
					field : 'retailPrice',
					title : '价格'
				}, {
					field : 'productionQuantity',
					title : '数量'
				} ] ]
			});
			
			//时间渲染
			laydate.render({ 
				  elem: '#fpsTime'
				  ,type: 'datetime'
				});
			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				//console.log(obj)
				/* if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						obj.del();
						layer.close(index);
					});
				} else */
				if (obj.event === 'edit') {
					layer.open({
						type : 1,
						title : '生产详情单',
						area : [ '520px', '300px' ],
						content : $('#div14'),
						success : function(index, data1) {
							detailtable.reload({
								where : {orderId : data.orderId}
							});							
						}
					});
				} else if (obj.event === 'shenhe') {
					dlg=layer.open({
						type : 1,
						title : '成品入库',
						area : [ '350px', '360px' ],
						content : $('#v6'),
						success : function(index, data1) {
							form.val("EnterWarehouse", data);
						}
					});
				}
			});
			//监听提交按钮
			//监听提交
			form.on('submit(demo1)', function(obj) {
				var data=obj.data;
				$.ajax({
					type : 'post',
					url : '../../addFinishedGoodswarehouse.do',
					data:obj.field,
					success:function(data){
						if(data===1){
							layer.alert('出库成功', {
								icon: 1,
								title: "出库提示"
								});
						}else if(data===0){
							layer.alert('出库失败', {
								icon: 2,
								title: "出库提示"
								});
						}
						//alert(dlg);
						// 清空表单 （“EnterWarehouse”是表单的id）
		                //$("#EnterWarehouse")[0].reset();
		                //layui.form.render();
		                //关闭弹出层
		                layer.close(dlg);
		                //刷新数据表格
						tableIns.reload();
					}
				});
				return false;
			});
		});
	</script>
</body>
</html>

