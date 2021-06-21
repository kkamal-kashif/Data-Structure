package com.kk.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SumIntegerCallable implements Callable {

	Integer n;

	SumIntegerCallable(Integer n) {
		this.n = n;
	}

	int sum = 0;

	@Override
	public Object call() throws Exception {

		for (int i = 1; i <= n; i++) {
			System.out.println("=============");
			Thread.sleep(500);
			sum = sum + i;
		}
		return sum;
	}

}

public class CallableFutureDemo1 {

	private static final int NTHREDS = 10;

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		SumIntegerCallable mr = new SumIntegerCallable(4);
		Future<Integer> r = executor.submit(mr);
		Thread.sleep(6000);
		System.out.println("---------------------");
		try {
			System.out.println("SumIntegerCallable has returned > " + r.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

		executor.shutdown();

	}

}
