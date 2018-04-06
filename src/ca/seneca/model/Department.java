package ca.seneca.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	private long departmentId;
	private String departmentName;
	private java.math.BigDecimal locationId;
	private java.math.BigDecimal managerId;
	private List<Employee> employees;
	public Department() {
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public java.math.BigDecimal getLocationId() {
		return this.locationId;
	}

	public void setLocationId(java.math.BigDecimal locationId) {
		this.locationId = locationId;
	}

	public java.math.BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(java.math.BigDecimal managerId) {
		this.managerId = managerId;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/*public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}*/

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}

}