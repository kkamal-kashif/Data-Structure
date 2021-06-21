package com.kk;

import java.util.Date;

class MyRun implements Runnable {
	ThreadLocal<String> tl = new ThreadLocal<String>();

	@Override
	public void run() {
		tl.set(new Date().toString());
		
		System.out.println(Thread.currentThread().getName()+" start time = "+tl.get());

	}
}

public class ThreadLocalDemo {

	public static void main(String[] args) {
		MyRun mr = new MyRun();
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();

	}

}
