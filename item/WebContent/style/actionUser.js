
function addUser(){
	$.ajax({
        type:'post',
        async: false,
        data:{},
        url:"../item/addUserHtml.do",
        dataType:"text",
        success:function(data){
        	if(data != ""){
        		document.getElementById("center").innerHTML = data;
        		
        	}
        },
        error:function(){
            alert("系统错误,请重新登录");
        }
    });
}

function manageUser(){
	$.ajax({
        type:'post',
        async: false,
        data:{},
        url:"../item/searchUserHtml.do",
        dataType:"text",
        success:function(data){
        	if(data != ""){
        		document.getElementById("center").innerHTML = data;
        		
        	}
        },
        error:function(){
            alert("系统错误,请重新登录");
        }
    });
}

function jChange(){
	var options = $("#iLevelSel option:selected");
	document.getElementById("iLevel").value = options.val();
	alert(document.getElementById("iLevel").value);
}
function checkUserExist(){
	var loginName = document.getElementById("loginName").value;
	$.ajax({
        type:'post',
        async: false,
        url:"../item/checkUserExist.do?loginName="+loginName,
        dataType:"text",
        success:function(data){
        	if(data == "ok"){
        		return true;
        	}else{
        		alert("该登陆名已存在，请重新输入");
        		return false;
        	}
        },
        error:function(){
            alert("系统错误,请重新登录");
        }
    });
}
function checkForm(){
	var lname = document.getElementById("loginName").value;
	var name = document.getElementById("name").value;
	var pw1 = document.getElementById("password1").value;
	var pw2 = document.getElementById("password2").value;
	var iLevel = document.getElementById("iLevel").value;
	if(lname == "" || name == "" || iLevel == ""){
		alert("添加页面值需要全部输入");
		return false;
	}else{
		if(pw1 != pw2){
			alert("两次密码输入不同，请重新输入");
			return false;
		}else{
			if(pw1.length < 6){
				alert("密码长度小于6位，请重新输入");
				return false;
			}
		}
	}
	return true;
}

function checkForm1(){
	var id = document.getElementById("userid").value;
	var lname = document.getElementById("loginName").value;
	var name = document.getElementById("name").value;
	var pw = document.getElementById("password").value;
	var iLevel = document.getElementById("iLevel").value;
	var re = new RegExp("^[1-6]$");
	if(lname == "" || name == "" || iLevel == ""){
		alert("添加页面值需要全部输入");
		return false;
	}else{
		if(pw.length < 6){
			alert("密码长度小于6位，请重新输入");
			return false;
		}
		if(!re.test(iLevel.trim())){
			alert("请输入1-6的数字");
			return false;
		}
	}
	return true;
}

function searchUser(){
	var searchStr = document.getElementById("searchStr").value;
	if(searchStr.trim() != ""){
		$.ajax({
	        type:'post',
	        async: false,
	        url:"../item/searchuser.do?searchStr="+searchStr,
	        dataType:"json",
	        success:function(data){
	        	if(data.length > 0){
	        		var html = "<thead>"+
				        "<tr>"+
				        	"<th width='10px'></th>"+
				            "<th width='200px'>用户账号</th>"+
				            "<th width='200px'>密码</th>"+
				            "<th width='200px'>姓名</th>"+
				            "<th width='50px'>权限</th>"+
				        "</tr></thead>";
	                var json = eval(data);
	                $.each(json, function (index, item) {  
	                    //循环获取数据    
	                	var id = json[index].id;
	                    var loginName = json[index].loginName;  
	                    var password = json[index].password;  
	                    var name = json[index].name; 
	                    var iLevel = json[index].iLevel; 
	                    html = html +"<tr><th><input type='checkbox' name='ck' value='"+id+"'></th><th>"+loginName+"</th><th>"+password+"</th><th>"+name+"</th><th>"+iLevel+"</th><tr>"
	                }); 
		            $('#userInfo').html(html);
	        	}else{
	        		alert("没有找到符合查询条件的信息，请输入人员姓名或者登录名的全部或者部分字段重新查询");
	        	}
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}

function updateUser(){
	var obj = document.getElementsByName("ck");
	var id = "";
	var count = 0;
	for(var i = 0; i < obj.length; i ++){
		if(obj[i].checked){
			count = count + 1;
			id = obj[i].value
		}
	}
	if(count > 1){
		alert("只能选中一项");
	}else{
		$("#center").load('../item/html/updateuser.html #updateuser');
		$.ajax({
	        type:'post',
	        async: false,
	        url:"../item/searchuserbyid.do?id="+id,
	        dataType:"json",
	        success:function(data){
	        	var json = eval(data);
	        	$.each(json, function (index, item) {
	            	document.getElementById("userid").value = json[index].id;
	            	document.getElementById("loginName").value = json[index].loginName;
	            	document.getElementById("name").value  = json[index].name;
	            	document.getElementById("password").value  = json[index].password;
	            	document.getElementById("iLevel").value  = json[index].iLevel; 
	        	});
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}

function deleteUser(obj){
	var obj = document.getElementsByName("ck");
	var ids = "";
	for(var i = 0; i < obj.length; i ++){
		if(obj[i].checked){
			if(ids.length == 0){
				ids = obj[i].value;
			}else{
				ids = ids + "-" + obj[i].value;
			}
		}
	}
	if(ids.length < 1){
		alert("至少选中一项");
	}else{
		$.ajax({
	        type:'post',
	        async: false,
	        url:"../item/deleteuser.do?ids="+ids,
	        success:function(){
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}