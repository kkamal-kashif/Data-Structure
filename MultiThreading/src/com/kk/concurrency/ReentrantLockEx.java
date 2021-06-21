package com.kk.concurrency;

import java.util.concurrent.locks.ReentrantLock;
class Display{
	ReentrantLock rel = new ReentrantLock();
	public void wish(String name){
		rel.lock();
		for(int i=0;i<5;i++){
			System.out.println("Good morning "+name);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		rel.unlock();
	}
}

class MyThread1 extends Thread{
	Display d;
	String name;
	
	public MyThread1(Display d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	public void run(){
		d.wish(name);
	}
}
public class ReentrantLockEx {

	public static void main(String[] args) {
		Display d = new Display();
		MyThread1 mt1 = new MyThread1(d, "kashif");
		MyThread1 mt2 = new MyThread1(d, "kamal");
		mt1.start();
		mt2.start();
	}

}

