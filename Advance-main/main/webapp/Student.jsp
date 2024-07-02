<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.auth.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
StudentBean bean = new StudentBean();

List list =(List) request.getAttribute("lst");
Iterator <StudentBean>it = list.iterator();

%>



<form action="StudentCTL" method="post"> 	

      <h1 align="center">Student Record</h1>
      <table width="100%">
                <tr>
                    <td align="center"><label> Name :</label> <input type="text" name="name" value="">
                        &emsp; <label>RollNo :</label> <input type="text" name="rollNo" value="">&emsp;
                        <input type="submit" name="operation" value="Search">
                    
                    </td>
                </tr>
            </table>
<table border="1" align="center" style="background-color: BurlyWood ;  text-align: center;" width="100%">

	
	
<tr>
<td> Id</td>
<td> Rollno</td>
<td> First Name</td>
<td> Last Name</td>
<td> Session</td>

</tr>
<%
while(it.hasNext()){
	bean =it.next();
%>
<tr>
<td><%=bean.getId() %></td>
<td><%=bean.getRollNo() %></td>
<td><%=bean.getFirstName() %></td>
<td><%=bean.getLastName() %></td>
<td><%=bean.getSession() %></td>


</tr>
<%
}
%>

</table>
  <table width="100%">
                <tr>
                    <td><input type="submit" name="operation" value="Previous"></td>
                    <td><input type="submit" name="operation" value="New"></td>
                    <td><input type="submit" name="operation" value="Delete"></td>
                    <td align="right"><input type="submit" name="operation" value="Next"></td>
                </tr>
            </table>
</form>
</body>
</html>