<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.servlet.Marksheet_bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<%Marksheet_bean bean= new Marksheet_bean();


List list = (List)request.getAttribute("lst");
Iterator<Marksheet_bean>it=list.iterator();

%>

<form action="GetmarksheetCTL" method="post">

  
<h1 align="center">Marksheet records</h1>
<table width="100%">
                <tr>
                    <td align="center"><label> Name :</label> <input type="text" name="name" value="">
                        &emsp; <label>RollNo :</label> <input type="text" name="rollNo" value="">&emsp;
                        <input type="submit" name="operation" value="Search">
                    </td>
                </tr>
            </table>
            
            
		<table border="1" align="center" style="background-color: BurlyWood; text-align: center;" width="100%">
			<tr>
			    <th>Select All</th>
				<th>ID</th>
				<th>Roll NO</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Physics</th>
				<th>Chemistry</th>
				<th>Maths</th>
				<th>Edit</th>
			</tr>
			<%
			while(it.hasNext()){
				bean=it.next();
			
			
			%>
			<tr>
			<td><input type = "checkbox" name ="operation" value=""></td>
		
			<td><%=bean.getId() %></td>
			<td><%=bean.getRollNo() %></td>
			<td><%=bean.getFname() %></td>
			<td><%=bean.getLname() %></td>
			<td><%=bean.getPhy() %></td>
			<td><%=bean.getChem() %></td>
			<td><%=bean.getMath() %></td>
			<td><a href=" " >Edit</a></td>
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