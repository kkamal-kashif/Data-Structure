package com.kk.clone;

class Department {
	private int id;
	private String name;

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Employee implements Cloneable {

	int empoyeeId;
	String employeeName;
	Department department;

	public Employee(int id, String name, Department dept) {
		this.empoyeeId = id;
		this.employeeName = name;
		this.department = dept;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getEmpoyeeId() {
		return empoyeeId;
	}

	public void setEmpoyeeId(int empoyeeId) {
		this.empoyeeId = empoyeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}

//create a separate obj for primitive and string and create a copy of reference , o orig and 
//cloned ref both will point to same obj.any change made will impct orig obj too.
public class ShallowCopyDemo implements Cloneable {

	public static void main(String[] args) throws CloneNotSupportedException {

		Department dept = new Department(1, "Human Resource");
		Employee original = new Employee(1, "Admin", dept);

		Employee cloned = (Employee) original.clone();

		cloned.getDepartment().setName("Finance");
		cloned.employeeName = "kkkkk";
		System.out.println(original.getDepartment().getName());
		System.out.println(cloned.getDepartment().getName());

		System.out.println(original.getEmployeeName());
		System.out.println(cloned.getEmployeeName());

	}

}
