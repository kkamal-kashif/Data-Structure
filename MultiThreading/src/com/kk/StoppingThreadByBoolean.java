package com.kk;

import java.io.IOException;

class MyRunnable11 implements Runnable {
	boolean continueThread = true;
	int i = 0;
	public void run() {
		 
		try {
			while (continueThread) {
				Thread.sleep(500);
				System.out.println(i++ + " Please press enter to stop " + Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " ENDED");
		}
	}
}
public class StoppingThreadByBoolean {

	public static void main(String[] args) throws IOException {
		MyRunnable11 obj = new MyRunnable11();
		Thread t = new Thread(obj, "Thread-1");
		t.start();
		System.out.println(Thread.currentThread().getName()+"thread waiting for user to press enter");
		//main thread entered from running to waiting state, bcoz of System.in.read()
		System.in.read();
		obj.continueThread = false;
		System.out.println(Thread.currentThread().getName()+" thread ENDED");
	}

}
