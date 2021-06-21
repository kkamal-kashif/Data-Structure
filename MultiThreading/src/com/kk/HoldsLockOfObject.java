package com.kk;

class MyRunnable22 implements Runnable {
	 
	public void run() {
		synchronized (this) {
			System.out.println("inside sync block, thread hold lock "
                    + "on object monitor - "+Thread.holdsLock(this));
		}
		 System.out.println("outside sync block, thread hold lock "
                 + "on object monitor - "+Thread.holdsLock(this));
	}
}
public class HoldsLockOfObject {

	public static void main(String[] args) {
		MyRunnable22 runnable=new MyRunnable22();
        Thread thread1=new Thread(runnable,"Thread-1");
        thread1.start();

	}

}
