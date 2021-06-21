package com.kk.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*Create a class EofIndicatorClass which implements Serializable interface.
During serialization >Write instance of EofIndicatorClass at EOF during serialization 
to indicate EOF during deSerialization process.

During deserialization > If oin.readObject() returns instanceof EofIndicatorClass that means it's EOF, 
exit while loop and EOFException will not be thrown*/

class EOFIndicatorClass implements Serializable {
	private static final long serialVersionUID = 1L;
}

class Emp1 implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;

	public Emp1(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}

public class DeserWithEOF_solution {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Emp1 e1 = new Emp1("amy");
		Emp1 e2 = new Emp1("ankit");
		File file = new File("D:/test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.writeObject(new EOFIndicatorClass());
		oos.close();
		System.out.println("Object Serialization completed.");

		// deser
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object o;
		/*
		 * If ois.readObject() returns instanceof EofIndicatorClass that means
		 * it's EOF, exit while loop and EOFException will not be thrown.
		 */
		while (!((o = ois.readObject()) instanceof EOFIndicatorClass)) {
			System.out.println(o);
		}
		ois.close();
		System.out.println("Object deserialization completed.");
	}
}
