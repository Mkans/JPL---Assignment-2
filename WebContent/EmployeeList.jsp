<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<form action="EmpL" method="post">
<b>Department ID :</b><input type="number" placeholder="enter the department id" name="departmentID"><br>
<input type="submit" value ="Show Department Employees" name="ShowDepartmentEmployees">
</form>
<form action="ShowAllEmployee" method="post">
<input type="submit" value ="Show All Employees" name="ShowAllEmployees">
</form>
</body>
</html>