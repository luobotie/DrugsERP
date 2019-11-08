<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜单</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<div style="display: none;" id="div3">
		<select name="city" lay-verify="">
			<option value="010" selected>审核中</option>
			<option value="021">审核通过</option>
			<option value="0571">审核没有通过</option>
		</select>
		<button type="button" class="layui-btn layui-btn-normal">提交</button>
	</div>

	<script type="text/html" id="toolbarDemo">
			<div class="layui-form-item">
				<div class="layui-inline">
					<div class="layui-input-inline">
						<select name="city" layui-verify="" style="font-size:13px;">
							<option value="000"> 仓库选择 </option>
							<option value="010" selected> 未审核 </option>
							<option value="021"> 审核未通过 </option>
							<option value="0571"> 审核通过 </option>
						</select>  
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <a href="http://www.layui.com"class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<select name="city" layui-verify="" style="font-size:13px;">
							<option value="000"> 仓库选择 </option>
							<option value="010" selected> 未审核 </option>
							<option value="021"> 审核未通过 </option>
							<option value="0571"> 审核通过 </option>
						</select>  
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <a href="http://www.layui.com"class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<select name="city" layui-verify="" style="font-size:13px;">
							<option value="000"> 仓库选择 </option>
							<option value="010" selected> 未审核 </option>
							<option value="021"> 审核未通过 </option>
							<option value="0571"> 审核通过 </option>
						</select>  
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <a href="http://www.layui.com"class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<select name="city" layui-verify="" style="font-size:13px;">
							<option value="000"> 仓库选择 </option>
							<option value="010" selected> 未审核 </option>
							<option value="021"> 审核未通过 </option>
							<option value="0571"> 审核通过 </option>
						</select>  
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <a href="http://www.layui.com"class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
				</div>
			</div>
</script>
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
				title : '成品库存表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'proId',
					title : '药材编号'
				}, {
					field : 'Serial',
					title : '药材名称'
				}, {
					field : 'Serial',
					title : '库存数量'
				}, {
					field : 'Serial',
					title : '库存最大数量'
				}, {
					field : 'examine',
					title : '采购价'
				}, {
					field : 'Time',
					title : '仓库名称'
				}] ],
				page : true
			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
				case 'getCheckData':
					var data = checkStatus.data;
					layer.open({
						type : 1,
						content : $('#v1')
					});
					break;
				}
				;
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				//console.log(obj)
				if (obj.event === 'edit') {
					layer.open({
						type : 1,
						content : $('#div4')
					});
				}
			});
		});
	</script>
</body>
</html>

