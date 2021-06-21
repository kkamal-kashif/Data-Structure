package com.kk.serial;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//here parent cons will not be called during deserialization bcoz of Externalization
class Parent {
	int p = 10;

	Parent() {
		System.out.println("Parent constructor called");
	}
}

class ExternalDemo extends Parent implements Externalizable {
	String s;
	int i;
	int j;

	public ExternalDemo() {
		System.out.println("child no-arg constructor");
	}

	public ExternalDemo(String s, int i, int j) {
		this.s = s;
		this.i = i;
		this.j = j;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(s);
		out.writeInt(i);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("read Ext");
		s = (String) in.readObject();
		i = in.readInt();
	}
}

public class ExternalizationWithInheritance {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ExternalDemo t1 = new ExternalDemo("ashok", 10, 20);
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t1);
		oos.close();
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ExternalDemo t2 = (ExternalDemo) ois.readObject();
		System.out.println(t2.s + "-------" + t2.i + "--------" + t2.j);
		ois.close();
	}

}
