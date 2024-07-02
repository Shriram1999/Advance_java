<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<%
		String name = request.getParameter("name");
	    String number = request.getParameter("number");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
		String category = request.getParameter("password");
		String Date = request.getParameter("Date");
		String address = request.getParameter("address");
		
		
	%>

	<tr>
		<th>Username*</th>
		<td><%=name %> </td> <!---------expretion tag-->
	</tr>
	
	<tr>
		<th>Mobile Number</th>
		<td><%=number%></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><%=email%></td>
	</tr>
	<tr>
		<th>Gender</th>
		<td><%=gender%></td>
	</tr>
	<%-- <tr>
		<th>Password</th>
       <td><%=password%></td>
	</tr> --%>
	<tr>
		<th>Date of Birthday</th>
		<td><%=Date%></td>
	</tr>
	<tr>
		<th>Address</th>
		<td><%=address%></td>
	</tr>
	
	</table>
</body>
</html>