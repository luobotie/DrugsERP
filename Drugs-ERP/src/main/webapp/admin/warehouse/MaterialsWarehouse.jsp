<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜单</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js" charset="utf-8"> </script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<div class="layui-form-item" type="text/html">
		<div class="layui-row layui-col-space10">
		<form class="layui-form" action="" lay-filter="searchform" id="searchform">
			<div class="layui-col-md1">
					<label class="layui-form-label">仓库名</label>
				</div>
				<div class="layui-col-md2">						
					<select id="warId" name="warId" lay-filter="warId" lay-verify="" style="font-size:13px;">
					</select>
				</div>
				<div class="layui-col-md1" >
					<label class="layui-form-label">供应商</label>
				</div>
				<div class="layui-col-md3">						
					<select id="supplierId" name="supplierId" lay-filter="supplierId" lay-verify="" style="font-size:13px;">
					</select>
				</div>
			
				<div class="layui-col-md1">
					<label class="layui-form-label">药材名</label>
				</div>
				<div class="layui-col-md2">						
					<input type="text" id="materialName" name="materialName" lay-filter="materialName" lay-verify="" placeholder="请输入药材名" autocomplete="off" class="layui-input"/> 
				</div>
				<div class="layui-col-md1">
				   	<button class="layui-btn" lay-submit   lay-filter="search">搜索</button>
				</div>
			</form>
	</div>
	</div>
	<table class="layui-hide"  id="test" lay-data="{id: 'idtest'}" lay-filter="test" ></table>
	<script>
	layui.use(['form', 'table', 'layedit', 'laydate','jquery'], function() {
		var table = layui.table;
		var form  = layui.form;
		var layer = layui.layer;
		var layedit = layui.layedit;
		var laydate = layui.laydate;
		var $=layui.jquery;
		var wheres = {warId : 0, supplierId: 0, materialName:''};
		//  供货商
		$.ajax({
			url : "../../getSupplierSelects.do"
			, dataType : "json"
			, error : function(xhr, err){alert(err);}
			, success : function(data){
				for(var i in data.data){
					var s = "<option value='";
					s += data.data[i].supplierId;
					s += "'>";
					s += data.data[i].supplierName;
					s += "</option>";
					$("#supplierId").prepend(s);
				}
				//渲染下拉框
				form.render();
				//alert(debugObj(wheres));  
			}
		});  //*/
		// 仓库
		$.ajax({
			url : "../../getWarehouseSelects.do"
			, data : {warType : '原料仓库'}
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
		//监听下拉框
		form.on("select(warId)", function(data){
			wheres.warId = data.value;
			//alert(wheres.warId);
			table.reload('idtest',{
				where : wheres,
				page: {
				    curr: 1 //重新从第 1 页开始
				  }
			});
		});
		//监听下拉框
		form.on("select(supplierId)", function(data){
			wheres.supplierId = data.value;
			table.reload('idtest',{
				where : wheres
			});
			//form.reload("searchform", wheres);
		});  //*/
		form.on("submit(search)", function(data){
			wheres.materialName= $('#materialName').val();
			//wheres.materialName =mName.value;
			alert(wheres.materialName);
			table.reload('idtest',{
				where : wheres
			});
			return  false;
			//form.reload("searchform", wheres);
		});
		//*/
		
			var tableIns=table.render({
				elem : '#test',
				url : '../../getMaterialInventory.do',
				//toolbar : '#toolbarDemo',
				where : wheres,
				title : '原料库存表',
				id : 'idtest',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'materialId',
					title : '药材编号'
				}, {
					field : 'materialName',
					title : '药材名称'
				},{
					field : 'materialStandard',
					title : '库存单位'
				}, {
					field : 'miNumber',
					title : '库存数量'
				}, {
					field : 'miMax',
					title : '库存最大数量'
				}, {
					field : 'materialPrice',
					title : '采购价'
				}, {
					field : 'supplierName',
					title : '供应商名称'
				}, {
					field : 'warName',
					title : '仓库名称'
				}] ],
				page : true
			});

		});
	
	//测试表格渲染
	function debugObj(obj) {
		var s = "";
		for (var i in obj) {
			s += i;
			s += " = ";
			s += obj[i];
			s += "\n";
		}
		return s;
	}
	</script>
</body>
</html>

