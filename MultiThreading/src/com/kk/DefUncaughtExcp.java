package com.kk;
//It avoids abrupt termination of thread caused by uncaught runtime exceptions.
class MyRunn implements Runnable {

	String str;
	// method will terminate due to an uncaught unchecked(runtime) exception.
	public void run() {
		/*
		 * String wasn't initialized, so performing any operation on it will
		 * throw NullPointerException and it will caught by default handler
		 * defined in main method.
		 */
		str.equals("abc");
	}
}
public class DefUncaughtExcp {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunn(), "thread-1");
		// use setDefaultUncaughtExceptionHandler method which can handle
		// uncaught unchecked(runtime) exception generated in run() method.
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName() + " has thrown " + e);
			}
		});
		t1.start();
	}
}
