<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>成品及配方管理</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <link rel="stylesheet" href="../layui/css/notice.css" />
  
  <script src="../layui/layui.js"></script>
  <script type="text/javascript" >
		 layui.config({
		        base: '../layui/'
		    });
  </script>
  <script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>          
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<style type="text/css">
.layui-table-cell{
	text-align:center;
	height: 100%;
	white-space: normal;
}
.layui-table img{
	max-width:100%;
}
</style>
<body>    
		<table class="layui-hide" id="test" lay-filter="test"></table>
		<div style="display: none" id="divTable">
			<table class="layui-hide" style="display: none;" id="test2"
			lay-data="{id: 'idTest'}" lay-filter="test2"></table>
		</div>

<script type="text/html" id="toolbarDemo">
  	<div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse"><i class="layui-icon layui-icon-add-1"></i>新增药品</button>
    	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="updateDetails"><i class="layui-icon layui-icon-add-1"></i>新增配方详情</button>
   		<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="removeWarehouse"><i class="layui-icon layui-icon-survey"></i>审核药品</button>
		<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="capacityWarning"><i class="layui-icon layui-icon-survey"></i>审核配方</button>
  	</div>
</script>

<div id="toolbarDemo2" style="display:none">
<form class="layui-form" action="javaScript:void(0)" id="we" method="post" lay-filter="formTest">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;">
  <legend>添加原料配方</legend>
</fieldset>
	<label width="120px" style="margin:0 5px 0 0px;font-size:13px;">原料名</label>
      <div class="layui-input-inline">
        <select name="materialId" lay-verify="required" id="typeselectBox2">
        </select>
      </div>
	 
	<!-- <label width="120px" style="margin:0 5px 0 20px;font-size:13px;">供应商</label>
      <div class="layui-input-inline">
        <select name="supplierInfoId" lay-verify="required" id="typeselectBox">
        </select>
      </div>

	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">单价</label>
	<div class="layui-input-inline">
		 <input type="text" name="materialPrice" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input">
	</div> -->
	<button class="layui-btn layui-btn-normal" lay-event="update" lay-filter="tianjia">添加</button>
 </form>	
</div>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="manageMe">管理药品</a>
			<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="manageAe">管理配方</a>
		</script>


		<script type="text/html" id="barDemo2">
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
		<script>
			layui.use(['table', 'laydate', 'form','notice'], function() {
				var $ = layui.jquery;
				var table = layui.table; //表格
				var laydate = layui.laydate;
				var form = layui.form;
				var notice = layui.notice;
				
				//table3主页面
				//table2弹出层
				
				/* //下拉框赋值(产品供应商)
				var option = "<option value='-1'>请选择供应商</option>";//初始化option的选项
		        $.ajax({
		            url: "../../getSuppliere.do",
		            type: 'POST'
		        })
		        .done(function(data) {
		            for(var i=0;i<data.length;i++){                	
		                option+="<option value='"+data[i]['supplierId']+"'>"+data[i]['supplierName']+"</option>";//拼接option中的内容
		                	$("#typeselectBox").html(option);//将option的拼接内容加入select中，注意选择器是select的ID
		            }
		            form.render('select');//重点：重新渲染select
		        })
		        .fail(function() {
		            console.log("error");
		        }); */
				
		      //初始化配置，同一样式只需要配置一次，非必须初始化，有默认配置
				notice.options = {
					closeButton: true, //显示关闭按钮
					debug: false, //启用debug
					positionClass: "toast-top-center", //弹出的位置,
					showDuration: "500", //显示的时间
					hideDuration: "1000", //消失的时间
					timeOut: "2000", //停留的时间
					extendedTimeOut: "1000", //控制时间
					showEasing: "swing", //显示时的动画缓冲方式
					hideEasing: "linear", //消失时的动画缓冲方式
					iconClass: 'layui-icon-tips', // 自定义图标，有内置，如不需要则传空 支持layui内置图标/自定义iconfont类名
					onclick: null, // 点击关闭回调
				};
		        
		      	//下拉框赋值(产品原料)
		        var options = "<option value='-1'>请选择原料</option>";//初始化option的选项
		        $.ajax({
		            url: "../../getMaterialName.do",
		            type: 'POST'
		        })
		        .done(function(data) {
		            for(var i=0;i<data.length;i++){                	
		                options+="<option value='"+data[i]['materialId']+"'>"+data[i]['materialName']+"</option>";//拼接option中的内容
		                	$("#typeselectBox2").html(options);//将option的拼接内容加入select中，注意选择器是select的ID
		            }
		            form.render('select');//重点：重新渲染select
		        })
		        .fail(function() {
		            console.log("error");
		        });
				
		        //下拉框赋值(产品图片)
		        var optionse = "<option value='-1'>请选择图片</option>";//初始化option的选项
		        $.ajax({
		            url: "../../selectProImage.do",
		            type: 'POST'
		        })
		        .done(function(data) {
		            for(var i=0;i<data.length;i++){                	
		                optionse+="<option value='"+data[i]['imgUrl']+"'>"+data[i]['imgName']+"</option>";//拼接option中的内容
		                	$("#typeselectBox3").html(optionse);//将option的拼接内容加入select中，注意选择器是select的ID
		            }
		            form.render('select');//重点：重新渲染select
		        })
		        .fail(function() {
		            console.log("error");
		        });
		        //下拉框赋值(产品类型)
		        var optionses = "<option value='-1'>请选择产品类型</option>";//初始化option的选项
		        $.ajax({
		            url: "../../selectProType.do",
		            type: 'POST'
		        })
		        .done(function(data) {
		            for(var i=0;i<data.length;i++){                	
		            	optionses+="<option value='"+data[i]['proTypeId']+"'>"+data[i]['proTypeName']+"</option>";//拼接option中的内容
		                	$("#typeselectBox4").html(optionses);//将option的拼接内容加入select中，注意选择器是select的ID
		            }
		            form.render('select');//重点：重新渲染select
		        })
		        .fail(function() {
		            console.log("error");
		        });
		        
				laydate.render({
					elem: '#test1', //指定元素
					type: 'datetime'
				});
				laydate.render({
					elem: '#test5', //指定元素
					type: 'datetime'
				});
				laydate.render({
					elem: '#test66', //指定元素
					type: 'datetime'
				});
				//执行一个 table 实例
				var table3 = table.render({
					elem: '#test',
					url: '../../getAllProduct.do', //数据接口
					title: '药品表',
					toolbar: '#toolbarDemo', //开启工具栏
					cols: [[ //表头
								{
								type: 'checkbox'
							}, {
								field: 'proId',
								title: '药品编号',
								sort: true,
								unresize : true
							}, {
								field: 'chineseName',
								title: '药品名称',
								unresize : true
							}, {
								field : 'proImage',
								title : '药品图片',
								hide : true,
								templet:'<div><img  src="{{ d.proImage }}"></div>'
							}, {
								field: 'statues',
								title: '药品审核状态',
								unresize : true
							}, {
								field: 'proStaData',
								title: '药品审核时间',
								unresize : true
							}, {
								field: 'proRecipe',
								title: '有无配方',
								unresize : true
							}, {
								field: 'recipeStatues',
								title: '配方审核状态',
								hide: true,
								unresize : true
							}, {
								field: 'proMan',
								title: '药品制定人',
								hide: true,
								unresize : true
							}, {
								field: 'proDate',
								title: '药品制定时间',
								unresize : true
							}, {
								title: '操作',
								width : 178,
								align: 'center',
								toolbar: '#barDemo',
								unresize : true
							}
						]],
						page : true
						,limit:10
						,limits:[10,20,30,50]   
				});

				
				//监听弹出层头部工具栏
				table.on('toolbar(test)', function(obj) {
					var checkStatus = table.checkStatus(obj.config.id);
					//获得选择的对象
					var data = checkStatus.data;
					switch (obj.event) {
						case 'addWarehouse':	//新增药品
							layer.open({
								title: '新增药品',
								type: 1, //Page层类型
								//area: ['500px', '520px'], //宽高
								closeBtn: 0,
								btn: ['确定', '关闭'], //可以无限个按钮
								yes: function(index, layero) {
									var chineseName = $("#chineseName").val();
									var typeselectBox3 = $("#typeselectBox3").val();
									var typeselectBox4 = $("#typeselectBox4").val();
									var retailPrice = $("#retailPrice").val();
									var expirationdate = $("#expirationdate").val();
									var test1 = $("#test1").val();
									if(typeselectBox3 == '-1'||typeselectBox4=='-1'||chineseName==''||retailPrice==''||expirationdate==''||test1==''){
										/* layer.msg('信息不能为空', {
						            		  icon: 2,
						            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
						            		}); */
										notice.info("信息不能为空");
									}else{
										$.ajax({
											  url:'../../insertProduct.do',
											  data:$("#formIdOne").serialize(),
											  type:'post',
											  dataType:'json',
											  success:function(data){
												if(data == '1'){
													//layer.msg('新增成功');
													notice.success("新增成功");
													table3.reload();
												}else{
													//layer.msg('新增失败');
													notice.error("新增失败");
												}
											  }
						                  //return false;
						                });
										layer.close(index);
										//执行清空
										//$("#formIdOne").empty();
										//$("#storageWarehouse").empty();
										//form.render("select");
									}
									
								},
								content: $("#addDetails"),
								success: function(layero, index){
									  form.render();
									  }
							});
							break;
						case 'updateDetails':	//新增配方
						if(data.length == 1){
							var table2 = table.render({
								elem: '#test2',
								url: '../../selectThisProductMaterial.do?proId='+data[0].proId,
								title: '用户表', 
								totalRow: true, //开启合计行
								toolbar :"#toolbarDemo2",
								cols: [[ //表头
										{
											field: 'materialId',
											title: '原料编号',
											hide: true,
											sort: true
										}, {
											field: 'materialName',
											title: '原料名称'
										}, {
											field: 'supplierInfoId',
											title: '供应商ID'
										}, {
											field: 'prdId',
											title: '配方详情表ID',
											hide : true
										}, {
											field: 'materialPrice',
											title: '单价',
											sort: true,
										}, {
											title: '操作',
											align: 'center',
											toolbar: '#barDemo2'
										}
										]]
								});
							
								var index = layer.open({
									title: '新增原料配方',
									type: 1, //Page层类型
									area: ['980px', '550px'],
									closeBtn: 0,
									btn: ['关闭'], //可以无限个按钮
									content: $("#test2"),
									yes: function(index, layero){
										  layer.close(index);
										 //return false 开启该代码可禁止点击该按钮关闭
									},
									area : [ '980px', '550px' ],
									content : $("#divTable"),
									success : function(layero) {
										var mask = $(".layui-layer-shade");
										mask.appendTo(layero.parent());
									},
									end : function() {
										$('[lay-id="test2"]').css("display", "none");
									}
								});
							}else if(data.length > 1){
								//layer.msg('最多只能选择一件药品');
								notice.warning("最多只能选择一件药品");
							}else{
								//layer.msg('请选择要制定配方的药品');
								notice.warning("请选择要制定配方的药品");
							}
						//监听事件
						table.on('toolbar(test2)', function(obj){
						  var checkStatus = table.checkStatus(obj.config.id);
						  switch(obj.event){
						    case 'update':
						    	//监听button
					            	//获取表单区域所有值
					            	//alert(data.field.titletype);
					            	//console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
					            	var typeselectBox2 = $("#typeselectBox2").val();
					            	if(typeselectBox2 == '-1'){
					            		//layer.msg('不能为空');
					            		notice.info("不能为空");
					            	}else{
					            		$.ajax({
											  url:'../../insertProductMaterial.do?proId='+data[0].proId,
											  data:$("#we").serialize(),
											  type:'post',
											  dataType:'json',
											  success:function(data){
												if(data == '1'){
													//layer.msg('添加成功');
													notice.success("添加成功");
													table2.reload();
												}else{
													//layer.msg('添加失败');
													notice.error("添加失败");
												}
											  }
						                  //return false;
						                }); 
					            	}
						    break;
						  };
						});
							break;
						case "removeWarehouse":	//审核药品
							if(data.length == 1){
								//判断月计划审核状态
								if(data[0].statues == '未审核'){
									var index2 = layer.confirm('你确认审核该药品？', {
										  btn: ['确认', '取消'] //可以无限个按钮
										  ,btn2: function(index, layero){
										    layer.close(index2);
										  }
										}, function(layero){
											layer.close(index2);
											var index88 = layer.open({
												  type: 1,
												  shade: 0.25,
												  area: ['400px', '350px'],
												  content: $('#nameAndTimeDiv2'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
												  success: function(layero, index){
													  form.render();
													  },
												  btn: ['确认', '取消'],
												  yes: function(layero){
													  $.ajax({
														  url:'../../updateProductStatues.do?proId='+data[0].proId,
														  data:$("#formIdOne3").serialize(),
														  type:'post',
														  dataType:'json',
														  success:function(data){
															if(data == '1'){
																//layer.msg('审核成功');
																notice.success("审核成功");
																table3.reload();
															}else{
																//layer.msg('审核失败');
																notice.error("审核失败");
															}
														  }
									                });
													  layer.close(index);
													  layer.close(index88);
													}
												  ,btn2: function(index, layero){
														  layer.close(index88);
													}
											});
											
										});
								}else{
									//layer.msg('该药品已审核');
									notice.warning("该药品已审核");
								}
								
							}else if(data.length >1){
								//layer.msg('最多只能审核一件商品');
								notice.warning("最多只能审核一件商品");
							}else {
								//layer.msg('请选择一件商品');
								notice.warning("请选择一件商品'");
							}
							break;
						case "capacityWarning":	//审核配方
							if(data.length == 1){
								//判断月计划审核状态
								if(data[0].recipeStatues == '未审核'){
									var index2 = layer.confirm('你确认审核该配方？', {
										  btn: ['确认', '取消'] //可以无限个按钮
										  ,btn2: function(index, layero){
										    layer.close(index2);
										  }
										}, function(layero){
											layer.close(index2);
											var index88 = layer.open({
												  type: 1,
												  shade: 0.25,
												  area: ['400px', '350px'],
												  content: $('#nameAndTimeDiv2'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
												  success: function(layero, index){
													  form.render();
													  },
												  btn: ['确认', '取消'],
												  yes: function(layero){
													  $.ajax({
														  url:'../../updateProductRecipeStatues.do?proId='+data[0].proId,
														  data:$("#formIdOne3").serialize(),
														  type:'post',
														  dataType:'json',
														  success:function(data){
															if(data == '1'){
																//layer.msg('审核成功');
																notice.success("审核成功");
																table3.reload();
															}else{
																//layer.msg('审核失败');
																notice.error("审核失败");
															}
														  }
									                });
													  layer.close(index);
													  layer.close(index88);
													}
												  ,btn2: function(index, layero){
														  layer.close(index88);
													}
											});
										});
								}else{
									//layer.msg('该配方已审核');
									notice.warning("该配方已审核");
								}
								
							}else if(data.length >1){
								//layer.msg('一次只能为一件药品审核配方');
								notice.warning("一次只能为一件药品审核配方");
							}else {
								//layer.msg('请选择一件要审核配方的商品');
								notice.warning("请选择一件要审核配方的商品");
							}
							break;
					};
				});

				//监听查看详情事件
				table.on('tool(test)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
					var data = obj.data, //获得当前行数据
						layEvent = obj.event; //获得 lay-event 对应的值
						//管理药品
					if (layEvent === 'manageMe') {
						form.val("formAuthority", {
					    	  "proId": data.proId // "name": "value"
					    	  ,"chineseName": data.chineseName
					    	  ,"specification": data.specification
					    	  ,"proImage": data.proImage
					    	  ,"retailPrice": data.retailPrice
					    	  ,"expirationdate": data.expirationdate
					    	  ,"hqtId": data.hqtId
					    	  ,"proMan": data.proMan
					    	  ,"proDate": data.proDate
					    	});
						
						var index = layer.open({
							title : '管理药品',//标题
							type : 1,//样式
							shade: 0,
							btn: ['确认', '取消'],
							yes: function(index, layero){
								$.ajax({
									  url:'../../updateProductInfo.do',
									  data:$("#formIdOne").serialize(),
									  type:'post',
									  dataType:'json',
									  success:function(data){
										if(data == '1'){
											//layer.msg('修改成功');
											notice.success("修改成功");
											layer.close(index);
											table3.reload();
										}else{
											//layer.msg('修改失败');
											notice.error("修改失败");
										}
									  }
								  });
							}
							,btn2: function(index, layero){
								  layer.close(index);
							},
							content :$("#addDetails"),
						});
						
					}else if(layEvent === 'manageAe') {	//管理配方
						table.render({
							elem: '#test2',
							url: '../../selectThisProductMaterial.do?proId='+data.proId,
							title: '用户表',
							totalRow: true, //开启合计行
							//toolbar :"#toolbarDemo2",
							cols: [[ //表头
									{
										field: 'materialId',
										title: '原料编号',
										hide: true,
										sort: true
									}, {
										field: 'materialName',
										title: '原料名称',
										sort: true
									}, {
										field: 'supplierInfoId',
										title: '供应商ID',
										sort: true,
									}, {
										field: 'materialPrice',
										title: '单价',
										sort: true 
									}, {
										field: 'recipeStatues',
										title: '配方审核状态',
										sort: true
									}, {
										field: 'createEmpId',
										title: '配方审核人ID',
										sort: true
									}, {
										field: 'miNumber',
										title: '仓库剩余量',
										sort: true
									}, {
										title: '操作',
										align: 'center',
										toolbar: '#barDemo2'
									}
								]]
						});
						layer.open({
							title: '原料配方',
							type: 1, //Page层类型
							area: ['1000px', '520px'], //宽高
							closeBtn: 0,
							btn: ['确定', '关闭'], //可以无限个按钮
							content: $("#divTable")
						});
					}
				});
				
				//监听工具条(test2)
				table.on('tool(test2)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
					  var data = obj.data; //获得当前行数据
					  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					  var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
					 if(obj.event === 'del'){ //删除
					    layer.confirm('真的删除行么', function(index){
					      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					      $.ajax({
							  url:'../../deleteProductMaterialByPrdId.do?prdId='+data.prdId,
							  type:'post',
							  success:function(data){
								if(data == '1'){
									//layer.msg('删除成功,审核状态已变更!');
									table.reload("test2",{});
									notice.success("删除成功,审核状态已变更!");
								}else{
									//layer.msg('删除失败');
									notice.error("删除失败");
								}
							  }
		                  //return false;
		                });
					      layer.close(index);
					      //向服务端发送删除指令
					    });
					  } 
					});
			});
		</script>
		
		<div class="site-text" style="margin: 5%; display: none" id="addDetails" target="test123">
		<form class="layui-form" lay-filter="formAuthority" id="formIdOne">
			<div class="layui-input-inline">
				<div class="layui-input-inline">
      				<input type="hidden" name="proId" lay-verify="required"  placeholder="自动生成" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">药品名称</label>
				<div class="layui-input-inline">
      				<input type="text" name="chineseName" lay-verify="required" id="chineseName" placeholder="请输入" autocomplete="off" class="layui-input" onKeypress="javascript:if(event.keyCode == 32)event.returnValue = false;">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<div class="layui-input-inline">
      				<input type="hidden" name="specification" lay-verify="required" value="g" autocomplete="off" class="layui-input" disabled>
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">药品图片</label>
				<div class="layui-input-inline">
			        <select name="proImage" lay-verify="required" id="typeselectBox3">
			        </select>
			    </div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">药品类型</label>
				<div class="layui-input-inline">
			        <select name=proTypeId lay-verify="required" id="typeselectBox4">
			        </select>
			    </div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">药品价格</label>
				<div class="layui-input-inline">
      				<input type="text" name="retailPrice" id="retailPrice" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<div class="layui-input-inline">
      				<input type="hidden" name="recipeId" lay-verify="required" value="0" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<div class="layui-input-inline">
      				<input type="hidden" name="hqtId" lay-verify="required" value="1" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">保质日期</label>
				<div class="layui-input-inline">
      				<input type="text" name="expirationdate" id="expirationdate" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">制定员工</label>
				<div class="layui-input-inline">
					<input type="text" name="proMan" lay-verify="number" value="${employee.employeeId }"  class="layui-input" readonly>
				</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">制定时间</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test1" name="proDate" placeholder="yyyy-MM-dd">
				</div>
			</div>
			</form>
		</div>


	
	<!-- 制定人和制定时间 -->
<div style="display:none;" id="nameAndTimeDiv" >
<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">	  
<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">制定日期</label>
	<div class="layui-input-inline">
		<input type="text" class="layui-input" id="test66" placeholder="yyyy-MM-dd">
	</div>
</div>
<div style="padding-left:0px;margin-top:15px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">制定人员</label>
	<div class="layui-input-inline">
		<select name="city" lay-verify="" lay-search="">
  			<option value="">制定人</option>
  			<option value="010">张三</option>
  			<option value="021">李四</option>
 			<option value="0571">王五</option>
		</select>  
	</div>
<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">计划描述</label>
				<div class="layui-input-inline" style="margin-left:-5px;">
      				<textarea name="des" required lay-verify="required" cols="35px" rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
    			</div>
			</div>	
</div>
</form>
 </div>	
 
 
 <!-- 审核人和审核时间 -->
<div style="display:none;" id="nameAndTimeDiv2" >
<form class="layui-form" lay-filter="formAuthority3" id="formIdOne3">	  
<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核日期</label>
	<div class="layui-input-inline">
		<input type="text" class="layui-input" id="test5" name="proStaData" placeholder="yyyy-MM-dd">
	</div>
</div>
<div style="padding-left:0px;margin-top:15px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核人员</label>
	<div class="layui-input-inline">
		<input type="text" name="createEmpId" lay-verify="number" value="1"  class="layui-input" readonly>
	</div>
<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">备注信息</label>
				<div class="layui-input-inline" style="margin-left:-5px;">
      				<textarea name="des" required lay-verify="required" cols="35px" rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
    			</div>
			</div>	
</div>
</form>
 </div>	
</body>
</html>