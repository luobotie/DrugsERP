<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form class="layui-form" action="">
			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">审核人</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
							<option value="">审核人</option>
							<option value="010" selected></option>
							<option value="021">张三</option>
							<option value="0571">李四</option>
						</select>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">审核</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
							<option value="">审核</option>
							<option value="通过">已审核</option>
							<option value="未审核">未审核</option>
						</select>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">入库仓库</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
							<option value="">仓库选择</option>
							<option value="021">原材料入库1</option>
							<option value="0571">原材料仓库2</option>
						</select>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">入库时间</label>
					<div class="layui-input-inline">
						<input type="text" name="date" id="date" lay-verify="date"
							placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-inline"">
						<input type=" tel" name="phone" lay-verify="required"
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
		<select name="city" lay-verify="">
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
						<option value="" selected></option>
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
				<div class="layui-inline">
					<div class="layui-input-inline">
						   <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData" >批量审核</button>
					</div>
				</div>
			</div>
</script>

	<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
			<a class="layui-btn layui-btn-xs" lay-event="shenhe">审核</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
			table.render({
				elem : '#test',
				url : '../json/FinishedGoods.json',
				toolbar : '#toolbarDemo',
				title : '用户数据表',
				page : true,
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'Serial',
					title : '入库编号'
				}, {
					field : 'Quantity',
					title : '货物类型'
				}, {
					field : 'Serial',
					title : '货物数量'
				}, {
					field : 'Quantity',
					title : '货物金额'
				}, {
					field : 'Serial',
					title : '入库编号'
				}, {
					field : 'Time',
					title : '订单生成时间'
				}, {
					field : 'examine',
					title : '审核状态'
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 180
				} ] ]
			});
			<!--弹出层表数据 -->
			table.render({
				elem : '#detail',
				url : '../json/FinishedGoods.json',
				title : '用户数据表',
				page : true,
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'Id',
					title : 'ID',
					width : 80,
					fixed : 'left',
					unresize : true
				}, {
					field : 'Serial',
					title : '入库编号'
				}, {
					field : 'Quantity',
					title : '货物类型'
				}, {
					field : 'Quantity',
					title : '货物类型'
				}, {
					field : 'Serial',
					title : '货物数量'
				}, {
					field : 'Time',
					title : '订单生成时间'
				}, {
					field : 'examine',
					title : '审核状态'
				}] ]
			});
			
			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
				case 'getCheckData':
					var data = checkStatus.data;
					layer.open({
						type : 1,
						content : $('#v6')
					});
					break;
				}
				;
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				//console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						obj.del();
						layer.close(index);
					});
				} else if (obj.event === 'edit') {
					layer.open({
						type : 1,
						content : $('#div14')
					});
				} else if (obj.event === 'shenhe') {
					layer.open({
						type : 1,
						area : [ '500px', '300px' ],
						content : $('#div13')
					});
				}
			});
		});
	</script>
</body>
</html>

