<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new employee</title>
</head>
<body>
<h1>New Employee Page</h1>
<form action="AddEmployee" method="post">
<b>Employee ID: </b><input type="text" name="empId"><br>
<b>First Name: </b><input type="text"  name="fName"><br>
<b>Last Name: </b><input type="text"  name="lName"><br>
<b>Email: </b><input type="email"  name="email"><br>
<b>Phone Number: </b><input type="text" name="phoneNo"><br>
<b>Hire Date: </b><input type="date" name="hireDate"><br>
<b>Job ID: </b><input type="text"  name="jobId"><br>
<b>Salary: </b><input type="number"  name="salary"><br>
<b>Comm Pct: </b><input type="number"  name="commissonPct"><br>
<b>Manager ID: </b><input type="text"  name="managerId"><br>
<b>Department: </b><input type="text"  name="department"><br>
<input type="submit" value ="Save the New Employee" name="ShowAllEmployees">
<input type="reset" value ="Clear" name="ShowAllEmployees">

</form>
</body>
</html>