/*
 * Author : Muthukumar Kandasamy
 * class name: Employee
 * description: Lab 6 - Java API interface 
 * 
 * */
package ca.seneca.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private long employeeId;

	private BigDecimal commissionPct;
	private String email;
	private String firstName;
	private Date hireDate;
	private String lastName;
	private BigDecimal managerId;
	private String phoneNumber;
	private int salary;
	private BigDecimal departmentId;
	private String jobId;

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public BigDecimal getDepartment() {
		return this.departmentId;
	}

	public void setDepartment(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String string) {
		this.jobId = string;
	}
	public String toString() {
		return "Name: "+ lastName+ ", " +firstName +" \t Salary: "+ salary;
		
	}

}