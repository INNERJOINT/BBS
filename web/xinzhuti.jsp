<%@ page language="java" import="java.util.*,model.Sort,model.Topic" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Sort sort=(Sort)request.getAttribute("sort");


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>新主题</title>

		
		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<style>
			textarea {
				min-height: 300px;
				height: 400px;
			}
			#main{
				margin: 0px 30px;
				
			}
			button{
				margin-right: 30px;
				
			}
		</style>
		
	</head>

	<body>
		<ol class="breadcrumb">
		<li><a href="selectsort">版块选择</a></li>

		<li class="active"><%=sort.getSortname()%></li>
	
			<li class="active">发表新主题</li>
		</ol>
		<div id="main">
			<form>
		<div class="form-group">
			<label class="control-label">标题</label>
			<input type="text" class="form-control" placeholder="标题"  name="biaoti" aria-describedby="sizing-addon2">
		</div>
		<div class="form-group">
			<label class="control-label">内容</label>
			<textarea type="text " class=" form-control" name="neirong" placeholder="内容" aria-describedby="sizing-addon2">
						</textarea>
		</div>
		<input type="hidden" name="sortid" value="<%=sort.getId()%>" />
		<input type="submit" class="btn btn-info pull-right" value="提交"></input>
		
		</form>
</div>
	</body>

</html>