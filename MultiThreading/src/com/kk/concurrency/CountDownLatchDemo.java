package com.kk.concurrency;

import java.util.concurrent.CountDownLatch;

class Service implements Runnable {
	CountDownLatch latch;
	String serviceName;
	int delay;

	public Service(CountDownLatch latch, String serviceName, int i) {
		this.latch = latch;
		this.serviceName = serviceName;
		this.delay = i;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(serviceName + " is Up");
		latch.countDown();// reduce count of CountDownLatch by 1
		System.out.println("latch count" + latch.getCount());
	}

}

public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		Service catchSevice = new Service(latch, "CatchSevice", 1000);
		Service alertSevice = new Service(latch, "AlertSevice", 2000);
		Service validationSevice = new Service(latch, "ValidationSevice", 3000);
		
		new Thread(catchSevice).start();
		new Thread(alertSevice).start();
		new Thread(validationSevice).start();

		try {
			System.out.println("latch count in main - " + latch.getCount());
			latch.await(); // main thread is waiting on CountDownLatch to finish
			System.out.println("All services are up, Application is starting now");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}
