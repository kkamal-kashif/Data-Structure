package com.kk.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ThreadPool is a class which creates a thread pool that reuses a fixed number
 * of threads to execute tasks. At any point, at most nThreads threads will be
 * active processing tasks. If additional tasks are submitted when all threads
 * are active, they will wait in the queue until a thread is available.
 *
 * Once shutdown of ThreadPool is initiated, previously submitted tasks are
 * executed, but no new tasks will be accepted.
 */

class ThreadPool {

	private BlockingQueue<Runnable> taskQueue;

	// Once pool shutDown will be initiated, poolShutDownInitiated will become true.
	private boolean poolShutDownInitiated = false;

	public ThreadPool(int nThreads) {
		taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);

		// Create and start nThreads number of threads.
		for (int i = 1; i <= nThreads; i++) {
			ThreadPoolsThread threadPoolsThread = new ThreadPoolsThread(taskQueue, this);
			threadPoolsThread.setName("Thread-" + i);
			System.out.println("Thread-" + i + " created in ThreadPool.");
			threadPoolsThread.start(); // start thread
		}

	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.poolShutDownInitiated)
			throw new Exception("ThreadPool has been shutDown, no further tasks can be added");
		//Add task in sharedQueue, and notify all waiting threads that task is available.
		System.out.println("task has been added.");
		this.taskQueue.put(task);
	}

	public boolean isPoolShutDownInitiated() {
		return poolShutDownInitiated;
	}

	//Initiates shutdown of ThreadPool, previously submitted tasks are executed, but no new tasks will be accepted.
	public synchronized void shutdown() {
		this.poolShutDownInitiated = true;
		System.out.println("ThreadPool SHUTDOWN initiated.");
	}

}

class ThreadPoolsThread extends Thread {

	private BlockingQueue<Runnable> taskQueue;
	private ThreadPool threadPool;

	public ThreadPoolsThread(BlockingQueue<Runnable> queue, ThreadPool threadPool) {
		taskQueue = queue;
		this.threadPool = threadPool;

	}

	public void run() {
		try {
			 //ThreadPool's threads will keep on running until ThreadPool is not shutDown 
			//(shutDown will interrupt thread) and taskQueue contains some unExecuted tasks.
			while (true) {
				System.out.println(Thread.currentThread().getName() + " is READY to execute task.");
				
				//ThreadPool's thread will take() task from sharedQueue only if
				 //tasks are available else waits for tasks to become available.
				Runnable runnable = taskQueue.take();
				System.out.println(Thread.currentThread().getName() + " has taken task.");
				
				// Now, execute task with current thread.
				runnable.run();

				System.out.println(Thread.currentThread().getName() + " has EXECUTED task.");

				/*
				 * 1) Check whether pool shutDown has been initiated or not, if pool shutDown
				 * has been initiated and 2) taskQueue does not contain any unExecuted
				 * task (i.e. taskQueue's size is 0 ) than interrupt() the thread.
				 */
				if (this.threadPool.isPoolShutDownInitiated() && this.taskQueue.size() == 0) {
					this.interrupt();
					/*
					 * Interrupting basically sends a message to the thread indicating it has been
					 * interrupted but it doesn't cause a thread to stop immediately,
					 * if sleep is called, thread immediately throws InterruptedException
					 */
					Thread.sleep(500);
				}

			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " has been STOPPED.");
		}
	}
}

class Task implements Runnable {
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

public class CustomThreadPool {

	public static void main(String[] args) throws Exception {
		ThreadPool threadPool = new ThreadPool(2); // create 2 threads in
													// ThreadPool
		Runnable task = new Task();
		threadPool.execute(task);
		threadPool.execute(task);

		threadPool.shutdown();

	}

}
