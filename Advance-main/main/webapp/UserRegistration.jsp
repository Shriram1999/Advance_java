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
		<form action="UserCtl" method="post">
			<table>
				<h1>Student Registration form</h1>


				<tr>
					<th>Name</th>
					<td><input type="text" name="name"
						placeholder="Enter Full name" ></td>
				</tr>
				<tr>
					<th>Phone Number</th>
					<td><input type="text" name="number" placeholder="+91"
						></td>
				</tr>


				<tr>
					<th>Email</th>
					<td><input type="text" name="email" placeholder="@gmail.com"
						></td>
				</tr>
                <TR>
					<th>password</th>
					<td><input type="password" name="password" value=""></td>
					</TR>
					

				<tr>
					<th>Gender</th>
					<td><input type="radio" name="gender" value="Male">Male
						<input type="radio" name="gender" value="Female">Female <input
						type="radio" name="gender" value="Other">Other</td>
				</TR>
				<tr>
					<th>Date Of Birth</th>
					<td><input type="Date" name="Date" value="Date"></td>
				</tr>


				<tr>
					<th>Address</th>
					<td><input type="text" name="address"
						placeholder="Enter Address"></td>
				</tr>


				
				<tr>
					<td>I AGREE<input type="checkbox"></td>
				</tr>


				<tr>
					<th></th>
					<td><input type="Submit" value="Submit"> <input
						type="Reset" value="Reset"></td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>