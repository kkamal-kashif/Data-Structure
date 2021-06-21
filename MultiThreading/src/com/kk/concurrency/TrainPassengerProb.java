package com.kk.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyRunnable implements Runnable {
	Lock lock;
	int ticketsAvailable = 1;

	MyRunnable() {
		lock = new ReentrantLock();
	}

	@Override
	public void run() {
		System.out.println("Waiting to book ticket for : " + Thread.currentThread().getName());
		lock.lock();
		if (ticketsAvailable > 0) {
			System.out.println("Booking ticket for : " + Thread.currentThread().getName());

			// Let's say system takes some time in booking ticket (here we have
			// taken 1 second time)
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			ticketsAvailable--;
			System.out.println("Ticket BOOKED for : "+ Thread.currentThread().getName());
			System.out.println("currently ticketsAvailable = "+ticketsAvailable);
		} else{
			System.out.println("Ticket NOT BOOKED for : "+ Thread.currentThread().getName());
		}
		lock.unlock();
	}

}

public class TrainPassengerProb {

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr, "Thread-1");
		Thread t2 = new Thread(mr, "Thread-2");
		t1.start();
		t2.start();
	}

}
