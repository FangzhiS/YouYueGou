﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员注册</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script> --%>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
       
<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
.navbar-inverse{
	           background-color: #400d0d;
	       }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
.error{
   
   color: red;
}
 </style>
 <script type="text/javascript">
 $.validator.addMethod(
			//规则的名称
			"checkUsernames",
			//校验的函数
			function(value,element,params){
				//value输入的内容
				//element:被校验的元素对象
				//params：规则对应的参数值
				var flag = false;
				$.ajax({
					"async":false,
					"type":"POST",
					"url":"${pageContext.request.contextPath}/checkUsername",
					"data":{"username":value},
					"dataType":"json",
					"success":function(data){
						flag= data.isExist;
					}
				});
			
				return !flag;
			}
			
		
		
		);
	$(function(){
		$("#forms").validate({
			rules:{
				"username":{
					"checkUsernames":true,
					"required":true
				},
				"password":{
					"required":true,
					"rangelength":[6,12]
					
				},
				"repassword":{
					"required":true,
					"rangelength":[6,12],
					"equalTo":"#confirmpwd"
				
				},
				
			},	
			 messages:{
				"username":{
					"checkUsernames":"用户名已经存在",
					"required":"用户名不能为空"
				},
				"password":{
					"required":"密码不能为空",
					"rangelength":"密码长度6-12位"
				
				},
				"repassword":{
					"required":"密码不能为空",
					"rangelength":"密码长度6-12位",
					"equalTo":"两次密码不一致"
				}
			} 
		});
		
		
		
	});
	



</script>
</head>
<body>



<%@ include file="/jsp/head.jsp" %>

<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/img/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>会员注册</font>USER REGISTER
		<form  id="forms" action="${pageContext.request.contextPath}/UserServlet"  method="post" class="form-horizontal" style="margin-top:5px;">
			 
			 <input type="hidden"  name="method"  value="register">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text"  name="username" class="form-control" id="username" placeholder="请输入用户名">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="请输入密码">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password"  style="color: black;" name="repassword" class="form-control" id="confirmpwd" placeholder="请输入确认密码">
			    </div>
			  </div>
			  
			 	 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="注册" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
	<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a>支付方式</a></li>
				<li><a>配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy;  京东商城 版权所有
		</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/messages_zh.js" type="text/javascript"></script> --%>
 <!-- <script type="text/javascript">
            $(function(){
            	
            	$("#forms").validate({
            		
            		rules:{
            			username:{
            				required:true
            			},
            			password:{
            				required:true
            			},
            			repassword:{
            				
            				equalTo:"#inputPassword3"
            			}
            			
            		}
            		
            	})
            	
            })
        
        </script> -->
</html>




