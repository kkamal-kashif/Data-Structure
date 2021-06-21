package com.kk.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Defining readResolve() method ensures that we don't break singleton pattern during DeSerialization process.

class SingletonClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private static SingletonClass INSTANCE = null;

	// 	//Double locked singleton
	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonClass.class) {
				INSTANCE = new SingletonClass();
			}
		}
		return INSTANCE;
	}

	// constructor
	private SingletonClass() {
		System.out.println("private constructor");
	}

	/**
	 * customize Serialization process.
	 */
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		System.out.println("in readObject()");
		ois.defaultReadObject();
		synchronized (SingletonClass.class) {
			if (INSTANCE == null) {
				INSTANCE = this;
			}
		}
	}

	/**
	 * Method ensures that we don't break singleton pattern during
	 * DeSerialization process- method must not be called other than
	 * DeSerialization time.
	 */
	private Object readResolve() {
		System.out.println("in readResolve()");
		return INSTANCE;
	}
}

public class DeserializationForSingletonClass {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Are objects same before serialization : " + (SingletonClass.getInstance() == SingletonClass.getInstance()));
		SingletonClass singObj = SingletonClass.getInstance();
		File file = new File("D:/test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		// oos.writeObject(d1);
		
		System.out.println("Serialization process has started...");
		oos.writeObject(singObj);
		oos.close();
		System.out.println("Object Serialization completed.");

		// DeSerialization process >>>>>>>.

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		System.out.println("\nDeSerialization process has started...");
		SingletonClass deSerializedObj = (SingletonClass) ois.readObject();
		ois.close();
		System.out.println("Object DeSerialization completed.");
		System.out
				.println("Are objects same after serialization : " + (deSerializedObj == SingletonClass.getInstance()));

	}

}
