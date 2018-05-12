<%@ page language="java" import="java.util.*,model.BbsUser,model.SimpleUser" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%BbsUser person=(BbsUser)request.getAttribute("person");
		SimpleUser su=(SimpleUser)session.getAttribute("user");
		String sex="";
		if(person.getSex()==2){
			sex="女";
		}else{
			sex="男";
		}
	 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
		<title><%=person.getName() %></title>
		<link rel="stylesheet" href="static/css/bootstrap.css" />
		<style>
			body{
				
				
			}
			#main {
				width: 250px;
				margin: 0 auto;
				position: relative;
				
				left: -10px;
			}
			
			img {
				height: 150px;
				width: 150px;
				margin-top:25px;
				margin-left:25px;
			}
			#baoguo{
				height: 200px;
				width: 200px;
				margin-top:25px;
				margin-left:25px;
			}
			.panel{
				width: 250px;
				
				
			}
			#twobtn{
				height: 150px;
				width: 150px;
				position: relative;
				top:-350px;
				left: 250px;
			}
			#twobtn a{
				margin-top: 10px;
				
			}
		</style>

	</head>

	<body>
	
		<div id="main" >
			<div id="baoguo">
				<img src="static/pic/user<%=person.getAvatarid() %>.jpg" />
			</div>
			<div id="info" class="panel">
				<p style="text-align: center;"><%=person.getName() %></p>
				<p style="text-align: center;"><%if(person.getSignature()!=null)out.print(person.getSignature());else out.print("这个人很懒什么都没有留下"); %></p>
				<p>性别:<%=sex %></p>
				<p>注册时间:<%=person.getJoindate() %></p>
				<p>生日:<%=person.getBirth() %></p>
				<p>邮箱:<%=person.getEmail() %></p>
				<p>手机号码:<%=person.getTel() %></p>
				<p>等级:<%=person.getLv() %></p>
			</div>
			<% if(session.getAttribute("user")!=null){
					if(person.getId()==su.getId()){
			%>
			<div id="twobtn">
			<a class="btn btn-primary btn-sm" href="bianjiziliao" >编辑个人资料</a>
			<a class="btn btn-primary btn-sm" href="touxiangxuanze.html">选择头像</a>
			</div>
			<%}} %>
		</div>
	</body>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

</html>