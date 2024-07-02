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
String s = (String)request.getAttribute("msg");
if(s!=null){%>
<h1><%=s%></h1>
<% } %>

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
    <center>
        <form action="MarksheetCtll" method="post">
        <%
			String FL = (String) request.getAttribute("one");
			String FN = (String) request.getAttribute("two");
			String LN = (String) request.getAttribute("three");
		%>
        
            <h1>Add Marksheet</h1>
            <center style=" color: red">
				<%
					if (FL != null) {
				%>
				<%=FL%>
				<%
					}
				%>
			</center> 
            <table>
                <tr>
                    <th>Rollno*</th>
                    <td><input type="text" name="RollNo" value="">                            
                    </td>
                </tr>
                <tr>
                    <th>First Name*</th>
                     <td><input type="text" name="Fname" value=""> <%
 	if (FN != null) {
 %> <%=FN%> <%
 	}
 %>
				 </td>
                    
                </tr>
                 <tr>
                    <th>Last Name*</th>
                     <td><input type="text" name="Lnme" value=""> <%
 	if (LN != null) {
 %> <%=LN%> <%
 	}
 %>
			
                    </td>
                    
                </tr>
                <tr>
                    <th>Physics</th>
                    <td><input type="text" name="physics" value="">
                    </td>
                </tr>
                <tr>
                    <th>Chemistry</th>
                    <td><input type="text" name="chemistry" value="">
                    </td>
                </tr>
                <tr>
                    <th>Maths</th>
                    <td><input type="text" name="Maths" value="">
                       
                    </td>

                </tr>
                <tr>
                    <td align="center"><input type="submit" name="operation" value="Save">&emsp;<input type="submit" name="operation" value="update">&emsp;<input type="submit" name="operation" value="Cancel"></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>