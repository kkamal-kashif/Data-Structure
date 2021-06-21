package com.kk.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//If any task throws an exception, the application will catch it and restart the task.
//If any task runs to completion, the application will notice and restart the task.
class TestOne implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("Executing task one");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TestTwo implements Runnable {
	public void run() {
		while (true) {
			System.out.println("Executing task two");
			try {
				Thread.sleep(1000);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}

public class RestartTaskAfterDoneOrCancel {
	private static volatile Future<?> taskOneResults = null;
	private static volatile Future<?> taskTwoResults = null;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		if (taskOneResults == null || taskOneResults.isCancelled() || taskOneResults.isDone()) {
			taskOneResults = executor.submit(new TestOne());
		}
		if (taskTwoResults == null || taskTwoResults.isCancelled() || taskTwoResults.isDone()) {
			taskTwoResults = executor.submit(new TestTwo());
		}

		executor.shutdown();
	}

}
