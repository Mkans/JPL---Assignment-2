<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ca.seneca.model.Employee"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<style>
table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}
tr:hover {background-color: #f5f5f5;}
tr:nth-child(even) {background-color: #f2f2f2;}
</style>
<body>
	<table style = "border-collapse: collapse;border: 1px solid black;">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Salary</th>
			<th>Commission Percentage</th>
			<th>manager Id</th>
			<th>Department Id</th>	
			<th>Job Id</th>
		</tr>
		<%
			ArrayList<Employee> employeeList = (ArrayList<Employee>) request.getAttribute("employeeList");
			if (employeeList != null) {
				for (Employee c : employeeList) {
		%>
		<tr>
			<td><%=c.getEmployeeId()%></td>
			<td><%=c.getFirstName()%></td>
			<td><%=c.getLastName()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getPhoneNumber()%></td>
			<td><%=c.getSalary()%></td>
			<td><%=c.getCommissionPct()%></td>
			<td><%=c.getJobId()%></td>
			<td><%=c.getDepartment()%></td>
			<td><%=c.getJobId()%></td>
		</tr>
		<% } 
	}%>
	</table>
</body>
</html>