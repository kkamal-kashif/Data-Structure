package com.kk;

class MyThread1 implements Runnable {
	public void run() {

		try {
			for (int i = 0; i < 5; i++) {
				//Thread.yield();
				System.out.println("child thread " + Thread.currentThread().getName() + " - " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("interrrrrr");
			e.printStackTrace();
		}

	}
}

public class ByRunnable {

	public static void main(String[] args) throws InterruptedException {

		MyThread1 mt = new MyThread1();
		Thread t1 = new Thread(mt, "Thread-1");

		t1.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("child thread " + Thread.currentThread().getName() + " - " + i);
			Thread.sleep(500);
		}
		//t1.interrupt();
	}

}
