<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>合同管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <link rel="stylesheet" href="../layui/css/layui.css" media="all">
  <script src="../layui/layui.js"></script>
  <script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" >
//注册table，form
layui.use(['table','form','laydate'], function(){
  var table = layui.table;
  var form = layui.form;
  var laydate = layui.laydate;
  
  //常规用法,时间选择器
  laydate.render({
    elem: '#openDate',
  });
  
  laydate.render({
	    elem: '#openDateUpdate',
   });
  table.render({
    elem: '#test',//table Id
    url:'../../selectAllBranchStore.do',//路径
    toolbar: '#toolbarDemo',
    title: '采购订单',//标题
    page: true ,//启动分页
    limit:5, //每页显示数默认
    limits: [5, 10, 15], //设置每页显示数
    cols: [[
    	{type: 'checkbox', fixed: 'left'},
        {field:'bsiId', title:'分店编号', },
        {field:'bsName', title:'分店名称', },
        {field:'bslocationPro', title:'所在省',edit: 'text', },
        {field:'bslocationCity', title:'所在城市',edit: 'text', },
        {field:'bsopendate', title:'签订时间'},
        {field:'contact', title:'联系方式'},
        {field:'email', title:'邮箱'},
        {field:'regisiteredamount', title:'注册金额'},
        {field:'standByField1', title:'是否签订合同'},
        {fixed: 'right', title:'操作', toolbar: '#barDemo'}
    ]]
    
  });
  
   //单元格编辑事件
  table.on('edit(test)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
      //console.log(obj.value); //得到修改后的值
      //console.log(obj.field); //当前编辑的字段名
      var date = obj.data; //所在行的所有相关数据  
      
    });
          
  
	//下拉框改变事件
  form.on('select(cs)', function(data){
			// 获得省份框中的值 
			var pros = document.getElementById("province123").value;
			var city = document.getElementById("city123");	
			// 将city 列表中的值清空,放置再选择省份后,出现城市乱增加的情况
			city.options.length=0;
			// 遍历
			for (var i in cityList){
				if (i==pros){
					for (var j in cityList[i]){								
						// 将 Option标签添加到Select中
						city.add(new Option(cityList[i][j],cityList[i][j]),null);									
					}
				}
			}	
			form.render();
  });     
	
	//下拉框改变事件（更新表单）
  form.on('select(csUpdate)', function(data){
			// 获得省份框中的值 
			var pros = document.getElementById("province123Update").value;
			var city = document.getElementById("city123Update");	
			// 将city 列表中的值清空,放置再选择省份后,出现城市乱增加的情况
			city.options.length=0;
			// 遍历
			for (var i in cityList){
				if (i==pros){
					for (var j in cityList[i]){								
						// 将 Option标签添加到Select中
						city.add(new Option(cityList[i][j],cityList[i][j]),null);									
					}
				}
			}	
			form.render();
  }); 
        
  var addBS;
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'audit':
    	  addBS=layer.open({
                   title:'新增分店',//标题
                   type:1,//样式
                   area:['600px','600px'],//大小
                   content:$("#form2"),
               });
               form.render();
      break;
    };
  });
  
  //声明一个变量用来接收更新窗口的index
  var updateBS;
  //监听行工具事件
  table.on('tool(test)', function(obj){
	  //得到选择的行的信息
    var data = obj.data;
	  //判断是否选中删除
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	  $.ajax({
				url:'../../deleteBranchStore.do',
				data:'id='+data.bsiId,
				success:function(back){
					if(back == '1'){
		                  layer.msg("删除成功", {icon: 6});
		                //关闭弹出框
		                  table.reload('test',{  });
		              }else{
		                  layer.msg("添加失败", {icon: 5});
		              }
				}
			})    
      });
      //编辑按钮
    } else if(obj.event === 'edit'){
    	//alert("开始编辑");
    	updateBS=layer.open({
            title:'更新分店信息',//标题
            type:1,//样式
            area:['600px','600px'],//大小
            content:$("#form3"),
            success: function(layero, index){
            	//直接将行数据填到表单中
       			form.val("exampleUpdate",data);
       			
            } 
        });
        form.render();
    }
  });
  
//自定义验证规则  
	form.verify({  
	  bsName: function(value){  
          if(value.length < 2 ){  
            return '店名至少得2个字';  
          }  
        },
       bsLocation: function(value){  
           if(value.length > 5 ){  
               return '必选地区';  
             }  
        },
       contact: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！'],
       email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']  
  });  
  
//监听提交 增加窗口
  form.on('submit(demo1)', function(data){
	     $.ajax({
          url: "../../addBrachStore.do",
          type: "POST",
          dataType: "json",
          data:data.field,//将表单中的数据
          success: function(back){
              if(back == '1'){
                  layer.msg("添加成功", {icon: 6});
                //关闭弹出框
				  layer.close(addBS);//关闭弹窗
                  table.reload('test',{  });
              }else{
                  layer.msg("添加失败", {icon: 5});
              }
              
          }
      });  
	     return false;
  }); 
  
//监听提交修改窗口
  form.on('submit(demo2)', function(data){
     //alert(data.bsName);
	     $.ajax({
          url: "../../updateBranchStore.do",
          type: "POST",
          dataType: "json",
          data:data.field,//将表单中的数据
          success: function(back){
              if(back == '1'){
                  layer.msg("修改成功", {icon: 6});
                //关闭弹出框
				  layer.close(updateBS);//关闭弹窗
                  table.reload('test',{  });
              }else{
                  layer.msg("修改失败", {icon: 5});
              }
              
          }
      });  
	     return false;
  }); 

  
  
  
});

</script>
</head>
<body>
      <table class="layui-hide" id="test1" lay-filter="test"></table>
	  <table class="layui-hide" id="test" lay-filter="test"></table>



	<script type="text/html" id="toolbarDemo">
		<div class="layui-input-inline">
 			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="audit">新增</button>
      	</div>
		<div class="layui-input-inline">
 			  <label class="layui-form-label">合同类型:</label>
      	</div>
		<div class="layui-input-inline">
 			<select  id="contractTypeChoice" lay-event="contractTypeChoice">
        		<option value="分店合同" select="selected">分店合同</option>
				<option value="采购合同">采购合同</option>
				<option value="供应商合同">供应商合同</option>
     		</select>
      	</div>
	</script>	
 
	<!-- 每一行的工具toolbar -->
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
 		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
     
     <!-- 添加分店的表单 -->
<form class="layui-form" lay-filter="example" id="form2" style="display:none;align-content:center;" >
          
   <div class="layui-form-item">
    <label class="layui-form-label">分店名称</label>
    <div class="layui-input-inline">
      <input type="text" name="bsName" lay-verify="bsName" placeholder="请输入名称" autocomplete="off" class="layui-input" required="required">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">请选择地区</label>
    <div class="layui-input-inline">
     <select  id="province123" name="bslocationPro"  onchange="changeCity()" lay-filter="cs" lay-verify="bsLocation">
        <option>请选择省/城市</option>
      </select> 
    </div>
    <div class="layui-input-inline">
      <select  id="city123" name="bslocationCity">
        <option>请选择城市/地区</option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
		<label class="layui-form-label">详细地址</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="bslocation" placeholder="详细地址" required="required">
		</div>
	</div>
	
 	<div class="layui-form-item">
		<label class="layui-form-label">开业时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="openDate" name="bsopendate" placeholder="yyyy-MM-dd">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">店长</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="empTable" placeholder="店长id" required="required">
		</div>
	</div>
  
  <div class="layui-form-item">
		<label class="layui-form-label">员工人数</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="crewSize" placeholder="员工人数" lay-verify="people">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">联系方式</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="contact" placeholder="联系方式" lay-verify="contact">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">电子邮箱</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="email" placeholder="电子邮箱" lay-verify="email">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">注册金额</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="regisiteredamount" placeholder="注册金额" lay-verify="regisiteredamount">
		</div>
	</div>
	
	<div class="layui-form-item">
    <label class="layui-form-label">签订合同</label>
    <div class="layui-input-inline">
      <select name="standByField1" placeholder="是否签订" >
        <option value="签订">签订</option>
        <option value="未签订" selected="selected" >未签订</option>
      </select>
    </div>
   </div>
   
	<div class="layui-form-item" hidden>
		<label class="layui-form-label">备用字段2</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="standByField2" placeholder="备用字段2">
		</div>
	</div>
  
   <div class="layui-form-item">
   		<br>
    	<div class="layui-input-block">
     		 <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>  
    	</div>
  	</div>
   
</form>  

  <!-- 修改分店的表单 -->
<form class="layui-form" lay-filter="exampleUpdate" id="form3" style="display:none;align-content:center;" >
    <div class="layui-form-item">
      <label class="layui-form-label">分店ID</label>
       <div class="layui-input-inline">
        <input type="text" name="bsiId" lay-verify="bsiId"  autocomplete="off" class="layui-input" readOnly>
       </div>
    </div>
       
   <div class="layui-form-item">
    <label class="layui-form-label">分店名称</label>
    <div class="layui-input-inline">
      <input type="text" name="bsName" lay-verify="bsName" placeholder="请输入名称" autocomplete="off" class="layui-input" required="required">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">请选择地区</label>
    <div class="layui-input-inline">
     <select  id="province123Update" name="bslocationPro"  onchange="changeCity()" lay-filter="csUpdate" lay-verify="bsLocation">
        <option>请选择省/城市</option>
      </select> 
    </div>
    <div class="layui-input-inline">
      <select  id="city123Update" name="bslocationCity">
        <option>请选择城市/地区</option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
		<label class="layui-form-label">详细地址</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="bslocation" placeholder="详细地址" required="required">
		</div>
	</div>
	
 	<div class="layui-form-item">
		<label class="layui-form-label">开业时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="openDateUpdate" name="bsopendate" placeholder="yyyy-MM-dd">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">店长</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="empTable" placeholder="店长id" required="required">
		</div>
	</div>
  
  <div class="layui-form-item">
		<label class="layui-form-label">员工人数</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="crewSize" placeholder="员工人数" lay-verify="people">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">联系方式</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="contact" placeholder="联系方式" lay-verify="contact">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">电子邮箱</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="email" placeholder="电子邮箱" lay-verify="email">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">注册金额</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="regisiteredamount" placeholder="注册金额" lay-verify="regisiteredamount">
		</div>
	</div>
	
	<div class="layui-form-item">
    <label class="layui-form-label">签订合同</label>
    <div class="layui-input-inline">
      <select name="standByField1" placeholder="是否签订" >
        <option value="签订">签订</option>
        <option value="未签订" >未签订</option>
      </select>
    </div>
   </div>
   
	<div class="layui-form-item" hidden>
		<label class="layui-form-label">备用字段2</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="standByField2" placeholder="备用字段2">
		</div>
	</div>
  
   <div class="layui-form-item">
   		<br>
    	<div class="layui-input-block">
     		 <button class="layui-btn" lay-filter="demo2" lay-submit="">立即提交</button>  
    	</div>
  	</div>
   
</form>  
 
</body>
</html>