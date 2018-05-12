<%@ page language="java" import="java.util.*,model.Sort,model.Topic"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	Sort sort = (Sort) request.getAttribute("sort");
	List<Topic> topiclist = (List<Topic>) request.getAttribute("topiclist");
	List<String> usernamelist = (List<String>) request.getAttribute("usernamelist");
	int topicnum = (int) request.getAttribute("topicnum");
	int pagenum = (int) request.getAttribute("pagenum");
	int total = (topicnum+19) / 20;//得到应该分的页数
	
	int begin;// 开始页码
	int end;//结束页码
	if (total<7) {
		begin = 1;
		end = total;
	} else {
		if (pagenum - 2 > 1 && pagenum + 3 < total + 1) {
			begin = pagenum - 2;
			end = pagenum + 3;
		} else {if(pagenum - 2 < 2){
			begin = 1;
			end = 6;
		}else{
			begin = total - 5;
			end = total;
			}
		}
	}
%>
<title><%=sort.getSortname()%></title>


<link href="static/css/bootstrap.min.css" rel="stylesheet">


<style>
body {
	min-width: 900px;
}

.cebianlan {
	margin: 0px 120px 120px 10px;
}

.bankuai {
	text-align: center;
	margin: 20px 0px 0px 0px;
}

.bankuaijianjie {
	margin: 5px 0px 0px 0px;
	padding: 1px;
	word-wrap: break-word
}
.zhutibiaoti{
	font-size:1.5em;
}

.zhuti {
	background-color: #E5E5E5;
	margin-top: 2px;
}

.xuanfukuang {
	position: fixed;
	bottom: 100px;
	left: 100px
}

.fenyelan {
	text-align: center;
	bottom: 20px;
}
</style>

</head>

<body>
	<ol class="breadcrumb">
		<li><a href="selectsort">版块选择</a></li>

		<li class="active"><%=sort.getSortname()%></li>
	</ol>
	<div class="container">
		<div class="row">
			<div class="col-xs-4">
				<div class="cebianlan ">

					<img src="static/pic/sort<%out.print(sort.getId() - 1);%>.jpg"
						class="img-responsive center-block"></img>
					<p class="bankuai text-center "><%=sort.getSortname()%></p>
					<div class="col-xs-12">
						<p class="bankuaijianjie">
							<%=sort.getInfo()%></p>
					</div>
				</div>
			</div>
			<div id="zhutilan" class="col-xs-8">
				<%
					for (int i = 0; i < topiclist.size(); i++) {
				%>

				<div class="zhuti row">
					<div class="zhutibiaoti col-xs-12 h2">
						<p>
							<a href="topic?topicid=<%=topiclist.get(i).getId()%>"><%=topiclist.get(i).getTopicname()%>
							</a>
						</p>
					</div>
					<div class="fabushijian col-xs-3 col-xs-offset-4">
						<p><%=topiclist.get(i).getSendtime()%>
						</p>
					</div>
					<div class="faburen col-xs-offset-1 col-xs-2"></div>
					<p>
						<a target="_blank"
							href="Dperson?uid=<%=topiclist.get(i).getUserid()%>"><%=usernamelist.get(i)%>
						</a>
					</p>
				</div>

				<%
					}
					;
				%>
			</div>

			<div class="xuanfukuang " style="font-size:40px;">
				<span class="xintiezi glyphicon glyphicon-menu-up"></span> <a target="_blank" href="xinzhuti?sortid=<%=sort.getId()%>"><span
					class="ding glyphicon glyphicon-plus" style="margin-left: 20px;"></span></a>

			</div>
		</div>

		<div class="fenyelan">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<%
					if (pagenum != 1) {
				%>
				<li><a href="sortpage?sortnum=<%=sort.getId()-1%>&page=<%=pagenum-1%>" aria-label="Previous"> <span
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
					%> <a href="sortpage?sortnum=<%=sort.getId()-1%>&page=<%=i%>"><%=i%></a> <%
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
				<li><a href="sortpage?sortnum=<%=sort.getId()-1%>&page=<%=pagenum+1%>" aria-label="Next"> <span aria-hidden="true">下一页</span>
				</a></li>
				<%
					}
				%>
			</ul>
			</nav>

		</div>

	</div>
	</div>
</body>

</html>