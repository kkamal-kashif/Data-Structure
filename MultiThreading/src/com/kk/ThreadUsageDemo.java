package com.kk;

class Helper implements Runnable {
	public void run() {
		try {
			System.out.println("thread2 going to sleep for 5000");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Thread2 interrupted");
		}
	}
}

public class ThreadUsageDemo implements Runnable {
	public void run() {
		// thread run() method
	}

	public static void main(String[] args) {
		ThreadUsageDemo obj = new ThreadUsageDemo();
		Helper obj2 = new Helper();

		Thread thread1 = new Thread(obj);
		Thread thread2 = new Thread(obj2);

		// moving thread to runnable states
		thread1.start();
		thread2.start();

		ClassLoader loader = thread1.getContextClassLoader(); //the context ClassLoader for this Thread, or null 
																//indicating the system class loader 
																//(or, failing that, the bootstrap class loader)
		Thread thread3 = new Thread(new Helper());
		
		// getting number of active threads
        System.out.println(Thread.activeCount()); //Returns an estimate of the number of active 
        											//threads in the current thread’s thread group and its subgroups
        thread1.checkAccess(); //Determines if the currently running thread has permission to modify this thread
             
        // getting list of active thread in current thread's group
        Thread[] tarray = new Thread[3];
         
        Thread.enumerate(tarray); //Copies into the specified array every active thread in the 
        							//current thread’s thread group and its subgroups
        System.out.println("List of active threads:");
        System.out.printf("[");
        for(Thread thread : tarray)
        {
            System.out.println(thread);
        }
        System.out.printf("]\n");
             
        System.out.println(Thread.getAllStackTraces()); //Returns a map of stack traces for all live threads
        
        ClassLoader classLoader = thread1.getContextClassLoader();
        System.out.println(classLoader.toString());
        System.out.println(thread1.getDefaultUncaughtExceptionHandler());
        
        ThreadGroup grp = thread1.getThreadGroup();
        System.out.println("ThreadGroup to which thread1 belongs " +grp.toString());
        System.out.println(thread1.getUncaughtExceptionHandler());
        System.out.println("Does thread1 holds Lock? " + thread1.holdsLock(obj2));
             
             
        Thread.dumpStack(); //Prints a stack trace of the current thread to the standard  error stream. 
        //This method is used only for debugging
         
	}

}
