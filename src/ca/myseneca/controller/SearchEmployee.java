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
 * Servlet implementation class SearchEmployee
 */
@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionPool newPool = ConnectionPool.getInstance();
	Connection newConn = null;          
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static boolean TryParseOne(String input) {
    	try { 
    		Integer.parseInt(input); 
    		return true; 
    		} catch (NumberFormatException e) {
    		    System.out.println("This is not an integer.");
    		    return false; 
    		} 
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
		try {
			newConn = newPool.getConnection();
			System.out.println("Connected");	
			if(newConn == null) {
				System.out.println("Not loaded with server");
			}
			
			String first_name = request.getParameter("employeeID");
			String last_name = request.getParameter("employeeID");
			String email = request.getParameter("employeeID");
			String phone_number = request.getParameter("employeeID");
			if (TryParseOne(request.getParameter("employeeID"))) {
				String query = "SELECT * FROM employees WHERE first_name LIKE ? OR last_name LIKE ? OR"
						+ " email LIKE ? OR phone_number LIKE ? OR department_id LIKE ?";
				Integer department_id = Integer.parseInt(request.getParameter("employeeID"));
				stmt = newConn.prepareStatement(query);
				stmt.setString(1,'%'+first_name+ '%');
				stmt.setString(2,'%'+last_name+ '%');
				stmt.setString(3,'%'+email+ '%');
				stmt.setString(4,'%'+phone_number+ '%');
				stmt.setInt(5,department_id);
			}
			else {
				String query = "SELECT * FROM employees WHERE first_name LIKE ? OR last_name LIKE ? OR"
						+ " email LIKE ? OR phone_number LIKE ?";
				stmt = newConn.prepareStatement(query);
				stmt.setString(1,'%'+first_name+ '%');
				stmt.setString(2,'%'+last_name+ '%');
				stmt.setString(3,'%'+email+ '%');
				stmt.setString(4,'%'+phone_number+ '%');
			}
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
