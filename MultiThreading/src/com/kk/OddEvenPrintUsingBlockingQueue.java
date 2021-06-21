package com.kk;

import java.util.concurrent.LinkedBlockingQueue;

class MyRunn1 implements Runnable {

	MyRunn1 next;
	LinkedBlockingQueue<Integer> lbq;

	MyRunn1() {
		lbq = new LinkedBlockingQueue<>();
	}

	void accept(int i) {
		try {
			lbq.put(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				Thread.sleep(1000);
				// It will wait till lbq.put(i); is called ,
				// so only one thread will call it a time
				i = lbq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " = " + i);
			next.accept(i++);
		}
	}

}

public class OddEvenPrintUsingBlockingQueue {

	public static void main(String[] args) {
		MyRunn1 mr1 = new MyRunn1();
		MyRunn1 mr2 = new MyRunn1();

		// Chain all the objects
		mr1.next = mr2;
		mr2.next = mr1;

		new Thread(mr1, "Thread1").start();
		new Thread(mr2, "Thread2").start();

		// Wait make first thread to run
		mr1.accept(1);
	}

}
