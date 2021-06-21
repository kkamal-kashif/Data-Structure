package com.kk.concurrency;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//execute a task after a period of time or to execute a task periodically
public class SchedulingTasksWithScheduledThreadPool {

	public static void main(String[] args) {
		Runnable task1 = () -> {
			System.out.println("Executing the task1 at: " + new Date());
		};

		// Create a task
		Runnable task2 = () -> {
			System.out.println("Executing the task2 at: " + new Date());
		};
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		System.out.println("Scheduling task to run after 5 seconds... " + new Date());
		scheduledExecutorService.schedule(task1, 5, TimeUnit.SECONDS);
		scheduledExecutorService.schedule(task2, 5, TimeUnit.SECONDS);
		
		System.out.println("shutting down");
		scheduledExecutorService.shutdown();
	}

}
