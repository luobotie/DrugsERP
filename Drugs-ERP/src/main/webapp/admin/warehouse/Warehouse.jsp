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
	<div style="display: none;" id="v1">
		<form class="layui-form" action="" lay-filter="upform" id="upform">
			<div class="layui-form-item">
			<div class="layui-inline">
					<input type="hidden" name="warId" autocomplete="off" class="layui-input">
					<label class="layui-form-label">仓库名称</label>
					<div class="layui-input-inline"">
						<input type="text" name="warName" lay-verify="required"
							autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">仓库类型</label>
					<div class="layui-input-inline">
						<select name="warType" lay-verify="">
							<option value="">仓库选择</option>
							<option value="成品仓库">成品仓库</option>
							<option value="原料仓库">原料仓库</option>
							<option value="废弃仓库">废弃仓库</option>
						</select>
					</div>
				</div>
				
				<div class="layui-inline">
					<label class="layui-form-label">仓库地址</label>
					<div class="layui-input-inline"">
						<input type="text" name="warAddress" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-inline"">
						<input type="text" name="warTel" autocomplete="off" class="layui-input" lay-verify="phone|required">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit   lay-filter="demo1">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	
	<script type="text/html" id="toolbarDemo">
			<div class="layui-form-item">
				<div class="layui-row layui-col-space10">
					<form class="layui-form" action="" lay-filter="searchform" id="searchform">
						<div class="layui-col-md1">
							<label>仓库类型</label>
						</div>
						<div class="layui-col-md2">						
							<select name="warType" lay-filter="warType" lay-verify="" style="font-size:13px;">
								<option value="">仓库选择</option>
								<option value="成品仓库">成品仓库</option>
								<option value="原料仓库">原料仓库</option>
								<option value="废弃仓库">废弃仓库</option>
							</select>
						</div>
					</form>
						<div class="layui-col-md6">
							<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData" style="font-size:13px;"> 创建仓库</button>
						</div>
					</div>
			</div>
</script>

	<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit"> 修改 </a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"> 删除   </a>
</script>

	<script>
		layui.use(['form', 'table', 'layedit', 'laydate','jquery'], function() {
			var table = layui.table;
			var form  = layui.form;
			var layer = layui.layer;
			var layedit = layui.layedit;
			var laydate = layui.laydate;
			var $=layui.jquery;
			var status=0;
			
			form.on("select(warType)", function(data){
				tableIns.reload({
					where : {warType : data.value}
				});
				form.val("searchform", {
					warType : data.value
				});
			});
			
			
			var tableIns=table.render({
				elem : '#test',
				url : '../../getWarehouse.do',
				where : {warType : ""},
				toolbar : '#toolbarDemo',
				title : '仓库数据表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				} , {
					field : 'warId',
					title : '仓库编号'
				}, {
					field : 'warName',
					title : '仓库名称'
				}, {
					field : 'warType',
					title : '仓库类型'
				}, {
					field : 'warAddress',
					title : '仓库地址'
				},{
					field : 'warTel',
					title : '联系方式'
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo'
				} ] ],
				page : true
			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
				case 'getCheckData':
					status=1;
					dlg = layer.open({
						type : 1,
						content : $('#v1').html()
					});
					break;
				}
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				//
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index){
						$.post("../../delWarehouse.do","warId="+data.warId,function(back){
							if(back==1){
								layer.msg('删除成功', {
									icon: 4,
									title: "删除提示"
									});
							}else{
								layer.msg('删除失败', {
									icon: 5,
									title: "删除提示"
									});
							}
							//刷新数据表格
							tableIns.reload();
						 })
				      });
				} else if (obj.event === 'edit') {
					status=2;
					dlg = layer.open({
						type : 1,
						content : $('#v1').html(),
						success : function(index, data1) {
							form.val("upform", data);
						}
					});
				}
			});
			
			//监听提交
			form.on('submit(demo1)', function(obj) {
				var data=obj.data;
				var uri='';
				if(status == 2){
					uri='../../upWarehouse.do';
				}else if(status == 1){
					uri='../../addWarehouse.do';
				}
				$.ajax({
					type : 'post',
					url : uri,
					data:obj.field,
					success:function(data){
						if(data===1){
							layer.alert('新增成功', {
								icon: 1,
								title: "新增提示"
								});
						}else if(data===0){
							layer.alert('新增失败', {
								icon: 2,
								title: "新增提示"
								});
						}else if(data === 2){
							layer.alert('修改成功', {
								icon: 1,
								title: "修改提示"
								});
						}else if(data === 3){
							layer.alert('修改失败', {
								icon: 2,
								title: "修改提示"
								});
						}
						// 清空表单 （“upform”是表单的id）
                        $("#upform")[0].reset();
                        layui.form.render();
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