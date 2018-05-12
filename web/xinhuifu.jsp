<%@ page language="java" import="java.util.*,model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Topic topic=(Topic)request.getAttribute("topic");
int topicid=topic.getId();
String name=topic.getTopicname();
Sort sort=(Sort)request.getAttribute("sort");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>新回复</title>

		<!-- Bootstrap -->
		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<style>
			textarea {
				min-height: 400px;
			}
			
			#main {
				margin: 0px 30px;
			}
			
			button {
				margin-right: 30px;
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

			<li class="active"><a href="topic?topicid=<%=topicid%>"><%out.print(name); %></a></li>
		
			
				<li class="active">回复</li>
		</ol>
		
<div id="main">
<form mothed="post" >
		<div class="form-group">
			<label class="control-label">回复</label>
			<textarea type="text " class=" form-control" placeholder="内容" name="neirong" aria-describedby="sizing-addon2">
						</textarea>
		</div>
		<input type="hidden" name="topicid" value="<%=topicid%>" />
		<input type="submit" class="btn btn-info pull-right" value="提交"></input>
		</form>
		</div>
	</body>

</html>