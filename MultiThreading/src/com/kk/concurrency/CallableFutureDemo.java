package com.kk.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable {
	int num;

	public MyCallable(int num) {
		this.num = num;
	}

	public Object call() throws Exception {
		int sum = 0;
		System.out.println(Thread.currentThread().getName() + "sum of first " + num);
		for (int i = 0; i < num; i++) {
			sum = sum+i;
		}
		return sum;
		}
	}

public class CallableFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable[] jobs = {new MyCallable(10),
							 new MyCallable(20),
							 new MyCallable(30),
							 new MyCallable(40),
							 new MyCallable(50)
		};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(MyCallable job : jobs){
			Future r = service.submit(job);
			System.out.println(r.get());
		}
		service.shutdown();
		}

	 

}
