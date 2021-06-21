package com.kk;
class MyRunnable33 implements Runnable{

	@Override
	public void run() {
		 method1();
		 method2();
	}
	public synchronized  static void method1(){
		 for(int i=0;i<2;i++){
			 System.out.println(Thread.currentThread().getName()+" is executing static method 1");
            
		 }
	}
	public static synchronized void method2(){
		 for(int i=0;i<2;i++){
		 System.out.println(Thread.currentThread().getName()+" is executing method 2");
	}
	}
}
public class MethodLevelSynch {

	public static void main(String[] args) {
		MyRunnable33 mr = new MyRunnable33();
		Thread t1 = new Thread(mr,"Thread-1");
		Thread t2 = new Thread(mr,"Thread-2");
		t1.start();
		t2.start();
	}

}
