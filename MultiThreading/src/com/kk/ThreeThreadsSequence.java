package com.kk;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadsSequence {
	AtomicInteger sharedOutput = new AtomicInteger(0);
	private Object lock = new Object();

	public static void main(String... args) {
		ThreeThreadsSequence t = new ThreeThreadsSequence();
		MyThread t1 = t.new MyThread(0);
		MyThread t2 = t.new MyThread(1);
		MyThread t3 = t.new MyThread(2);

		new Thread(t1, "Thread1").start();
		new Thread(t2, "Thread2").start();
		new Thread(t3, "Thread3").start();
	}

	private class MyThread implements Runnable {
		private final int threadPosition;

		public MyThread(int threadPosition) {
			super();
			this.threadPosition = threadPosition;
		}

		@Override
		public void run() {
			while (sharedOutput.get() < 9) {
				synchronized (lock) {
					if (sharedOutput.get() % 3 == this.threadPosition) {
							System.out.println(Thread.currentThread() + "  " + sharedOutput.incrementAndGet());
					}
				}
			}
		}
	}

}
