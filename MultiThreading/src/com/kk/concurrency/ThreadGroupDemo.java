package com.kk.concurrency;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		
		ThreadGroup tg1 = new ThreadGroup("first group");
		ThreadGroup tg2 = new ThreadGroup(tg1,"first group");
		
		Thread t1 = new Thread("Thread-1");
		Thread t2 = new Thread(tg2,"Thread-1");
		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getName());
	}

}
