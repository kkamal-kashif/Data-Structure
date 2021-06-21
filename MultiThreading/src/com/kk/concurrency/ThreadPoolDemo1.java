package com.kk.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable {
	int taskNumber;

	public MyTask(int i) {
		this.taskNumber = i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing task no " + taskNumber);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class ThreadPoolDemo1 {
	// nThreads number of threads will be created and started in executor.
	private static int nThreads = 2;

	// nTasks number of tasks will be executed.
	private static int nTasks = 10;

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		System.out.println("executor created with 2 threads.");
		System.out.println("2 threads in executor will be used for executing 10 tasks. "
				+ "So, at a time only 2 tasks will be executed");
		for (int i = 1; i <= nTasks; i++) {
			MyTask task = new MyTask(i);
			executor.execute(task);
		}
		 /*
         * Initiates shutdown of executor, previously submitted tasks are
         * executed, but no new tasks will be accepted.
         */
        executor.shutdown();
        System.out.println("executor has been shutDown.");
	}

}
