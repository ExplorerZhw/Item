 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="style/css.css" type="text/css">
	<script type="text/javascript" src="style/jquery-2.1.4.js"></script>
    <script src="style/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>登录</title>
</head>
<body style="background-color: #EBEBEB">
<div class="loginStyle">
	<form action="login.do" method="post">
        <div style="text-align: center">
        	<h2>仓库管理系统</h2>
        </div>
		<div class="input-group">
			<span class="input-group-addon">帐  号</span>
			<input type="text" class="form-control" id="username" name="username" />
		</div>
    	<div class="input-group">
			<span class="input-group-addon">密  码</span>
			<input id="password" name="password" type="password" class="form-control" />
		</div>
		<button type="submit" class="btn btn-info" style="width:300px;margin:auto">登录</button>
	    <div id="loginMsg">${msg}</div>
	</form>
</div>
</body>
</html>