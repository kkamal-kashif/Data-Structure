package com.kk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyRun3 implements Runnable {
	MyRun3 next;
	BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();

	@Override
	public void run() {
		int i = 0;
		while (i<10) {
			try {
				Thread.sleep(500);
				bq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " = " + i);
			// Now, current thread is executed , calling accept will call ,
			// bq.put(i), which will end blocking state of thread on next object
			next.accept(++i);
		}

	}

	public void accept(int i) {
		try {
			bq.put(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreeThreads123Printing {

	public static void main(String[] args) {
		MyRun3 m1 = new MyRun3();
		MyRun3 m2 = new MyRun3();
		MyRun3 m3 = new MyRun3();

		// chain all objects
		m1.next = m2;
		m2.next = m3;
		m3.next = m1;

		new Thread(m1, "Thread1").start();
		new Thread(m2, "Thread2").start();
		new Thread(m3, "Thread3").start();

		// Wait make first thread to run
		m1.accept(1);
	}

}
