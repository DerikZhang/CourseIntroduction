<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<!-- <title>Home</title>  -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${ctx }/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx }/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx }/resources/js/bootstrap.js"></script>
	<script type="text/javascript">
		$(function(){
			if(title=="lower"){
				if($("#index").hasClass("active")){
					$("#index").removeAttr("class");
				};
				$("#index").next().next().addClass("active");
			}else if(title=="higher"){
				if($("#index").hasClass("active")){
					$("#index").removeAttr("class");
				};
				$("#index").next().addClass("active");
			}else if(title=="hotter"){
				if($("#index").hasClass("active")){
					$("#index").removeAttr("class");
				};
				$("#index").next().next().next().addClass("active");
			}
		});
	</script>
</head>
<body>
<div  class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a class="btn btn-navbar" data-target=".navbar-responsive-collapse" data-toggle="collapse"></a> <a class="brand" href="#">选课攻略</a>
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav" style="width: 125%;left:-30px;">
								<li id="index" class="active"  style="width: 25%;">
									<a  style="width: 85%;padding-left:10px;padding-right:10px;" href="${ctx }/home">主页</a>
								</li>
								<li style="width: 25%;">
									<a style="width: 85%;padding-left:10px;padding-right:10px;" href="${ctx }/higher">高分榜</a>
								</li>
								<li style="width: 25%;">
									<a style="width: 85%;padding-left:10px;padding-right:10px;" href="${ctx }/lower">低分榜</a>
								</li>
								<li style="width: 25%;">
									<a style="width: 85%;padding-left:10px;padding-right:10px;" href="${ctx }/hotter">热评榜</a>
								</li>
							</ul>
						</div>
						
					</div>
				</div>
			</div>
			
			<!-- <form class="form-search" style="float:right;width:50%;">  -->
			<div id="searchDiv" style="float:left;width:70%;">
 				<input id="searchText" placeholder="老师或者课程" class="input-medium search-query" style="height:30px;width:50%;" type="text" /> 
				<button id="search"  class="btn">查找</button>
			<!-- </form> -->
			</div>
			</div>
		</div>
	</div>
</body>
</html>