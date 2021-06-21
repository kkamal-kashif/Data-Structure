package com.kk.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Account implements Serializable {
	String userName = "Bhaskar";
	transient String pwd = "kajal";

	private void writeObject(ObjectOutputStream os) throws Exception {
		System.out.println("write");
		os.defaultWriteObject();
		String epwd = "123" + pwd;
		os.writeObject(epwd);
	}

	private void readObject(ObjectInputStream is) throws Exception {
		System.out.println("read");
		is.defaultReadObject();
		String epwd = (String) is.readObject();
		pwd = epwd.substring(3);
	}
}

public class CustomizedSerialization1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Account a1 = new Account();
		System.out.println(a1.userName + "........." + a1.pwd);
		File file = new File("D:/test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(a1);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Account a2 = (Account) ois.readObject();
		
		//if we dont implement writeObject and readObject
		// a2.pwd= null ; as pwd is transient
		System.out.println(a2.userName + "........." + a2.pwd);
	}

}
