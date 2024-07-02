<%@page import="com.rays.servlet.Marksheet_bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Marksheet_bean bean =(Marksheet_bean)request.getAttribute("user"); %>
 <center>
 <%String st =(String) request.getAttribute("err");
 if(st!=null){
 %>
 <%=st %>
 <%} %>
 
 <form action="GetMarksheet" method="post">
        <h1>Get Marksheet</h1>
        
        <table align ="center">
        <tr>
                    <td class="label">
                        Roll No:
                    </td>
                    <td>
                <input type="text" name="rollNo" value="">&emsp;
                       
                    </td>
                    <tr>
                        <td colspan="2" align="right">
                <input type="submit" name="operation" value="Go">
                        </td>
        </table>
       
            <table border="1" style="background-color: BurlyWood; text-align: center;" width="100%">
                
                    </tr>
                    <%if(bean!=null){ %>
                    <tr>
                    <td><%=bean.getId() %></td>
                    <td><%=bean.getRollNo() %></td>
                    <td><%=bean.getFname() %></td>
                    <td><%=bean.getLname() %></td>
                    <td><%=bean.getPhy() %></td>
                    <td><%=bean.getChem() %></td>
                    <td><%=bean.getMath() %></td>
                    
                    
                    </tr>
                    
                    
                    <%} %>
                    
            </table>

        </form>
    </center>

</body>
</html>