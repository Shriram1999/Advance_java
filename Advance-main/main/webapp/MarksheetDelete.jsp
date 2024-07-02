<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
    <center>
        <form action="MarksheetCtll" method="post">
        
        
            <h1>Delete Marksheet record</h1>
            <center style=" color: red">
				
			</center> 
            <table>
                <tr>
                    <th>Rollno*</th>
                    <td><input type="text" name="RollNo" value="">                            
                    </td>
                </tr>
                <tr>
                    <th>First Name*</th>
                     <td><input type="text" name="Fname" value=""> 
				 </td>
                    
                </tr>
                 <tr>
                    <th>Last Name*</th>
                     <td><input type="text" name="Lnme" value=""> 
 	
			
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
                    <td align="center"><input type="submit" name="operation" value="Save"> <input type="submit" name="operation" value="Cancel"></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>