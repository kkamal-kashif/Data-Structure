package com.kk.concurrency;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {
		System.out.println("Thread main started");
		// Create a task
		Runnable task1 = () -> {
			System.out.println("Executing the task1 at: " + new Date());
		};

		// Create a task
		Runnable task2 = () -> {
			System.out.println("Executing the task2 at: " + new Date());
		};
		ScheduledExecutorService scheduledExec = Executors.newScheduledThreadPool(2);
		System.out.println("Scheduling task to run after 5 seconds... " + new Date());
		scheduledExec.schedule(task1, 5, TimeUnit.SECONDS);
		scheduledExec.schedule(task2, 10, TimeUnit.SECONDS);

		scheduledExec.shutdown();
		System.out.println("Thread main finished");
	}

}
