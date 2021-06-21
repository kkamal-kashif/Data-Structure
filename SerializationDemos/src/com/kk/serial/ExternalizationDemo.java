package com.kk.serial;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Empl2 implements Externalizable {
	private Integer id;
	private String name;

	// This constructor is called during deSerializaition process, as we have
	// implemented Externalizable. Every Externalizable class should compulsory
	// contains public no-arg constructor otherwise we will get RuntimeExcepion
	// saying "InvaidClassException" .
	Empl2() {
	}

	Empl2(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("in writeExternal()");
		out.writeInt(id);
		out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("in readExternal()");
		this.id = in.readInt();
		this.name = (String) in.readObject();
	}
}

public class ExternalizationDemo {

	public static void main(String[] args) {
		Empl2 e1 = new Empl2(1, "amy");
		Empl2 e2 = new Empl2(2, "ankit");

		try {
			File file = new File("D:/test.txt");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			System.out.println("Serialization process has started, serializing employee objects...");
			oos.writeObject(e1);
			oos.writeObject(e2);
			oos.close();
			System.out.println("Object Serialization completed.");

			System.out.println("DeSerialization process has started, displaying deSerialized employee objects...");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Empl2 emp;
			System.out.println(ois.readInt());
			while ((emp = (Empl2) ois.readObject()) != null) {
				System.out.println("----" + emp);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Object DeSerialization completed.");
	}

}
