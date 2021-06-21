package com.kk.clone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShallowDemo implements Cloneable {
	private String name;
	private Map<Integer, Integer> map;

	public ShallowDemo(String name, Map<Integer, Integer> map) {
		super();
		this.name = name;
		this.map = map;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 11);
		ShallowDemo t1 = new ShallowDemo("kash", map);
		System.out.println(t1.map);
		ShallowDemo t2 = (ShallowDemo) t1.clone();
		map.put(2, 22);
		System.out.println(t1.map + "------" + t2.map);
	}
}
