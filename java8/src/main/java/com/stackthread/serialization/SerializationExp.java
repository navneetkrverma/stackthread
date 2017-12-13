package com.stackthread.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExp implements Serializable {

	/**
	 * 
	 */
	private SerializationExp() {
	};

	private static final long serialVersionUID = 1L;
	private String name;

	public static void main(String[] args) throws Exception {
		SerializationExp se = new SerializationExp();
		se.setName("navneet");
		FileOutputStream fos = new FileOutputStream("testSerialization.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(se);
		oos.close();
		System.out.println("done");

		FileInputStream fis = new FileInputStream(("testSerialization.ser"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		System.out.println(((SerializationExp) o).getName());
		ois.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
