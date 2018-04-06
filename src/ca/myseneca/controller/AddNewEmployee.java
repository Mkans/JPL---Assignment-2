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
 * Servlet implementation class AddNewEmployee
 */
@WebServlet("/AddEmployee")
public class AddNewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionPool newPool = ConnectionPool.getInstance();
	Connection newConn = null;          
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewEmployee() {
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
		String query = "INSERT INTO employees";
		try {
			newConn = newPool.getConnection();
			System.out.println("Connected");	
			if(newConn == null) {
				System.out.println("Not loaded with server");
			}
			stmt = newConn.prepareStatement(query);
			String firstName = request.getParameter("fName");
			String lastName = request.getParameter("lName");
			String email = request.getParameter("email");
			String phoneNo= request.getParameter("phoneNo");
			String jobId = request.getParameter("jobId");
			Integer empID = Integer.parseInt(request.getParameter("empId"));
			//hiredate
			Integer salary = Integer.parseInt(request.getParameter("salary"));
			Float commissonPct = Float.parseFloat(request.getParameter("commissonPct"));
			//manager ID
			Integer departmentID = Integer.parseInt(request.getParameter("departmentID"));
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
