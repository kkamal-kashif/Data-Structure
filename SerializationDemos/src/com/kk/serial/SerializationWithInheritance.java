package com.kk.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal{
	int i = 10;

	Animal() {
		System.out.println("Animal constructor called");
	}
}

class Dog extends Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	int j = 20;

	Dog() {
		super();
		System.out.println("Dog constructor called");
	}
}

public class SerializationWithInheritance {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog d1 = new Dog();
		d1.i = 888;
		d1.j = 999;
		File file = new File("C:/Users/Kashif/Desktop/test.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		System.out.println(d1.i+" "+d1.j);
		oos.writeObject(d1);
		oos.close();

		System.out.println("Deserialization started");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d2 = (Dog) ois.readObject();
		System.out.println(d2.i + "........." + d2.j);
		ois.close();

	}

}
