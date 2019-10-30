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
layui.use(['table','form','laydate','jquery'], function(){
  var table = layui.table;
  var form = layui.form;
  var laydate = layui.laydate;
  var $=layui.jquery;
  
  //常规用法,时间选择器
  laydate.render({
    elem: '#conEffectTime',
  });
  laydate.render({
	    elem: '#conLostEffectTime',
   });
  laydate.render({
	    elem: '#conEndTime',
 });
  laydate.render({
	    elem: '#conAuditTime',
 });
  table.render({
    elem: '#test',//table Id
    url:'../../getAllContract.do',//路径
    toolbar: '#toolbarDemo',
    title: '合同列表',//标题
    page: true ,//启动分页
    limit:5, //每页显示数默认
    limits: [5, 10, 15], //设置每页显示数
    cols: [[
    	{type: 'checkbox', fixed: 'left'},
        {field:'conID', title:'合同ID', hide:true },
        {field:'conName', title:'合同名称', },
        {field:'conType', title:'合同类型',},
        {field:'conNum', title:'合同编号',},
        {field:'partyA', title:'甲方'},
        {field:'partyB', title:'乙方'},
        {field:'totalPrice', title:'合同总金额',},
        {field:'conState', title:'合同状态'},
        {field:'conChange', title:'是否变更',hide:true},
        {field:'conUndertakerId', title:'承办人ID',hide:true},
        {field:'conContact', title:'联系电话'},
        {field:'partyBId', title:'供应商或分店ID',hide:true},
        {field:'conAuditTime', title:'合同签订时间'},
        {field:'conEffectTime', title:'合同生效时间'},
        {field:'conLostEffectTime', title:'合同失效时间'},
        {field:'note', title:'备注'},
        {fixed: 'right', title:'操作', toolbar: '#barDemo'}
    ]]
    
  });
  
   //单元格编辑事件
  table.on('edit(test)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
      //console.log(obj.value); //得到修改后的值
      //console.log(obj.field); //当前编辑的字段名
      var date = obj.data; //所在行的所有相关数据  
      
    });
   
//监听行双击事件
  table.on('rowDouble(test)', function(obj){
    //obj 同上
    layer.msg("这里会有一张合同表");
  });
          
  
	//下拉框改变事件,根据选择的不同下拉框内容产生不同事件
  form.on('select(conType)', function(data){
		// 根据不同的合同类型显示不同的div
		switch(data.value){
	      case '分店合同':
		    	 $("#gys").hide();
				 $("#fd").show();
				 $("#cgdd").hide();
	    	 break;
	      case '采购合同':
		    	  $("#gys").hide();
				  $("#fd").hide();
				  $("#cgdd").show();
	    	  break;
	      case '供应商合同':
	    	 	 $("#gys").show();
				 $("#fd").hide();
				 $("#cgdd").hide();
	    	  break;
	      case '合同类型':
    	  	 alert("啥都没有");
	    	 	 $("#gys").hide();
				 $("#fd").hide();
				 $("#cgdd").hide();
    	 	 break;
	      /* case 'contractTypeChoice':
	    	alert(obj.value);
	      break; */
	    };
  });     
	
	//下拉框改变事件,头工具栏中的select选择表格中显示的合同类型
  form.on('select(contractTypeChoice)', function(data){
		alert(data.value);
		
		
  }); 
	 
  var addBS;
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id)
    ,data = checkStatus.data; //选中行的数据
    switch(obj.event){
      case 'audit':
    	  addBS=layer.open({
                   title:'新增合同',//标题
                   type:1,//样式
                   area:['600px','600px'],//大小
                   content:$("#form2"),
               });
               form.render();
      break;
      case 'delete':
    	 if(data.length === 0){
              layer.msg('请选择一行');
           } else if(data.length > 1){
        	  layer.msg('只能选择一行');
           }else {
        	   layer.msg(data[0].conID);
        	   /* layer.confirm('真的永久删除该合同么', function(index){
           	  $.ajax({
       				url:'../../lostContract.do',
       				data:'id='+data.conID,
       				success:function(back){
       					if(back == '1'){
       		                  layer.msg("删除失效成功", {icon: 6});
       		                //关闭弹出框
       		                  table.reload('test',{  });
       		              }else{
       		                  layer.msg("删除失效失败", {icon: 5});
       		              }
       				}
       			})    
             }); */ 
           }
      break;
      /* case 'contractTypeChoice':
    	alert(obj.value);
      break; */
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
      layer.confirm('真的失效该合同么', function(index){
    	  $.ajax({
				url:'../../lostContract.do',
				data:'id='+data.conID,
				success:function(back){
					if(back == '1'){
		                  layer.msg("合同失效成功", {icon: 6});
		                //关闭弹出框
		                  table.reload('test',{  });
		              }else{
		                  layer.msg("合同失效失败", {icon: 5});
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
        conContact: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！'],
       email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']  
  });  
  
//监听提交 增加窗口
  form.on('submit(demo1)', function(data){
	     $.ajax({
          url: "../../addContract.do",
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
 			<button type="button" class="layui-btn layui-btn-sm" lay-event="audit"><i class="layui-icon"></i></button>
			<button type="button" class="layui-btn layui-btn-sm" lay-event="delete"><i class="layui-icon">永久删除</i></button>
      	</div>
		 <!-- 下拉框改变页面显示的合同内容 -->
     	<div class="layui-input-inline">
 			<select  id="contractTypeChoice" lay-filter="contractTypeChoice">
				<option disabled  selected hidden>--------合同类型------</option>
        		<option value="分店合同" >分店合同</option>
				<option value="采购合同">采购合同</option>
				<option value="供应商合同">供应商合同</option>
     		</select>
      	</div>
	</script>	
 
	<!-- 每一行的工具toolbar -->
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
 		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">失效</a>
	</script>
     
    
     <!-- 添加合同的表单 -->
<form class="layui-form" lay-filter="example" id="form2" style="display:none;align-content:center;" >
          
   <div class="layui-form-item">
    <label class="layui-form-label">合同名称</label>
    <div class="layui-input-inline">
      <input type="text" name="conName" lay-verify="conName" placeholder="请输入名称" autocomplete="off" class="layui-input" required="required">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">合同类型</label>
    <div class="layui-input-inline">
     <select  name="conType"  lay-verify="conType" onchange="conType()" lay-filter="conType">
        <option value="分店合同" selected>分店合同</option>
		<option value="采购合同">采购合同</option>
		<option value="供应商合同">供应商合同</option>
      </select> 
    </div>
  </div>
  
  <div class="layui-form-item" hidden>
		<label class="layui-form-label">合同编号</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="conNum" placeholder="详细地址" required="required">
		</div>
	</div>
	
 	<div class="layui-form-item">
		<label class="layui-form-label">甲方名称</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="partyA" name="partyA" placeholder="甲方名称" required="required">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">乙方名称</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="partyB" placeholder="乙方名称" required="required">
		</div>
	</div>
  
  <div class="layui-form-item">
		<label class="layui-form-label">合同总金额</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="totalPrice" placeholder="合同金额" lay-verify="totalPrice" required="required">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">合同状态</label>
		<div class="layui-input-inline">
			<select  name="conState"  lay-verify="conState" onchange="conState()" lay-filter="cs">
        		<option disabled selected hidden>--------合同状态------</option>
        		<option value="草稿">草稿</option>
				<option value="生效" selected="selected">生效</option>
				<option value="作废">作废</option>
      		</select> 
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">是否变更</label>
		<div class="layui-input-inline">
			<select  name="conChange"  lay-verify="conChange" onchange="conChange()" lay-filter="cs">
        		<option value="否" selected>否</option>
				<option value="是">是</option>
      		</select> 
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">承办人id</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="conUndertakerId" placeholder="承办人id" lay-verify="conUndertakerId" required="required">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">联系电话</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="conContact" placeholder="联系电话" lay-verify="conContact" required="required">
		</div>
	</div>
	
	<div class="layui-form-item" id="gys" hidden >
		<label class="layui-form-label">供应商id</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="partyBId" placeholder="供应商id" lay-verify="partyBId" required="required">
		</div>
	</div>
	
	<div class="layui-form-item" id="fd">
		<label class="layui-form-label"  >分店id</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="partyBId" placeholder="分店id" lay-verify="partyBId" required="required">
		</div>
	</div>
	
	<div class="layui-form-item" id="cgdd" hidden >
		<label class="layui-form-label">采购订单id</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" name="partyBId" placeholder="采购订单id" lay-verify="partyBId" required="required">
		</div>
	</div>
	
	<div class="layui-form-item" >
		<label class="layui-form-label">合同生效时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="conEffectTime" name="conEffectTime" placeholder="合同生效时间" lay-verify="conEffectTime" required="required">
		</div>
	</div>
	
	<div class="layui-form-item" >
		<label class="layui-form-label">合同失效时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="conLostEffectTime" name="conLostEffectTime" placeholder="合同生效时间" lay-verify="conLostEffectTime" required="required">
		</div>
	</div>
	
	<div class="layui-form-item">
		<label class="layui-form-label">合同结束时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="conEndTime" name="conEndTime" placeholder="合同结束时间" lay-verify="conEndTime" required="required">
		</div>
	</div> 
	
	<div class="layui-form-item">
		<label class="layui-form-label">合同签订时间</label>
		<div class="layui-input-inline">
			<input type="text" class="layui-input" id="conAuditTime" name="conAuditTime" placeholder="合同签订时间" lay-verify="conAuditTime" required="required">
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
			<input type="text" class="layui-input" name="standByField1" placeholder="备用字段2">
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