package com.kk.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//Shared class used by both threads
class SharedPrinter {
	// boolean evenFlag = false;
	Semaphore semEven = new Semaphore(0);
	Semaphore semOdd = new Semaphore(1);

	// Method for printing even numbers
	public void printEvenNum(int num, String t) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t + " - " + num);
		semOdd.release();
	}

	// Method for printing odd numbers
	public void printOddNum(int num, String t) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t + " - " + num);
		semEven.release();

	}
}

// Thread Class generating Even numbers
class EvenNumProducer implements Runnable {
	SharedPrinter sp;
	int index;

	EvenNumProducer(SharedPrinter sp, int index) {
		this.sp = sp;
		this.index = index;
	}

	@Override
	public void run() {
		for (int i = 2; i <= index; i = i + 2) {
			sp.printEvenNum(i, "Even");
		}
	}
}

// Thread Class generating Odd numbers
class OddNumProducer implements Runnable {
	SharedPrinter sp;
	int index;

	OddNumProducer(SharedPrinter sp, int index) {
		this.sp = sp;
		this.index = index;
	}

	@Override
	public void run() {
		for (int i = 1; i <= index; i = i + 2) {
			sp.printOddNum(i, "Odd");
		}
	}
}

public class EvenOddUsingSemaphore {

	public static void main(String[] args) {
		SharedPrinter sp = new SharedPrinter();
		// Starting two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new EvenNumProducer(sp, 10));
		executor.execute(new OddNumProducer(sp, 10));
		executor.shutdown();

	}

}
