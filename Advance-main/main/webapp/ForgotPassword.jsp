<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#A3E4D7">

<form action="fdctl" method="post">
<h1 align="center">Submit your Email address and we'll send your password.</h1>
<%String pass=(String)request.getAttribute("password"); 
String em=(String)request.getAttribute("email");
%>
<h2 align="center" style="color: red"><%if(pass!=null)%><%=pass %></h2>
<table align="center">

<tr>
<td>Enter your Email</td>
<td><input type="email" name="email" value=""></td>
<td><input type="submit" name="op" value="Go"></td>
<td style="position: fixed; color: red"><%if(em!=null)%><%=em %></td>
</tr>

</table>
</form>

</body>
</html>