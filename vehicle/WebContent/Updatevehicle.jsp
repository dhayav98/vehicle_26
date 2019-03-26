<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="loginstyle.css">
</head>
<script type="text/javascript">
function update1()
{
	var url="Branch.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
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
function update2()
{
	
	var url="Vehicletype.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
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
function update3()
{
	var url="Insuranceupdate.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
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
function update4()
{
	
	var url="Serviceupdate.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
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
function update5()
{
	var c1=document.getElementById("")
	var url="Servicedueupdate.jsp";
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXObject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readyState==4)
		{
			var val=req.responseText;
			document.getElementById("updateajax").innerHTML=val;
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
<body>
<% 
int vehicleno=Integer.parseInt(request.getParameter("vno"));
application.setAttribute("vno",vehicleno);
%>
<body class="bodystyle">

<div class="form-group required">
<form action="Updatevehicle" method="post">
<br><h4>Vehicle Number : <%=vehicleno %></h4>
<br><h5>Select the field to be updated :</h5>
<br><input type="radio"  name="choice" value="1" onClick='update1()' id="choice1"> <label >Branch</label>
<br><input type="radio"  name="choice" value="2" onClick='update2()' id="choice2"> <label >Vehicle Type</label>
<br><input type="radio"  name="choice" value="3" onClick='update3()' id="choice3"> <label >Insurance Expiry</label>
<br><input type="radio"  name="choice" value="4" onClick='update4()' id="choice4"> <label >Last Serviced Date</label>
<br><input type="radio"  name="choice" value="5" onClick='update5()' id="choice5"> <label >Service Due Date</label>
<br>
<label>Enter detail to be updated Updated </label>
<h4 id="updateajax"></h4>
<input type="text"   name="date">
<br><input type="submit" value="Submit">
</form>
</div>
</body>
</html>