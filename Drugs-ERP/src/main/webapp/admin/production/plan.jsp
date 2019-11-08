<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>月生产计划</title>
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
<style>
/*table外边距*/
.layui-table, .layui-table-view {
	margin: 0px 0;
}
/*弹出层table外边距*/
.layui-table, .layui-table-view {
	margin: 0px;
	padding: 0px;
	margin-bottom: 0px;
}
</style>
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
	<div id="table2Div" style="width:100%;height:100%;">
		<table class="layui-hide" style="display: none;" id="test2"
			lay-data="{id: 'idTest'}" lay-filter="test2"></table>
	</div>
	
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container" style="margin-top:20px;padding-left:20px;">
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-add-1"></i>制定月计划 </button>
<<<<<<< HEAD
=======
	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="details"><i class="layui-icon layui-icon-edit"></i>修改月计划</button>
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckLength"><i class="layui-icon layui-icon-add-1"></i>制定日计划</button>
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="isAll"><i class="layui-icon layui-icon-survey"></i>审核月计划</button>
  </div>
</script>

<div id="toolbarDemo2" style="display:none">
<form class="layui-form" action="javaScript:void(0)" id="we" method="post" lay-filter="formTest">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;">
<legend>添加采购商品</legend>
</fieldset>
	<div class="layui-inline" style="padding-left:0px;">
	    <div class="layui-inline">
      <label class="layui-form-label">药品名</label>
      <div class="layui-input-inline">
        <select name="proId" lay-verify="required" id="typeselectBox">
        </select>
      </div>
    </div>
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">输入生产数量</label>
	<div class="layui-input-inline">
		 <input type="text" name="produceNum" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input">
	</div>
	<button class="layui-btn layui-btn-normal" lay-event="update" lay-filter="tianjia">添加</button>
  </div>
 </form>	
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<script type="text/html" id="barDemo2">
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="manageMe">删除</a>
	</script>
	<script>
		layui.use([ 'table', 'laydate', 'element', 'form', 'layer' ,'notice'],
				function() {
					var $ = layui.jquery; 
					var layer = layui.layer;
					var element = layui.element;
					var table = layui.table;
					var laydate = layui.laydate;
					var form = layui.form;
					var notice = layui.notice;
					
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
					
					var option = "<option value='-1'>请选择药品</option>";//初始化option的选项
			        $.ajax({
			            url: "../../getChineseName.do",
			            type: 'POST'
			        })
			        .done(function(data) {
			            for(var i=0;i<data.length;i++){                	
			                option+="<option value='"+data[i]['proId']+"'>"+data[i]['chineseName']+"</option>";//拼接option中的内容
			                	$("#typeselectBox").html(option);//将option的拼接内容加入select中，注意选择器是select的ID
			            }
			            form.render('select');//重点：重新渲染select
			        })
			        .fail(function() {
			            console.log("error");
			        });
		

					var table2=table.render({
						elem : '#test',
						url : '../../getAllMonthPlan.do',
						toolbar : '#toolbarDemo',
						title : '用户数据表',
						cols : [ [ {
							type : 'checkbox',
						}, {
							field : 'monthPlanId',
							title : '月计划编号',
							unresize : true
						}, {
							field : 'monthPlanNum',
							title : '生产总数量',
							edit: 'text',
							unresize : true
						}, {
							field : 'monthPlanRealNum',
							title : '实际生产总数量',
							hide : true,
							edit: 'text',
							unresize : true
						}, {
							field : 'monthStartTime',
							title : '开始时间',
							hide : true,
							unresize : true
						}, {
							field : 'monthCompleteTime',
							title : '结束时间',
							hide : true,
							unresize : true
						}, {
							field : 'monthApplicationTime',
							title : '申请时间',
							unresize : true
						}, {
							field : 'employeeId',
							title : '申请发起人编号',
							unresize : true
						}, {
							field : 'reviewDate',
							title : '审核时间',
							unresize : true
						}, {
							field : 'reviewStatus',
							title : '审核状态',
							unresize : true
						}, {
							field : 'visibles',
							title : '显示状态',
							hide : true,
							unresize : true
						}, {
							field : 'proState',
							title : '生产状态',
							unresize : true
						}, {
							field : 'empId',
							title : '审核人编号',
							unresize : true
						}, {
<<<<<<< HEAD
							
=======
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
							width : 178,
							align : 'center',
							toolbar : '#barDemo',
							unresize : true
						} ] ],
						page : true
						,limit:10
						,limits:[10,20,30,50]   
					});

					//年月选择器
					laydate.render({
						elem : '#test3',
						type : 'month'
					});
					//常规用法
					laydate.render({
						elem : '#test5'
						,type: 'datetime'
					});
					//常规用法
					laydate.render({
						elem : '#test1'
						,type: 'datetime'
					});

					//工具栏事件
					table.on('toolbar(test)', function(obj) {
						var checkStatus = table.checkStatus(obj.config.id);
						switch (obj.event) {
						case 'getCheckData':
							var index = layer.open({
								title : '制定计划详情',//标题
								type : 1,//样式
								shade : 0,
								offset : [ '5%', '15%' ],//设置位移
								btn : [ '确认', '取消' ], 
								yes : function(index, layero) {
									//点击确认添加,验证是否添加了商品
									$.ajax({
										  url:'../../selectMonthPlanDetailIfNull.do',
										  type:'post',
										  dataType:'json',
										  success:function(data){
											if(data != '0'){
												var index2 = layer.confirm('你确认制定该生产计划？', {
													btn : [ '确认', '取消' ] //可以无限个按钮
													,
													btn2 : function(index, layero) {
														layer.close(index2);
													}
												}, function(layero) {
													layer.close(index2);
													var index88 = layer.open({
														type : 1,
														shade : 0.25,
														area : [ '400px', '350px' ],
														content : $('#nameAndTimeDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
														success : function(layero, index) {
															form.render();
														},
														btn : [ '确认', '取消' ],
														yes : function(layero) {
															$.ajax({
																  url:'../../insertAndUpdate.do',
																  data:$("#formIdOne").serialize(),
																  type:'post',
																  dataType:'json',
																  success:function(data){
																	if(data == '1'){
																		//layer.msg('执行成功');
																		notice.success("执行成功");
																		table2.reload();
																	}else{
																		//layer.msg('执行失败');
																		notice.error("执行失败");
																	}
																  }
											                  //return false;
											                }); 
															layer.close(index);
															layer.close(index88);
														},
														btn2 : function(index, layero) {
															layer.close(index88);
														}
													});
												});
											}else{
												//layer.msg('请添加商品');
												notice.warning("请添加商品");
											}
										  }
					                }); 
								},
								btn2 : function(index, layero) {
									layer.close(index);
								},
								area : [ '880px', '550px' ],
								content : $("#table2Div"),
								success : function(layero) {
									var mask = $(".layui-layer-shade");
									mask.appendTo(layero.parent());
								},
								end : function() {
									$('[lay-id="test2"]').css("display", "none");
								}
							});
							
							//监听事件
							table.on('toolbar(test2)', function(obj){
							  var checkStatus = table.checkStatus(obj.config.id);
							  switch(obj.event){
							    case 'update':
							    	//监听button
						            	//获取表单区域所有值
						            	//alert(data.field.titletype);
						            	//console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
<<<<<<< HEAD
						            	$.ajax({
=======
							    	var typeselectBox = $("#typeselectBox").val();
									var produceNum = $("#produceNum").val();
									if(typeselectBox == '-1'||produceNum == ''||produceNum <= '0'){
										/* layer.msg('信息有误', {
						            		  icon: 2,
						            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
						            		}); */
										notice.info("信息有误");
									}else{
										$.ajax({
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
											  url:'../../insertMonthPlanDetails.do',
											  data:$("#we").serialize(),
											  type:'post',
											  dataType:'json',
											  success:function(data){
												if(data == '1'){
<<<<<<< HEAD
													layer.msg('添加成功');
													table.render({
														elem : '#test2',
														url : '../../selectMonthPlanDetails.do',
														toolbar : '#toolbarDemo2',
														totalRow : true,
														cols : [ [ {
															type : 'numbers'
														}, {
															field : 'monthPlanDetailId',
															title : '药品详情编号',
															hide : true,
															unresize : true
														}, {
															field : 'proId',
															title : '药品编号',
															unresize : true
														}, {
															field : 'chineseName',
															title : '药品名称',
															edit : 'text',
															unresize : true
														}, {
															field : 'produceNum',
															title : '生产数量',
															totalRow : true,
															edit : 'text',
															unresize : true
														}, {
															align : 'center',
															toolbar : '#barDemo2',
															unresize : true
														} ] ]
													});
=======
													//layer.msg('添加成功');
													notice.success("添加成功");
													table3.reload();
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
												}else{
													//layer.msg('添加失败');
													notice.error("添加失败");
												}
											  }
						                  //return false;
						                }); 
							    break;
							  };
							});
							
							table.render({
								elem : '#test2',
								url : '../../selectMonthPlanDetails.do',
								toolbar : '#toolbarDemo2',
								totalRow : true,
								cols : [ [ {
									type : 'numbers'
								}, {
									field : 'monthPlanDetailId',
									title : '药品详情编号',
									hide : true,
									unresize : true
								}, {
									field : 'proId',
									title : '药品编号',
									unresize : true
								}, {
									field : 'chineseName',
									title : '药品名称',
									edit : 'text',
									unresize : true
								}, {
									field : 'produceNum',
									title : '生产数量',
									totalRow : true,
									edit : 'text',
									unresize : true
								}, {
									align : 'center',
									toolbar : '#barDemo2',
									unresize : true
								} ] ]
							});
<<<<<<< HEAD
=======
							break;
						case 'details':
							if (data.length == 1) {
								var index = layer.open({
									type : 1,//样式
									shade : 0,
									offset : [ '5%', '15%' ],//设置位移
									btn : [ '确认', '取消' ], 
									yes : function(index, layero) {
										/* //点击确认添加,验证是否添加了商品
										$.ajax({
											  url:'../../selectMonthPlanDetailIfNullAgain.do?monthPlanId='+data[0].monthPlanId,
											  type:'post',
											  dataType:'json',
											  success:function(data){
												if(data != '0'){
													
												}else{
													layer.msg('请添加商品');
												}
											  }
						                });  */
											var index88 = layer.open({
												type : 1,
												shade : 0.25,
												area : [ '400px', '350px' ],
												content : $('#nameAndTimeDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
												success : function(layero, index) {
													form.render();
												},
												btn : [ '确认', '取消' ],
												yes : function(layero) {
														$.ajax({
															  url:'../../insertAndUpdateAgain.do?monthPlanId='+data[0].monthPlanId,
															  data:$("#formIdOne").serialize(),
															  type:'post',
															  dataType:'json',
															  success:function(data){
																if(data == '1'){
																	//layer.msg('执行成功');
																	notice.success("执行成功");
																	table2.reload();
																}else{
																	//layer.msg('执行失败');
																	notice.error("执行失败");
																}
															  }
										                  //return false;
										                }); 
														layer.close(index);
														layer.close(index88);
												},//yes按钮结束
												btn2 : function(index, layero) {
													layer.close(index88);
												}
											});
									},
									btn2 : function(index, layero) {
										layer.close(index);
									},
									area : [ '880px', '550px' ],
									content : $("#table2Div"),
									success : function(layero) {
										var mask = $(".layui-layer-shade");
										mask.appendTo(layero.parent());
									},
									end : function() {
										$('[lay-id="test2"]').css("display", "none");
									}
								});
								
								//监听事件
								table.on('toolbar(test2)', function(obj){
								  var checkStatus = table.checkStatus(obj.config.id);
								  switch(obj.event){
								    case 'update2':
								    	//监听button
							            	//获取表单区域所有值
							            	//alert(data.field.titletype);
							            	//console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
								    	var typeselectBox1 = $("#typeselectBox1").val();
										var produceNum2 = $("#produceNum2").val();
										if(typeselectBox1 == '-1'||produceNum2 == ''||produceNum2 <= '0'){
											/* layer.msg('信息有误', {
							            		  icon: 2,
							            		  time: 2000 //2秒关闭（如果不配置，默认是3秒）
							            		}); */
											notice.info("信息有误");
										}else{
											$.ajax({
												  url:'../../insertMonthPlanDetailsAgain.do?monthPlanId='+data[0].monthPlanId,
												  data:$("#wo").serialize(),
												  type:'post',
												  dataType:'json',
												  success:function(data){
													if(data == '1'){
														//layer.msg('添加成功');
														notice.success("添加成功");
														table.reload("test",{});
														table4.reload();
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
								
								var table4 = table.render({
									elem : '#test2',
									url : '../../selectMonthPlanDetailsAgain.do?monthPlanId='+data[0].monthPlanId,
									toolbar : '#toolbarDemo3',
									cols : [ [ {
										type : 'numbers'
									}, {
										field : 'monthPlanId',
										title : '月计划编号',
										unresize : true
									}, {
										field : 'monthPlanDetailId',
										title : '月计划详情编号',
										hide : true,
										unresize : true
									}, {
										field : 'proId',
										title : '药品编号',
										unresize : true
									}, {
										field : 'chineseName',
										title : '药品名称',
										edit : 'text',
										unresize : true
									}, {
										field : 'produceNum',
										title : '生产数量',
										edit : 'text',
										unresize : true
									}, {
										align : 'center',
										toolbar : '#barDemo2',
										unresize : true
									} ] ]
								});
								
							} else if (data.length > 1) {
								//layer.msg('最多只能选择一条月计划');
								notice.warning("最多只能选择一条月计划");
							} else {
								//layer.msg('请选择一条月计划');
								notice.warning("请选择一条月计划");
							}
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
							break;
						case 'getCheckLength':
							var data = checkStatus.data;
							if (data.length == 1) {
								//判断月计划审核状态
								if (data[0].reviewStatus == '已审核') {
									var index2 = layer.confirm('你确认制定该生产日计划？', {
										btn : [ '确认', '取消' ] //可以无限个按钮
										,
										btn2 : function(index, layero) {
											layer.close(index2);
										}
									}, function() {
										$.ajax({
											  url:'../../insertDailyplan.do',
											  data:{'monthPlanId':data[0].monthPlanId,'monthPlanNum':data[0].monthPlanNum},
<<<<<<< HEAD
											  type:'post'
											  ,
=======
											  type:'post',
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
											  dataType:'json',
											  success:function(data){
													  //layer.msg('日计划制定成功,可到日生产计划查看详情');
													  notice.success("日计划制定成功,可到日生产计划查看详情");
													  table2.reload(); 
											  }
						                  //return false;
						                }); 

									});
								} else {
									//layer.msg('该月计划未审核');
									notice.warning("该月计划未审核");
								}

							} else if (data.length > 1) {
								//layer.msg('最多只能选择一条月计划');
								notice.warning("最多只能选择一条月计划");
							} else {
								//layer.msg('请选择一条月计划');
								notice.warning("请选择一条月计划");
							}
							break;
						case 'isAll':
							var data = checkStatus.data;
							if (data.length == 1) {
								//判断月计划审核状态
								if (data[0].reviewStatus == '未审核') {
									var index2 = layer.confirm('你确认审核该生产计划？', {
										btn : [ '确认', '取消' ] //可以无限个按钮
										,
										btn2 : function(index, layero) {
											layer.close(index2);
										}
									}, function(layero) {
										layer.close(index2);
										var index88 = layer.open({
											type : 1,
											shade : 0.25,
											area : [ '400px', '350px' ],
											content : $('#nameAndTimeDiv2'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
											success : function(layero, index) {
												form.render();
											},
											btn : [ '确认', '取消' ],
											yes : function(layero) {
												$.ajax({
													  url:'../../updateThisMonthPlanReviewStatus.do?monthPlanId='+data[0].monthPlanId,
													  data:$("#formIdOne2").serialize(),
													  type:'post',
													  dataType:'json',
													  success:function(data){
														  if(data == '1'){
															  //layer.msg('计划审核成功');
															  notice.success("计划审核成功");
															  table2.reload();
														  }else{
															  //layer.msg('计划审核失败');
															  notice.error("计划审核失败");
														  }
													  }
								                  //return false;
								                }); 
												layer.close(index);
												layer.close(index88);
											},
											btn2 : function(index, layero) {
												layer.close(index88);
											}
										});

									});
								} else {
									//layer.msg('该月计划已审核');
									notice.warning("该月计划已审核");
								}

							} else if (data.length > 1) {
								//layer.msg('最多只能审核一条月计划');
								notice.warning("最多只能审核一条月计划");
							} else {
								//layer.msg('请选择一条要审核月计划');
								notice.warning("请选择一条要审核月计划");
							}
							break;
						}
						;
					});

					//监听工具条(test)
					table.on('tool(test)', function(obj) {
						var data = obj.data; //获得当前行数据
						var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
						var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
						if (obj.event === 'detail') {
							layer.open({
								title : '计划详情',//标题
								type : 1,//样式
								shade : 0,
								offset : [ '5%', '15%' ],//设置位移
								area : [ '880px', '433px' ],
								content : $("#table2Div"),
								success : function(layero) {
									var mask = $(".layui-layer-shade");
									mask.appendTo(layero.parent());
									//其中：layero是弹层的DOM对象
								},
								end : function() {
									$('[lay-id="test2"]')
											.css("display", "none");
								}
							});
							table.render({
								elem : '#test2',
								url : '../../getPlanDetails.do?monthPlanId='+data.monthPlanId,
								totalRow : true,
								cols : [ [ {
									type : 'numbers'
								}, {
									field : 'proId',
									title : '药品编号',
									unresize : true
								}, {
									field : 'proImage',
									title : '药品图片描述',
									unresize : true,
									templet:'<div><img  src="{{ d.proImage }}"></div>'
								}, {
									field : 'chineseName',
									title : '药品名称',
									unresize : true
								}, {
									field : 'produceNum',
									title : '生产数量',
									totalRow : true,
									unresize : true
								} ] ]
							});
						} else if (obj.event === 'del') {
							layer.confirm('确认删除该计划吗？', function(index) {
								$.ajax({
									  url:'../../deleteThisMonthPlan.do?monthPlanId='+data.monthPlanId,
									  type:'post',
									  success:function(data){
										if(data == '1'){
											//layer.msg('删除成功');
											notice.success("删除成功");
											table2.reload();
										}else{
											//layer.msg('删除失败');
											notice.error("删除失败");
										}
									  }
				                  //return false;
				                }); 
								layer.close(index);
							});
						} else if (obj.event === 'edit') {
							if (data.reviewStatus == '未审核') {
								/* layer.alert('当前订单未审核,无法修改生产状态', {
									icon : 2
								}); */
								notice.warning("当前订单未审核,无法修改生产状态");
							} else if (data.reviewStatus == '已审核') {

								var index = layer.open({
									title : '修改计划详情',//标题
									type : 1,//样式
									shade : 0,
									offset : [ '5%', '15%' ],//设置位移
									btn : [ '确认', '取消' ],
									yes : function(index, layero) {
											layer.close(index);
									},
									btn2 : function(index, layero) {
										layer.close(index);
									},
									area : [ '880px', '550px' ],
									content : $("#table2Div"),
									success : function(layero) {
										var mask = $(".layui-layer-shade");
										mask.appendTo(layero.parent());
										//其中：layero是弹层的DOM对象
									},
									end : function() {
										$('[lay-id="test2"]').css("display",
												"none");
									}
								});
								
								table.render({
									elem : '#test2',
									url : '../../selectThisMonthPlan.do?monthPlanId='+data.monthPlanId,
									//toolbar : '#toolbarDemo2',
									totalRow : true,
									cols : [ [ {
										type : 'numbers'
									}, {
										field : 'monthPlanId',
										title : '月计划编号',
										unresize : true
									}, {
										field : 'monthStartTime',
										title : '开始时间',
										event: 'dates', 
										edit: 'text',
										data_field: 'monthStartTime',
										unresize : true
									}, {
										field : 'monthCompleteTime',
										title : '结束时间',
										event: 'dates',
										edit: 'text',
										data_field: 'monthCompleteTime',
										unresize : true
									}, {
										field : 'monthPlanNum',
										title : '生产总数量',
										unresize : true
									}, {
										field : 'monthPlanRealNum',
										title : '实际生产总数量',
										edit: 'text',
										unresize : true
									}] ],
								});
								
								//监听单元格事件
								table.on('tool(test2)', function (obj) {
									var data = obj.data;
									var newdata = {};
									if (obj.event === 'dates') {
										var field = $(this).data('field');
										laydate.render({
										elem: this.firstChild
										, show: true //直接显示
										, closeStop: this
										, type: 'datetime'
										//, format : 'yyyy-MM-dd HH:mm:ss'
										, done: function (value, date) {
											newdata[field] = value;
											obj.update(newdata);
											//layui.event("test2", "dates", obj)
										}
										});
									}
								});  
							}
						}
					});
					
					
					//监听单元格编辑
					  table.on('edit(test2)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
						  $.ajax({
							  url:'../../updateThisMonthPlan.do',
							  data:obj.data,
							  type:'post',
							  dataType:'json',
							  success:function(data){
								if(data == '1'){
<<<<<<< HEAD
									layer.msg('修改成功');
									table2.reload();
=======
									//layer.msg('修改成功');
									notice.success("修改成功");
									table.reload('test',{});
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
								}else{
									//layer.msg('修改失败');
									notice.error("修改失败");
								}
							  }
						  });
						});
					
					  /* table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
						  var data = obj.data; //获得当前行数据
						  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
						  var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
						 
						  if(layEvent === 'detail'){ //查看
						    //do somehing
						  } else if(layEvent === 'del'){ //删除
						    layer.confirm('真的删除行么', function(index){
						      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
						      layer.close(index);
						      //向服务端发送删除指令
						    });
						  } else if(layEvent === 'edit'){ //编辑
						    //do something
						    
						    //同步更新缓存对应的值
						    obj.update({
						      username: '123'
						      ,title: 'xxx'
						    });
						  } else if(layEvent === 'LAYTABLE_TIPS'){
						    layer.alert('Hi，头部工具栏扩展的右侧图标。');
						  }
						}); */
						//
						//监听工具条(test2)
						table.on('tool(test2)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
							  var data = obj.data; //获得当前行数据
							  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
							  var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
							 if(obj.event === 'manageMe'){ //删除
							    layer.confirm('真的删除行么', function(index){
							      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
							      $.ajax({
									  url:'../../deleteThisMonthPlanDetailId.do?monthPlanDetailId='+data.monthPlanDetailId,
									  type:'post',
									  success:function(data){
										if(data == '1'){
<<<<<<< HEAD
											layer.msg('删除成功');
											table2.reload();
=======
											//layer.msg('删除成功');
											notice.success("删除成功");
											table.reload("test2",{});
											table.reload("test",{});
											/* notice.warning("成功");
											notice.info("提示信息：毛都没有...");
											notice.error("大佬，我咋知道怎么肥四！");
											notice.success("大佬，我咋知道怎么肥四！"); */
>>>>>>> branch 'master' of https://github.com/luobotie/DrugsERP.git
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
					//监听下拉框
					  /* form.on('select(selectvalues)', function(data){
						  //console.log(data.elem); //得到select原始DOM对象
						  //console.log(data.value); //得到被选中的值
						  //console.log(data.othis); //得到美化后的DOM对象
						  alert(data.value);
						}); */ 

				});
		
	</script>

	<!-- 制定人和制定时间 -->
	<div style="display: none;" id="nameAndTimeDiv">
		<form class="layui-form" lay-filter="formAuthority" id="formIdOne">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">制定日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test1" name="monthApplicationTime"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">制定人员</label>
				<div class="layui-input-inline">
					<select name="city" lay-verify="" lay-search="">
						<option value="">制定人</option>
						<option value="010">张三</option>
						<option value="021">李四</option>
						<option value="0571">王五</option>
					</select>
				</div>
				<div class="layui-input-inline" style="margin-top: 10px;">
					<label style="margin: 0 10px 0 20px; font-size: 13px;">计划描述</label>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<textarea name="des" required lay-verify="required" cols="35px"
							rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- 审核人和审核时间 -->
	<div style="display: none;" id="nameAndTimeDiv2">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test5" name="reviewDate"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核人员</label>
				<div class="layui-input-inline">
					<select name="city" lay-verify="" lay-search="">
						<option value="">制定人</option>
						<option value="010">张三</option>
						<option value="021">李四</option>
						<option value="0571">王五</option>
					</select>
				</div>
				<div class="layui-input-inline" style="margin-top: 10px;">
					<label style="margin: 0 10px 0 20px; font-size: 13px;">备注信息</label>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<textarea name="des" required lay-verify="required" cols="35px"
							rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
