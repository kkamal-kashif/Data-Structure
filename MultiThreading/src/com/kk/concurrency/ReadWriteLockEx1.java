package com.kk.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyRunnable1 implements Runnable{
	ReadWriteLock readWriteLock;
	public MyRunnable1(ReadWriteLock readWriteLock) {
		this.readWriteLock = readWriteLock;
	}

	@Override
	public void run() {
	//More than one threads can acquire readLock at a time provided no other thread is acquiring writeLock at same time.
		readWriteLock.readLock().lock();
		System.out.println(Thread.currentThread().getName() +" has acquired read lock.");
		try {
            Thread.sleep(5000);
     } catch (InterruptedException e) {
            e.printStackTrace();
     }
		System.out.println(Thread.currentThread().getName() +" has released read lock.");
		readWriteLock.readLock().unlock();
		
	}
	
}
public class ReadWriteLockEx1 {

	public static void main(String[] args) {
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		MyRunnable1 myRunnable=new MyRunnable1(readWriteLock);
        new Thread(myRunnable,"Thread-1").start();
        new Thread(myRunnable,"Thread-2").start();

	}

}
