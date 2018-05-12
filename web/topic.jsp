<%@ page language="java" import="java.util.*,model.BbsUser,model.Response,model.Sort,model.Topic" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

		int begin=(int)request.getAttribute("begin");
		int end=(int)request.getAttribute("end");
		int total=(int)request.getAttribute("total");
		int pagenum=(int)request.getAttribute("pagenum");
		BbsUser spc=(BbsUser)request.getAttribute("spc");
		Sort sort=(Sort)request.getAttribute("sort");
		List<Response> responselist=(List<Response>)request.getAttribute("responselist");
		List<BbsUser>  userlist=(List<BbsUser>)request.getAttribute("userlist");
		Topic topic=(Topic)request.getAttribute("topic");
		int topicid=topic.getId();
		String name=topic.getTopicname();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title><%out.print(name); %></title>

		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<style>
			.huifu {
				border-left: 1px solid #E5E5E5;
				border-bottom: 1px solid #E1E4E6;
				background: #fafbfc;
			}
			.touxiangqu{
				border-left: 1px solid #E5E5E5;
				height: 140px;
				margin: 0px;
			}
			.name {
				margin-top: 10px;
				text-align: center;
			}
			
			.lv {
				text-align: center;
				margin-top: 10px;
			}
			
			.touxiang {
				width: 80px;
				height: 80px;
				margin: 0px auto;
			}
			.neirongqu{
				padding: 10px;
				font-size: 1.5em;
				
			}
			.xuanfukuang {
				position: fixed;
				
				bottom: 100px;
				right:100px
			}
		</style>
	</head>

	<body>
		<ol class="breadcrumb">
			<li>
				<a href="selectsort">Home</a>
			</li>
			<li>
				<a href="sortpage?sortnum=<%out.print(sort.getId()-1);%>" ><%out.print(sort.getSortname()); %></a>
			</li>

			<li class="active"><%out.print(name); %></li>
		</ol>
		
		<div class="container">
			<div class="row">
				<nav aria-label="Page navigation" class="pull-right" >
					<ul class="pagination">
						<%
					if (pagenum != 1) {
				%>
				<li><a href="topic?topicid=<%out.print(topicid);%>&page=<%out.print(pagenum-1); %>" aria-label="Previous"> <span
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
					%> <a  href="topic?topicid=<%out.print(topicid);%>&page=<%out.print(i); %>"><%=i%></a> <%
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
				<li><a href="topic?topicid=<%out.print(topicid);%>&page=<%out.print(pagenum+1); %>" aria-label="Next"> <span aria-hidden="true">下一页</span>
				</a></li>
				<%
					}
				%>
					</ul>
				</nav>
				<% %>
				
				<div class="col-xs-10 huifu">
					<div class="huifukuang col-xs-10">
						<div class="neirongqu">

							<div class="huifushijian"><%=topic.getTopiccontent() %></div>
						</div>
					</div>
					<div class="touxiangqu col-xs-2">
						<div class="touxiang"><img class="img-responsive" src="static/pic/user<%=spc.getAvatarid() %>.jpg" /></div>
						<div class="name"><a target="_blank" href="Dperson?uid=<%=spc.getId()%>"><%=spc.getName() %></a></div>
						<div class="lv"><%=spc.getLv() %>级</div>
					</div>

				</div>

				
				<%	Response rs=null;
				BbsUser bu=null;
				for(int i=0;i<responselist.size();i++){
				rs=responselist.get(i);
				bu=userlist.get(i);
				 %>
				<div class="col-xs-10 huifu">
					<div class="huifukuang col-xs-10">
						<div class="neirongqu">

							<div class="huifushijian"><%out.print(rs.getRespcontent()); %></div>
						</div>
					</div>
					<div class="touxiangqu col-xs-2">
						<div class="touxiang"><img class="img-responsive" src="static/pic/user<%=bu.getAvatarid() %>.jpg" /></div>
						<div class="name"><a target="_blank"
							href="Dperson?uid=<%=bu.getId()%>"><%=bu.getName()%>
						</a></div>
						<div class="lv"><%=bu.getLv() %>级</div>
					</div>

				</div>
					<% }%>
				
				
			</div>
			
			<div class="xuanfukuang " style="font-size:40px;">
						<span class="xintiezi glyphicon glyphicon-menu-up"></span>
						<a  href="xinhuifu?topicid=	<%=topicid%>"> <span class="ding glyphicon glyphicon-plus" style="margin-left: 20px;"></span></a>

					</div>
		</div>
	</body>

</html>