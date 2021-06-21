package com.kk.clone;

class Department1 implements Cloneable {
	private int id;
	private String name;

	public Department1(int id, String name) {
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Employee1 implements Cloneable {

	int empoyeeId;
	String employeeName;
	Department1 department;

	public Employee1(int id, String name, Department1 dept) {
		this.empoyeeId = id;
		this.employeeName = name;
		this.department = dept;
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

	public Department1 getDepartment() {
		return department;
	}

	public void setDepartment(Department1 department) {
		this.department = department;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee1 cloned = (Employee1) super.clone();
		cloned.setDepartment((Department1) department.clone());
		return cloned;
	}
}

public class DeepCopyDemo implements Cloneable {

	public static void main(String[] args) throws CloneNotSupportedException {

		Department1 dept = new Department1(1, "Human Resource");
		Employee1 original = new Employee1(1, "Admin", dept);

		Employee1 cloned = (Employee1) original.clone();

		cloned.getDepartment().setName("Finance");
		cloned.employeeName = "kkkkk";
		System.out.println(original.getDepartment().getName());
		System.out.println(cloned.getDepartment().getName());

		System.out.println(original.getEmployeeName());
		System.out.println(cloned.getEmployeeName());

	}

}
