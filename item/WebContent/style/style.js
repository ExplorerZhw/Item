var temp = 0;
function menu(obj){
    if(obj=="muser"){
        if(temp == 0){
            document.getElementById("muser").style.display="";
            temp = 1;
        }else{
            document.getElementById("muser").style.display="none";
            temp = 0;
        }
        document.getElementById("mitem").style.display="none";
        document.getElementById("mapply").style.display="none";
        document.getElementById("mabout").style.display="none";
    }else if(obj=="mitem"){
        if(temp == 0){
            document.getElementById("mitem").style.display="";
            temp = 1;
        }else{
            document.getElementById("mitem").style.display="none";
            temp = 0;
        }
        document.getElementById("muser").style.display="none";
        document.getElementById("mapply").style.display="none";
        document.getElementById("mabout").style.display="none";
    }else if(obj=="mapply"){
        if(temp == 0){
            document.getElementById("mapply").style.display="";
            temp = 1;
        }else{
            document.getElementById("mapply").style.display="none";
            temp = 0;
        }
        document.getElementById("muser").style.display="none";
        document.getElementById("mitem").style.display="none";
        document.getElementById("mabout").style.display="none";
    }else if(obj=="mabout"){
        if(temp == 0){
            document.getElementById("mabout").style.display="";
            temp = 1;
        }else{
            document.getElementById("mabout").style.display="none";
            temp = 0;
        }
        document.getElementById("muser").style.display="none";
        document.getElementById("mitem").style.display="none";
        document.getElementById("mapply").style.display="none";
    }
}
function loadDate() {
	var myDate = new Date();
	var y = myDate.getFullYear();
	var M = myDate.getMonth() + 1;
	var d = myDate.getDate();
	document.getElementById("iInstoreTime_y").value = y;
	document.getElementById("iInstoreTime_m").value = M;
	document.getElementById("iInstoreTime_d").value = d;
	document.getElementById("iAbateTime_y").value = y;
	document.getElementById("iAbateTime_m").value = M;
	document.getElementById("iAbateTime_d").value = d;
}