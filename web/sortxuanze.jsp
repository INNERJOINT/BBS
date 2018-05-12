<%@ page language="java" import="java.util.*,model.Sort,model.SimpleUser" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>版块选择</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="static/js/jquery.min.js"></script>
		<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="static/js/transition.min.js"></script>

		<style>
			#motto {
				margin-left: 40px;
			}
			body {
				min-width: 860px;
			}
			#bannner {
				float: right;
				margin-right:120px;
				margin-top: 30px;
				
			}
		</style>
	</head>
	<body>
		<div id="bannner">
		<%if(session.getAttribute("user")==null){%>
			<a href="index.html">登录</a>/
			<a href="regedit.html">注册</a>
		<% }else{ %>
			<a target="_blank" href="Dperson?uid=<%SimpleUser su=(SimpleUser)session.getAttribute("user");
			out.print(su.getId());%>"> 
			<%out.print(su.getName());%></a>/
			<a href="loginout">登出</a>
			<% }; %>
		</div>

		<div class="bs-docs-header" id="content">
			<div class="container">
				<h1>牙膏论坛</h1>
				<p id="geyan">让您选出最适合的牙膏！！ </p>
			</div>
		</div>
		<div class="container">

			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-3">
				<% List<Sort> sl=(List<Sort>)request.getAttribute("sortlist");for(int i=0;i<4;i++){%>
					<h2><%=sl.get(i).getSortname() %></h2>

					<p><%=sl.get(i).getInfo()%></p>

					<p style="margin-left: 320px;">
						<a class="btn btn-info" href="sortpage?sortnum=<%=i+1 %>">&nbsp;进入»</a>
					</p>
					<% }%>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
		
	</body>

</html>