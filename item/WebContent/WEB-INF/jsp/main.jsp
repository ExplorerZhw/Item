<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style/css.css" />
    <link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="style/bootstrap-3.3.7-dist/css/bootstrap.min.css.map" type="text/css">
	
	<script type="text/javascript" src="style/actionUser.js"></script>
	<script type="text/javascript" src="style/actionItem.js"></script>
	<script type="text/javascript" src="style/actionApply.js"></script>
    <script type="text/javascript" src="style/style.js"></script>
	<script type="text/javascript" src="style/jquery-2.1.4.js"></script>
    <script src="style/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>
<body>
<div class="container">
	<div id="top" class="row" style="margin-top: 20px">
		<div id="top" class="col-md-12 top" >
			<div id="title">仓库管理系统</div>
		    <div id="date">欢迎您：${name},今天是${mydate}<input id="loginName" value="${loginName}" type="hidden" /></div>
		</div>
	</div>
    <div id="mid" class="row" style="margin-top: 20px">
        <div id="menu" class="col-md-2">
            <ul class="nav nav-tabs nav-stacked">
                <li><a href="#" onclick="menu('muser')">用户管理</a></li>
                <div id="muser" style="display: none">
                    <ul>
                        <li><a href="#" onclick="addUser()">添加用户</a></li>
                        <li><a href="#" onclick="manageUser()">管理用户</a></li>
                    </ul>
                </div>
                <li><a href="#" onclick="menu('mitem')">物品管理</a></li>
                <div id="mitem" style="display: none">
                    <ul>
                        <li><a href="#" class="menu1" onclick="addItem()">添加物品</a></li>
                        <li><a href="#" class="menu1" onclick="manageItems()">管理物品</a></li>
                    </ul>
                </div>
                <li><a href="#" onclick="menu('mapply')">申请管理</a></li>
                <div id="mapply" style="display: none">
                    <ul>
                     	<li><a href="#" class="menu1" onclick="addApply()">填写申请</a></li>
                        <li><a href="#" class="menu1" onclick="manageApply()">申请管理</a></li>
                    </ul>
                </div>
                <li><a href="#" onclick="menu('mabout')">关于系统</a></li>
                <div id="mabout" style="display:none">
                    <ul>
                        <li><a href="#" class="menu1" onclick="about()">关于系统</a></li>
                    </ul>
                </div>
            </ul>
        </div>
        <div  id="center" class="col-md-10 count">
            <div class="addForm" id="msg" >${msg}</div>
        </div>
    </div>
</div>
</body>
</html>