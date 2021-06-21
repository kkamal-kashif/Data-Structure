package com.kk.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Serialization is another easy way of deep cloning.
class SerializableClass implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName = null;
	private String lastName = null;
	@SuppressWarnings("unchecked")
	private List<String> permissions = new ArrayList() {
		{
			add("ADMIN");
			add("USER");
		}
	};

	public SerializableClass(final String fName, final String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(getFirstName() + ",").append(getLastName() + ",").append(permissions)
				.toString();
	}

	public SerializableClass deepCopy() throws IOException, ClassNotFoundException {
		// Serialization of object

		ByteArrayOutputStream baos = new ByteArrayOutputStream(); // in-memory
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);

		// De-serialization of object
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		SerializableClass copied = (SerializableClass) ois.readObject();
		return copied;
	}

}

public class DeepCopyWithSerialization {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// Create instance of serializable object
		SerializableClass myClass = new SerializableClass("Lokesh", "Gupta");
		// Verify the content
		System.out.println(myClass);

		// Now create a deep copy of it
		SerializableClass deepCopiedInstance = myClass.deepCopy();
		// Again verify the content
		System.out.println(deepCopiedInstance);
	}
}