<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="loginstyle.css">
<script>
var req;
function A()
{
	var url="Createvehicle.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("id1").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e)
	{	
		alert("Unable to connect Server");
	}
}

function B()
{
	var url="Displayvehicle";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("id1").innerHTML=val;
		}
	}
	req.open("GET",url,true);
	req.send();
	}
	catch(e) 
	{	
		alert("Unable to connect Server");
	}
}
</script>
</head>
<body>
<div>
<h1 style="text-align:center; "></h1>
<br>
<!-- <form align="right" name="form1" method="post" action="log_out.php">
  <label class="logoutLblPos">
  <input name="submit2" type="submit" id="submit2" value="log out">
  </label>
</form> -->
<div style="display:inline">
<form action="Searchvehicle.jsp">
<input type="submit" class="loginbutton"  value="Search vehicle"  /><br>
</form>
<form action="Createvehicle.jsp" method="post">
<input type="button" class="loginbutton" onclick="A()" value="Create vehicle"  /><br>
</form>
<form action="Dispupdate" method="post">
<input type="submit" class="loginbutton"  value="Update vehicle"  /><br>
</form>
<form action="Displayvehicle" method="post">
<input type="button" class="loginbutton" onclick="B()" value="Display vehicle details"  /><br>
</form>
</div>
<span id="id1"></span>
</body>
</html>