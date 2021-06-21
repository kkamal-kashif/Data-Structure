package com.kk.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Emp2 implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
 
    public Emp2(Integer id, String name) {
           this.id = id;
           this.name = name;
    }
    
    private void writeObject(ObjectOutputStream oos){
    	 System.out.println("In, writeObject() method.");    
         try {
        	 oos.writeInt(this.id);
        	 oos.writeObject(this.name);
         }catch(Exception e){
        	 e.printStackTrace();
         }
    }
    
    private void readObject(ObjectInputStream ois) {
    	 System.out.println("In, readObject() method.");
         try {
        	 id = ois.readInt();
        	 name = (String) ois.readObject();
         }catch(Exception e){
        	 e.printStackTrace();
         }
    }
    
    @Override
    public String toString() {
           return "Employee [id=" + id + ", name=" + name + "]";
    }
}
public class CustomSerialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Emp2 e1 = new Emp2(1, "amy");
		Emp2 e2 = new Emp2(2, "ankit");

		File file = new File("C:/Users/Kashif/Desktop/test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		System.out.println("Serialization process has started, serializing employee objects...");
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.close();
		System.out.println("Object Serialization completed.");

		System.out.println("DeSerialization process has started, displaying employee objects...");

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Emp2 emp;
		// Employee emp = (Employee) ois.readObject();
		while ((emp = (Emp2) ois.readObject()) != null) {
			System.out.println(emp);
		}
		ois.close();
		System.out.println("Object DeSerialization completed.");

	}

}
