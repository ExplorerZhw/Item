
function addItem(){
	$.ajax({
        type:'post',
        async: false,
        data:{},
        url:"../item/addItemHtml.do",
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

function manageItems(){
	$.ajax({
        type:'post',
        async: false,
        data:{},
        url:"../item/searchItemHtml.do",
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

function checkItemForm(){
	var iName = document.getElementById("iName").value;
	var iNumber = document.getElementById("iNumber").value;
	var iSpec = document.getElementById("iSpec").value;
	var iCount = document.getElementById("iCount").value;
	var iType = document.getElementById("iType").value;
	var iLevel = document.getElementById("iLevel").value;
	var factory = document.getElementById("factory").value;
	var iLocation = document.getElementById("iLocation").value;
	var other = document.getElementById("other").value;
	var y1 = document.getElementById("iInstoreTime_y").value;
	var m1 = document.getElementById("iInstoreTime_m").value;
	var d1 = document.getElementById("iInstoreTime_d").value;
	var y2 = document.getElementById("iAbateTime_y").value;
	var m2 = document.getElementById("iAbateTime_m").value;
	var d2 = document.getElementById("iAbateTime_d").value;
	
	if(other == "" || iNumber == "" || iSpec == "" || iCount == "" || iType == "" || iJurisdition == "" 
		|| factory == "" || iLocation == "" || other == "" || y1 == "" || m1 == "" || d1 == "" 
		|| y2 == "" || m2 == "" || d2 == ""){
		alert("添加页面值需要全部输入,无实际值请填写”无“");
		return false;
	}else{
		var re =new RegExp("^[1-9][0-9]*$");
		if(!re.test(iCount)){
			alert("“数量”填写有误，请填写正整数");
			return false;
		}
		if(re.test(y1) || re.test(m1) || re.test(d1) || re.test(y2) || re.test(m2) || re.test(d2)){
			alert("“入库时间或有效期至”填写有误，请重填");
			return false;
		}else{
			if(m1 > 13 || m2 > 13 || m1 < 0 || m2 < 0){
				alert("月份填写有误");
				return false;
			}
		}
	}
	return true;
}

function searchItem(){
	var searchStr = document.getElementById("searchStr").value;
	if(searchStr.trim() != ""){
		$.ajax({
	        type:'post',
	        async: false,
	        url:"http://localhost:8080/item/searchitem.do?searchStr="+searchStr,
	        dataType:"json",
	        success:function(data){
	                var html = "<thead>"+
				        "<tr>"+
				        	"<th width='10px'></th>"+
				        	"<th width='50px'>物资名称</th>"+
				        	"<th width='50px'>物资编号</th>"+
				        	"<th width='40px'>规格</th>"+
				        	"<th width='20px'>数量</th>"+
				        	"<th width='30px'>类型</th>"+
				        	"<th width='40px'>入库时间</th>"+
				        	"<th width='40px'>有效期至</th>"+
				        	"<th width='90px'>存放位置</th>"+
				        	"<th width='10px'>权限</th>"+
				        "</tr></thead>";
	                var json = eval(data);
	                $.each(json, function (index, item) {  
	                    //循环获取数据    
	                	var id = json[index].id;
	                    var iName = json[index].iName;
	                    var iNumber = json[index].iNumber;
	                    var iSpec = json[index].iSpec;
	                    var iCount = json[index].iCount;
	                    var iType = json[index].iType;
	                    var iInstoreTime = json[index].iInstoreTime;
	                    var iAbateTime = json[index].iAbateTime;
	                    var iLocation = json[index].iLocation;
	                    var iLevel = json[index].iLevel;
	                    var factory = json[index].factory;
	                    var other = json[index].other;
	                    html = html +"<tr><th><input type='checkbox' name='ck' value='"+
	                    id+"'></th><th>"+
	                    iName+"</th><th>"+
	                    iNumber+"</th><th>"+
	                    iSpec+"</th><th>"+
	                    iCount+"</th><th>"+
	                    iType+"</th><th>"+
	                    iInstoreTime+"</th><th>"+
	                    iAbateTime+"</th><th>"+
	                    iLocation+"</th><th>"+
	                    iLevel+"</th><tr>"
	                }); 
	                alert(html);
	            $('#itemInfo').html(html);
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}

function deleteItem(obj){
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
	        url:"../item/deleteitem.do?ids="+ids,
	        success:function(){
	        	$("#center").load('../item/html/delete.html #delete');
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}

function updateItem(){
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
		$("#center").load('../item/html/updateitem.html #updateitem');
		$.ajax({
	        type:'post',
	        async: false,
	        url:"../item/searchitembyid.do?id="+id,
	        dataType:"json",
	        success:function(data){
	        	var json = eval(data);
	        	$.each(json, function (index, item) {
	        		alert(json[index].iLevel);
	            	document.getElementById("itemId").value = json[index].id;
	            	document.getElementById("iName").value = json[index].iName;
	            	document.getElementById("iNumber").value  = json[index].iNumber;
	            	document.getElementById("iSpec").value  = json[index].iSpec;
	            	document.getElementById("iCount").value  = json[index].iCount;
	            	document.getElementById("iType").value  = json[index].iType;
	            	document.getElementById("iLevel").value  = json[index].iLevel;
	            	document.getElementById("factory").value  = json[index].factory;
	            	document.getElementById("iLocation").value  = json[index].iLocation;
	            	var data1 = json[index].iInstoreTime;
	            	var data2 = json[index].iAbateTime;
	            	var data1s = data1.split("-");
	            	var data2s = data2.split("-");
	            	document.getElementById("iInstoreTime_y").value  = data1s[0];
	            	document.getElementById("iInstoreTime_m").value  =data1s[1];
	            	document.getElementById("iInstoreTime_d").value  = data1s[2];
	            	document.getElementById("iAbateTime_y").value  = data2s[0]; 
	            	document.getElementById("iAbateTime_m").value  = data2s[1]; 
	            	document.getElementById("iAbateTime_d").value  = data2s[2]; 
	            	document.getElementById("other").value  = json[index].other; 
	        	});
	        },
	        error:function(){
	            alert("系统错误,请重新登录");
	        }
	    });
	}
}