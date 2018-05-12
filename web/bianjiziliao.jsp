<%@ page language="java" import="java.util.*,model.BbsUser" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String birth="";
birth= (String) request.getAttribute("birth");
int sex=(int)request.getAttribute("sex");
String qianming=(String)request.getAttribute("qianming");
String email= (String) request.getAttribute("email");
String tel= (String) request.getAttribute("tel");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
		<title>个人信息更改</title>
		<link rel="stylesheet" href="static/css/bootstrap.css" />
		<style>
			#main {
				width: 600px;
				margin: 0 auto;
				padding-top: 80px;
			}
			.btn{
				margin-left:260px ;
				
			}
		</style>
	</head>

	<body>
		<div id="main">
			<form method="get">
				<div class="form-group">
					<span>性别<span>
			<select name="sex" >
				<option value="1"  <% if(sex==1){%> selected <%};%>>男</option>
				<option value="2" <%if(sex==2){%> selected <%} %>>女</option>
			</select>
			</div>
			<div class="form-group">
				<label class="control-label">生日（注意不是这个格式，格式为970924,这种）</label>
				<input type="text" class=" form-control" name="birth" value="<%out.print(birth);%>" />
			</div>
				<div class="form-group">
					<label class="control-label">邮箱</label>
					<input type="text" class=" form-control" name="email" value="<%out.print(email);%>" />
				</div>
				<div class="form-group">
					<label class="control-label">手机</label>
					<input type="text" class=" form-control" name="tel" value="<%out.print(tel);%>" />
				</div>
			<div class="form-group">
				<label class="control-label">签名</label>
				<textarea type="text " class=" form-control" name="qianming"><%out.print(qianming); %></textarea>
			</div>
			<input type="submit" class="btn btn-primary"></div>
		</form>
		</div>
	</body>

</html>