package com.kk.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}

public class SerializationDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		Employee e1 = new Employee(1, "amy");
		Employee e2 = new Employee(2, "ankit");

		File file = new File("C:/Users/Kashif/Desktop/test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		System.out.println("Serialization process has started, serializing employee objects...");
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.close();
		System.out.println("Object Serialization completed.");

		System.out.println("DeSerialization process has started, displaying employee objects...");

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Employee emp;
		// Employee emp = (Employee) ois.readObject();
		while ((emp = (Employee) ois.readObject()) != null) {
			System.out.println(emp);
		}
		ois.close();
		System.out.println("Object DeSerialization completed.");
	}

}
