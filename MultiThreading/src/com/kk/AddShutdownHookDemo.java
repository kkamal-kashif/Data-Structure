package com.kk;

/*added shutdown hook executed when JVM started its shutdown. 
And JVM started its shutdown when main thread (non-daemon) finished.*/
public class AddShutdownHookDemo {

	public static void main(String[] args) {
		System.out.println("main thread started");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					System.out.println("executing shutdown hook");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("shutdown hook executed successfully");
			}
		});
		 System.out.println("main thread ended");
	}

}
