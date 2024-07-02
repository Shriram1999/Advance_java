<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="Header.jsp" %>

	<form action="loginCtll" method="post">
	
	<%
	String Error = (String) request.getAttribute("Error");
	if (Error !=null){
	%>
	<h1 style="color: red" align="center">
	<%=Error%>
	</h1>
	<% 
	}
	%>
		<%
			String s = (String) request.getAttribute("one");
			String a = (String) request.getAttribute("email");
			String st = (String) request.getAttribute("pwd");
		%>

		<table align="center">

			<h2 align="center">Login Form</h2>
			<center style=" color: red">
				<%
					if (s != null) {
				%>
				<%=s%>
				<%
					}
				%>
			</center>  
			<tr>
				<th>Username*</th>
				<td style="color: red"><input type="email" name="email"> <%
 	if (a != null) {
 %> <%=a%> <%
 	}
 %></td>
			</tr>
			<tr>
				<th>password*</th>
				<td style="color: red"><input type="password" name="password"> <%
 	if (st != null) {
 %> <%=st%> <%
 	}
 %></td>
 
			</tr>
			

			<tr>
				<th></th>
				<td><input type="submit" value="signin"></td>
				</tr>
				
			<tr>
			<th>Not a member?</th>
				   <td colspan="2" align="center"><a href="UserRegistration.jsp"><b>Sign Up</b></a> | <a href="ForgotPassword.jsp"><b>Forget
                                my password</b></a>&nbsp;</td>
			</tr>
			<%@include file="Footer.jsp" %>
		</table>
	</form>

</body>
</html>