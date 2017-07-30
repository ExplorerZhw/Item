/*
 * 物品申请单相关操作js方法
 */
function addApply(){
	$.ajax({
        type:'post',
        async: false,
        data:{},
        url:"../item/addApplyHtml.do",
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

function manageApply(){
	$.ajax({
        type:'post',
        async: false,
        data:{},
        url:"../item/searchApplyHtml.do",
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

function searchNameByType(){
	var iType = document.getElementById("iType").value;
	alert(iType);
	if(iType.trim() == ""){
		document.getElementById("iName").value = "";
		document.getElementById("iSpec").value ="";
		document.getElementById("factory").value ="";
	}else{
		$.ajax({
	        type:'post',
	        async: false,
	        data:{'iType':iType},
	        url:"../item/searchNameByType.do",
	        dataType:"JSON",
	        success:function(data){
	        	var html = "<option>";
	        	if(data != null){
	        		for(var i = 0; i < data.length - 1; i++){
		        		html = html+data[i].name+"</option><option>"
		        	}
	        		html = html +data[data.length - 1].name+"</option>";
	        		alert(html);
	        		document.getElementById("name").innerHTML = html;
	        	}
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}
function searchSpecByName(){
	var iType = document.getElementById("iType").value;
	var iName = document.getElementById("iName").value;
	if(iName.trim() == ""){
		document.getElementById("iSpec").value ="";
		document.getElementById("factory").value ="";
	}else{
		$.ajax({
	        type:'post',
	        async: false,
	        data:{'iType':iType,'iName':iName},
	        url:"../item/searchSpecByName.do",
	        dataType:"JSON",
	        success:function(data){
	        	var html = "<option></option><option>";
	        	if(data != null){
	        		for(var i = 0; i < data.length - 1; i++){
		        		html = html+data[i].spec+"</option><option>"
		        	}
	        		html = html +data[data.length - 1].spec+"</option>"
	        		document.getElementById("iSpec").innerHTML = html;
	        	}
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}
function searchFactoryBySpec(){
	var iType = document.getElementById("iType").value;
	var iName = document.getElementById("iName").value;
	var iSpec = document.getElementById("iSpec").value;
	if(iSpec.trim() == ""){
		document.getElementById("factory").value ="";
	}else{
		$.ajax({
	        type:'post',
	        async: false,
	        data:{'iType':iType,'iName':iName,'iSpec':iSpec},
	        url:"../item/searchFactoryBySpec.do",
	        dataType:"JSON",
	        success:function(data){
	        	var html = "<option></option><option>";
	        	if(data != null){
	        		for(var i = 0; i < data.length - 1; i++){
		        		html = html+data[i].factory+"</option><option>"
		        	}
	        		html = html +data[data.length - 1].factory+"</option>"
	        		document.getElementById("factory").innerHTML = html;
	        	}
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}
function setAddApplyTime() {
	var myDate=new Date();
	var y = myDate.getFullYear();
	var m = myDate.getMonth() + 1;
	var d = myDate.getDate();
	document.getElementById("aOutTime_y").value = y;
	document.getElementById("aOutTime_m").value = m;
	document.getElementById("aOutTime_d").value = d;
}

function searchapply(){
	var keyType = $("#keyType").val();
	var keyValueObj = document.getElementById("searchStr");
	var keyValue = "";
	if(keyValueObj == undefined || keyValueObj ==null){
		keyValue = document.getElementById("searchStr").value;
	}else{
		alert("服务错误，请刷新页面或者重新登录");
		return false;
	}
	if(keyValue.trim() != ""){
		$.ajax({
	        type:'post',
	        async: false,
	        data:{'keyType':keyType,'keyValue':keyValue},
	        url:"../item/searchapply.do",
	        dataType:"JSON",
	        success:function(data){
                var html = "<thead>"+
			        "<tr>"+
			        	"<th width='10px'></th>"+
			        	"<th width='50px'>物资类型</th>"+
			        	"<th width='50px'>物资名称</th>"+
			        	"<th width='40px'>物品规格</th>"+
			        	"<th width='30px'>申请数量</th>"+
			        	"<th width='30px'>申请时间</th>"+
			        	"<th width='30px'>申请人员</th>"+
			        	"<th width='40px'>审核状态</th>"+
			        "</tr></thead>";
                var json = eval(data);
                $.each(json, function (index, item) {  
                    //循环获取数据    
                	var id = json[index].id;
                	var iType = json[index].iType;
                    var iName = json[index].iName;
                    var iSpec = json[index].iSpec;
                    var aCount = json[index].aCount;
                    var aOutTime = json[index].aOutTime;
                    var applyPerson = json[index].applyPerson;
                    var aState = json[index].aState;
                    html = html +"<tr><th><input type='checkbox' name='ck' value='"+
                    id+"'></th><th>"+
                    iType+"</th><th>"+
                    iName+"</th><th>"+
                    iSpec+"</th><th>"+
                    aCount+"</th><th>"+
                    aOutTime+"</th><th>"+
                    applyPerson+"</th><th>"+
                    aState+"</th><tr>"
                }); 
               
            $('#itemInfo').html(html);
        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}else{
		alert("请填写查询关键字");
	}
}
function passCheck(){
	var keyValue = document.getElementById("searchStr").value;
	var obj = document.getElementsByName("ck");
	var ids = "";
	for(var i = 0; i < obj.length; i ++){
		if(obj[i].checked){
			ids = ids == "" ? obj[i].value : ids + "-" + obj[i].value;
		}
	}
	if(ids == ""){
		alert("请选中一项");
	}else{
		var user = document.getElementById("loginName").value;
		$.ajax({
	        type:'post',
	        async: false,
	        url:"../item/passCheck.do?ids="+ids+"&user="+user,
	        dataType:"text",
	        success:function(data){
	        	if(keyValue != undefined || keyValue != null || keyValue.trim() != ""){
	        		searchapply();
	        	}
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}

function rejectCheck(){
	var keyValue = document.getElementById("searchStr").value;
	var obj = document.getElementsByName("ck");
	var ids = "";
	for(var i = 0; i < obj.length; i ++){
		if(obj[i].checked){
			ids = ids == "" ? obj[i].value : ids + "-" + obj[i].value;
		}
	}
	if(ids == ""){
		alert("请选中一项");
	}else{
		var user = document.getElementById("loginName").value;
		$.ajax({
	        type:'post',
	        async: false,
	        url:"../item/RejectCheck.do?ids="+ids+"&user="+user,
	        dataType:"text",
	        success:function(data){
	        	if(keyValue != undefined || keyValue != null || keyValue.trim() != ""){
	        		searchapply();
	        	}
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}