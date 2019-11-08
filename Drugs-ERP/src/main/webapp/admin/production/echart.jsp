<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/echarts.js"></script>

<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
</head>                                                                                            
<body style="margin: 5% 26% 0% 29%;">
	<!-- 2.为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="width: 600px; height: 400px;"></div>
	<script type="text/javascript">
		var myChart = echarts.init(document.getElementById('main'));
	//3.初始化，默认显示标题，图例和xy空坐标轴
		myChart.setOption({

			title : {
				text : '成品生产量展示'
			},
			tooltip : {},

			legend : {

				data : [ '生产量' ]
			},
			xAxis : {
				data : []
			},
			yAxis : {},
			series : [ {
				name : '生产量',
				type : 'bar',
				data : []
			} ]
		});

		//4.设置加载动画(非必须)
		myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

		//5.定义数据存放数组(动态变)
	 	var names = []; //建立一个类别数组（实际用来盛放X轴坐标值）
		var nums = []; //建立一个销量数组（实际用来盛放Y坐标值） 
		var brow=[];
		//6.ajax发起数据请求
		$.ajax({
			type : "post",
			url : "../../selcetFinalGoodsInventory.do", //请求发送到TestServlet
			data : {},
			dataType : "json", //返回数据形式为json
			//7.请求成功后接收数据name+num两组数据
			success : function(result) {
				//result为服务器返回的json对象
				alert(result[0].chineseName);
					//8.取出数据存入数组
					for (var i = 0; i < result.length; i++) {
						brow.push({name:result[i].chineseName,value:result[i].fgiNumber}); //迭代取出销量并填入销量数组
					}
					myChart.hideLoading(); //隐藏加载动画

					//9.覆盖操作-根据数据加载数据图表
					myChart.setOption({
					 xAxis:{
						data:names
					}, 
				/* 	series:[
						{
						name:'销量',
						type:'line',
						data:nums
					},
					{
			            name:'搜索引擎',
			            type:'line',
			            stack: '总量',
			            data:[820, 932, 901, 934, 1290, 1330, 1320]
			        }
						
				],  */
						
			 	  series : [ {
							// 根据名字对应到相应的数据
							name : '生产量',
							type:'pie',
							radius:'65%',
							center:['50%','50%'],
							label:{
							normal:{
							show:true,
							position:'inside',
							formatter:'{b},{c},{d}%'
						}	
					},
							data :brow
						} ]    
					});
 
			

			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				alert("图表请求数据失败!");
				myChart.hideLoading();
			}
		})
	</script>
</body>
</html>