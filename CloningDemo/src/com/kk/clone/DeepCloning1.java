package com.kk.clone;

class Address implements Cloneable {
	String dno;
	String city;

	public Address(String dno, String city) {
		super();
		this.dno = dno;
		this.city = city;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Student implements Cloneable {
	int sno;
	String name;
	Address address;

	public Student(int sno, String name, Address address) {
		super();
		this.sno = sno;
		this.name = name;
		this.address = address;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student student = (Student) super.clone();
		student.address = (Address) address.clone();
		return student;
	}
}

public class DeepCloning1 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address addr = new Address("3-100", "HYDERABAD");
		Student s1 = new Student(101, "Satya", addr);
		Student s2 = (Student) s1.clone();
		System.out.println(s1.address.city + " : " + s2.address.city);

		s2.address.city = "KANPUR";
		System.out.println(s1.address.city + " : " + s2.address.city);
	}

}
