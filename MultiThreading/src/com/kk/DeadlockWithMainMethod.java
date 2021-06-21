package com.kk;

public class DeadlockWithMainMethod {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread t = Thread.currentThread();
		System.out.println("main started");
		t.join();
		// the following statement will never execute
		//The statement “Thread.currentThread().join()”, will tell Main thread to wait for this thread
		//(i.e. wait for itself) to die. 
		//Thus Main thread wait for itself to die, which is nothing but a deadlock.
		System.out.println("main ended");

	}

}
