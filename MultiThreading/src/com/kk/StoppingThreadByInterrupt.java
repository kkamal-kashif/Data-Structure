package com.kk;

import java.io.IOException;

class MyRunnable implements Runnable {

	public void run() {
		int i = 0;

		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(500);
				System.out.println(i++ + " Please press enter to stop " + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " ENDED");
		}
	}
}

public class StoppingThreadByInterrupt {

	public static void main(String[] args) throws IOException {

		MyRunnable obj = new MyRunnable();
		Thread t = new Thread(obj, "Thread-1");
		t.start();
		System.out.println(Thread.currentThread().getName() + "thread waiting for user to press enter");
		System.in.read();
		t.interrupt();
		System.out.println(Thread.currentThread().getName() + " thread ENDED");
	}

}
