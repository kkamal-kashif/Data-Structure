package com.kk;
class MyThread extends Thread{
	public void run(){
		for(int i=0;i<3;i++){
			System.out.println("in run "+Thread.currentThread().getName()+"---"+i);
		}
		
	}
	
	public void start(){
		System.out.println("-------");
		super.start();
		System.out.println("start");
	}
}
public class ByThreadClass {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		System.out.println(mt.getName());
		/*for(int i=0;i<3;i++){
			System.out.println("in run "+Thread.currentThread().getName()+"---"+i);
		}*/
	}

}
