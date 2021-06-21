package com.kk.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyRunnable2 implements Runnable{
	ReadWriteLock readWriteLock;
	public MyRunnable2(ReadWriteLock readWriteLock) {
		this.readWriteLock = readWriteLock;
	}

	@Override
	public void run() {
		//Only one threads can acquire writeLock at a time. Means writeLock can only be obtained 
		//if no other thread is acquiring read or write lock at that time.
		readWriteLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() +" has acquired write lock.");
		try {
            Thread.sleep(5000);
     } catch (InterruptedException e) {
            e.printStackTrace();
     }
		System.out.println(Thread.currentThread().getName() +" has released write lock.");
		readWriteLock.writeLock().unlock();
		
	}
	
}
public class ReadWriteLockEx2 {

	public static void main(String[] args) {
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		MyRunnable2 myRunnable=new MyRunnable2(readWriteLock);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();

	}

}
