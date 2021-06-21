package com.kk.concurrency;

import java.lang.Thread.UncaughtExceptionHandler;

class MyExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
		//new Thread(new Test()).start(); //Restart Thread Using UncaughtExceptionHandler
	}

}

class Test implements Runnable {

	@Override
	public void run() {
		 System.out.println(Integer.parseInt("123"));
	      System.out.println(Integer.parseInt("234"));
	      System.out.println(Integer.parseInt("345"));
	      System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
	      System.out.println(Integer.parseInt("456"));
	}

}

public class UncaughtExceptionHandlerDemo {

	public static void main(String[] args) throws Exception {
		Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
		Test t = new Test();
		Thread th = new Thread(t);
		th.start();
		System.out.println("main thread");
	}

}
