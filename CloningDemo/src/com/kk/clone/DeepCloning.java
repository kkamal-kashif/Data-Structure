package com.kk.clone;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeepCloning implements Cloneable {
	private String name;
	private Map<Integer, Integer> map;

	public DeepCloning(String name, Map<Integer, Integer> map) {
		super();
		this.name = name;
		this.map = map;
	}
	protected Object clone() throws CloneNotSupportedException{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Iterator<Integer> itr = this.map.keySet().iterator();
		while(itr.hasNext()){
			 Integer key=itr.next();
             map.put(key,this.map.get(key) );
		}
		DeepCloning t = new DeepCloning(this.name, map);
		return t;
	}
	public static void main(String[] args) throws CloneNotSupportedException {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 11);
		DeepCloning t1 = new DeepCloning("kash", map);
		DeepCloning t2 = (DeepCloning) t1.clone();
		map.put(2, 22); //adding after cloning, so t2 won't be affected
		System.out.println(t1.map+"------"+t2.map);
	}
}
