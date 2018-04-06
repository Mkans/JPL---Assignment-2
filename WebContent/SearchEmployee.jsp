<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employees</title>
</head>
<body>
<p>Search for an Employee by typing any part of a name, email address, phone number or department</p>
<form action="SearchEmployee" method="post">
<input type="text" placeholder="enter any part of employee" name="employeeID">&nbsp;&nbsp;<input type="submit" value ="Go" name="ShowEmployees">
</form>
</body>
</html>