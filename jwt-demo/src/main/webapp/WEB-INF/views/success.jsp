<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot</title>
</head>
<body>
	<h1>Patient Insurance Registration Form</h1>

	<p>Congratulations ${form.firstName} ,you have been successfully
		registered</p>
	<form action="/" method="post">
		<tr>
			<td><input type="submit" value="Cancel"></td>
		</tr>
		
	</form>
</body>
</html>