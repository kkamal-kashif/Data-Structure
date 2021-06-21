package com.kk.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool1 {

	private BlockingQueue<Runnable> taskQueue;
	private boolean poolShutDownInitiated = false;

	public ThreadPool1(int nThreads) {
		taskQueue = new LinkedBlockingQueue<>(nThreads);

		for (int i = 1; i <= nThreads; i++) {
			ThreadPoolsThread1 threadPoolsThread = new ThreadPoolsThread1(taskQueue, this);
			System.out.println("Thread-" + i + " created in ThreadPool.");
			threadPoolsThread.start();
		}
	}

	public void execute(Runnable task) throws Exception {
		if (this.poolShutDownInitiated)
			throw new Exception("ThreadPool shutDown, no further tasks can be added");
		this.taskQueue.put(task);
	}

	public synchronized void shutdown() {
		this.poolShutDownInitiated = true;
	}

	public boolean isPoolShutDownInitiated() {
		return poolShutDownInitiated;
	}

}

class ThreadPoolsThread1 extends Thread {
	private BlockingQueue<Runnable> taskQueue;
	private ThreadPool1 threadPool;

	public ThreadPoolsThread1(BlockingQueue<Runnable> queue, ThreadPool1 threadPool) {
		this.taskQueue = queue;
		this.threadPool = threadPool;
	}
	
	public void run() {
		try {
			while (true) {
				Runnable runnable = taskQueue.take();
				runnable.run();
				
				if (this.threadPool.isPoolShutDownInitiated() && this.taskQueue.size() == 0) {
					this.interrupt();
					Thread.sleep(500);
				}
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " has been STOPPED.");
		}
	}
}

public class CustomThreadPoolDemo {

	public static void main(String[] args) throws Exception {
		ThreadPool1 threadPool = new ThreadPool1(2);
		Tasks task = new Tasks();
		threadPool.execute(task);
		threadPool.execute(task);

		threadPool.shutdown();
	}

}

class Tasks implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " is executing task.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}