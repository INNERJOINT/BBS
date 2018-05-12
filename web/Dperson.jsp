<%@ page language="java" import="java.util.*,model.SimpleUser,model.Topic,model.Response" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				
				 int touxiangid=(int)request.getAttribute("touxiangid");
				 int begin=(int)request.getAttribute("begin");
				 int end=(int)request.getAttribute("end");
				 int total=(int)request.getAttribute("total");
				 int pagenum=(int)request.getAttribute("pagenum");
				 int turn=(int)request.getAttribute("turn");
				 List<Topic> contentlistt=(List<Topic>)request.getAttribute("contentlistt");
				 List<Response> contentlistr=(List<Response>)request.getAttribute("contentlistr");
				 SimpleUser user=(SimpleUser)request.getAttribute("user");
			
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="UTF-8">
		<title>用户发帖信息</title>
		<link rel="stylesheet" href="static/css/bootstrap.css" />
	</head>
	<style>
		#left {
			display: block;
			float: left;
			width: 400px;
		}
		img{
			width: 100px;
			height: 100px;
			
		}
		#main {
			float: left;
		}
		
		#right {
			float: left;
			width: 400px;
			display: block;
		}
		
		.panel {
			margin-top: 0px;
			margin-bottom: 0px;
		}
		.pull-right{
			clear: both;
			
		}
	</style>

	<body>
		<div id="main">
			<div id="left">
				<div class="panel panel-default">
					<div class="panel-heading">头像</div>
					<div class="panel-body">
						<div>
							<img src="static/pic/user<%=touxiangid%>.jpg" />
						</div>
					</div>
				</div>

				<div class="panel panel-default">
					<div class="panel-heading">基本信息</div>
					<div class="panel-body">
						<div>
							<p>姓名：<%=user.getName()%></p>
							
							<p>等级：<%=user.getLv()%></p>
							<a target="_blank" href="person?uid=<%=user.getId()%>" class="btn btn-primary">详细信息</a>
						</div>
					</div>
				</div>

			</div>
			<div id="right">
				<ul class="nav nav-tabs">
					<li role="presentation" <% if(turn==1){%>class="active"<% }%>>
						<a href="Dperson?turn=1&uid=<%=user.getId()%>">发过的帖子</a>
					</li>
					<li role="presentation" <%if(turn==2){%>class="active"<%} %>>
						<a href="Dperson?turn=2&uid=<%=user.getId()%>">发表的回复</a>
					</li>

				</ul>
<%if(turn==1){
for(int i=0;i<contentlistt.size();i++){
Topic tmp=contentlistt.get(i);
%>
				<div class="panel panel-default">
					<div class="panel-body">

						<p><a href="topic?topicid=<%=tmp.getId()%>"><%=tmp.getTopicname()%> </a></p>
						<p>发表日期:<%=tmp.getSendtime()%></p>
					</div>
				</div>
<%}}else{

 %>				
<%for(int i=0;i<contentlistr.size();i++){ 
Response sak=contentlistr.get(i);

%>
				<div class="panel panel-default">
					<div class="panel-body">

						<p><a href="topic?topicid=<%=sak.getTopicid()%>"><%=sak.getRespcontent() %> </a></p>
						<p>发表日期:<%=sak.getSendtime() %></p>
					</div>
				</div>
<%}} %>				

			</div>
			<nav aria-label="Page navigation" class="pull-right">
					<ul class="pagination">
						<%
					if (pagenum != 1) {
				%>
				<li><a href="Dperson?turn=<%=turn%>&uid=<%=user.getId()%>&page=<%=pagenum-1%>" aria-label="Previous"> <span
						aria-hidden="true">上一页</span>
				</a></li>
				<%
					}
				%>
				<%
					for (int i = begin; i <= end; i++) {
				%>

				<li>
					<%
						if (i != pagenum) {
					%> <a href="Dperson?turn=<%=turn%>&uid=<%=user.getId()%>&page=<%=i%>"><%=i%></a> <%
 					} else {
 							%> <span style="color:black;"><%=i%></span>
					<%
						}
					%>
				</li>
				<%
					}
				%>
				<%
					if (pagenum != total) {
				%>
				<li><a href="Dperson?turn=<%=turn%>&uid=<%=user.getId()%>&page=<%=pagenum+1%>" aria-label="Next"> <span aria-hidden="true">下一页</span>
				</a></li>
				<%
					}
				%>
					</ul>
				</nav>
		</div>

	</body>

</html>