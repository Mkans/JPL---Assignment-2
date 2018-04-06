package ca.myseneca.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.seneca.model.Employee;

/**
 * Servlet implementation class EmployeeList
 */
@WebServlet("/EmpL")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionPool newPool = ConnectionPool.getInstance();
	Connection newConn = null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet rset = null;
		PreparedStatement stmt= null;
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		String query = "SELECT * FROM employees where DEPARTMENT_ID = ?";
		try {
			newConn = newPool.getConnection();
			System.out.println("Connected");	
			if(newConn == null) {
				System.out.println("Not loaded with server");
			}
			stmt = newConn.prepareStatement(query);
			Integer departmentID = Integer.parseInt(request.getParameter("departmentID"));
			stmt.setFloat(1,departmentID);
	        rset = stmt.executeQuery();
	        while (rset.next()) {
				Employee newEmp = new Employee();
				newEmp.setEmployeeId(rset.getInt(1));
				newEmp.setFirstName(rset.getString(2));
				newEmp.setLastName(rset.getString(3));
				newEmp.setEmail(rset.getString(4));
				newEmp.setPhoneNumber(rset.getString(5));
				//newEmp.setHireDate(rset.getDate(6));
				newEmp.setJobId(rset.getString(7));
				newEmp.setSalary(rset.getInt(8));
				newEmp.setCommissionPct(rset.getBigDecimal(9));
				newEmp.setManagerId(rset.getBigDecimal(10));
				newEmp.setDepartment(rset.getBigDecimal(11));
				employeeList.add(newEmp);
			}
			request.setAttribute("employeeList", employeeList);
			this.getServletContext().getRequestDispatcher("/ShowEmployee.jsp")
			.forward(request, response);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rset != null) {
					rset.close();
					rset = null;
					}
				if (stmt != null) {
					stmt.close();
					stmt = null;
					}
				if (newPool != null)
					newPool.freeConnection(newConn);
					} catch (SQLException sqle) {
						sqle.printStackTrace();
						}
				}
	}
}

