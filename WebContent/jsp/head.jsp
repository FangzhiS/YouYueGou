<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
               
        	$.post("${pageContext.request.contextPath}/CategoryServlet",{method:"findCategory"},function(data){
        		
        		for(var i in data){
        			
        			$("#navsss").append("<li><a href='${pageContext.request.contextPath}/ProductServlet?method=findBycid&pageNumber=1&cid="+data[i].cid+"'>"+data[i].cname+"</a></li>");
        		}
        		
        	},"json")
        	
        })    
    
    </script>
    
    
<div class="container-fluid">

			<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img  src="${pageContext.request.contextPath}/img/logo23.png" />
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
					  <c:if test="${empty user.username }"><!-- 空的没有东西 -->
					     <li><a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a></li>
						 <li><a href="${pageContext.request.contextPath}/UserServlet?method=registerUI">注册</a></li>
					  </c:if>
					  <c:if test="${not empty user.username }">
					          欢迎：${user.username } 
					     <li><a href="${pageContext.request.contextPath}/UserServlet?method=quit">退出</a></li>
						 <li><a href="${pageContext.request.contextPath}/OrderServlet?method=findAllOrder">我的订单</a></li>
					  </c:if>

					</ol>
				</div>
			</div>
			<!--
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${pageContext.request.contextPath}">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul  id="navsss" class="nav navbar-nav">
							
							</ul>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
    