package com.kk.concurrency;

import java.util.concurrent.Semaphore;

class IncrementThread implements Runnable {
	Semaphore semaphore;

	public IncrementThread(Semaphore s) {
		semaphore = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is waiting for permit");
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " has got permit");
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " > " + SemaphoreDemo.SharedValue++);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " has released permit");
		semaphore.release();
	}

}

public class SemaphoreDemo {
	static int SharedValue = 0;

	public static void main(String[] args) {
		System.out.println("Semaphore with 1 permit has been created");
		Semaphore semaphore = new Semaphore(1); //  only one threads that
												// can access shared resource at
												// a time.
		IncrementThread it = new IncrementThread(semaphore);
		new Thread(it, "incrementThreadA").start();
		new Thread(it, "incrementThreadB").start();
	}

}
