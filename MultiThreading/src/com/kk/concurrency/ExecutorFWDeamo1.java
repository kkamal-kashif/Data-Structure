package com.kk.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFWDeamo1 {

	public static void main(String[] args) {
		System.out.println("Thread main started");
		Runnable task1 = () -> {
			System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable task2 = () -> {
			System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable task3 = () -> {
			System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(task1);
		executorService.submit(task2);
		executorService.submit(task3);

		executorService.shutdown();
	}

}
