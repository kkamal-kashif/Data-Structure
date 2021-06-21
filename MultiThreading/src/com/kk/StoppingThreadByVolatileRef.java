package com.kk;

public class StoppingThreadByVolatileRef {

	public static void main(String[] args) {
		MyStopThread myThread = new MyStopThread();
		myThread.start();

	}

	private static class MyStopThread extends Thread {
		private volatile Thread stopIndicator;

		public void start() {
			stopIndicator = new Thread(this);
			stopIndicator.start();
		}

		public void stopThread() {
			stopIndicator = null;
		}

		@Override
		public void run() {
			Thread thisThread = Thread.currentThread();
			while (thisThread == stopIndicator) {
				System.out.println("on run");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
