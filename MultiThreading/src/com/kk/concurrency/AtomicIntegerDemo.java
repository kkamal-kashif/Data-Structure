package com.kk.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

class MyRunn implements Runnable {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+ " - " +AtomicIntegerDemo.sharedAtomicInteger.incrementAndGet());
		}

	}
}

public class AtomicIntegerDemo {

	//Create a new AtomicInteger and is initialized to 0.
    static AtomicInteger sharedAtomicInteger =new AtomicInteger();

	public static void main(String... args) throws InterruptedException {
		MyRunn runnable = new MyRunn();
		Thread thread1 = new Thread(runnable, "Thread-A");
		Thread thread2 = new Thread(runnable, "Thread-B");
		Thread thread3 = new Thread(runnable, "Thread-C");
		thread1.start();
		thread2.start();
		thread3.start();
		
		Thread.sleep(1000); // delay to ensure Thread-1 and Thread-2 finish
		System.out.println("After completion of both threads, " + "sharedInteger = " + sharedAtomicInteger);

	}

}
