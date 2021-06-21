package com.kk.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;
	PrintJob(String name){
		this.name = name;
	}
	public void run(){
		System.out.println(name+" job started by thread "+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+" job completed by thread "+Thread.currentThread().getName());
	}
}
public class ThreadPoolDemo {

	public static void main(String[] args) {
		PrintJob[] jobs = {new PrintJob("Anil"),
						   new PrintJob("Sunil"),
						   new PrintJob("Dinesh"),
						   new PrintJob("Durga"),
						   new PrintJob("Rajeev"),
						   new PrintJob("Raja")
		};
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(PrintJob job: jobs){
			service.submit(job);
		}
		service.shutdown();
	}

}
