package com.kk;
class MyRunnable1 extends Thread{
    public void run(){
           synchronized (this) {
                  System.out.println(Thread.currentThread().getName()+" started");
                  try {
                        this.wait();
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName()+" has been notified");
           }
    }
    
}
class MyRunnable2 extends Thread{
     
    MyRunnable1 myRunnable1;
    MyRunnable2(MyRunnable1 MyRunnable1){
           this.myRunnable1=MyRunnable1;
    }
    
    public void run(){
           synchronized (this.myRunnable1) {
                  System.out.println(Thread.currentThread().getName()+ " started");
                  try {
                        this.myRunnable1.wait();
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName()+" has been notified");
           }
           
    }
}
 
class MyRunnable3 extends Thread{
     
    MyRunnable1 myRunnable1;
    MyRunnable3(MyRunnable1 MyRunnable1){
           this.myRunnable1=MyRunnable1;
    }
    
    public void run(){
           synchronized (this.myRunnable1) {
                  System.out.println(Thread.currentThread().getName()+ " started");
                  this.myRunnable1.notify(); 
                  // Wakes up a single thread that is waiting on this object's monitor.
                  //If many threads are waiting on this object,one of them is chosen to be 
                  //awakened.The choice is random and occurs at the 
                  //discretion of the implementation.
                  
                  //this.myRunnable1.notifyAll(); // Will wake up all threads 
                                                   //waiting on object's monitor.
                  System.out.println(Thread.currentThread().getName()+
                                  " has notified waiting threads");
           }
           
    }
}
public class InterThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		MyRunnable1 myRunnable1=new MyRunnable1();
        MyRunnable2 myRunnable2=new MyRunnable2(myRunnable1);
        MyRunnable3 myRunnable3=new MyRunnable3(myRunnable1);

        Thread t1=new Thread(myRunnable1,"Thread-1");
        Thread t2=new Thread(myRunnable2,"Thread-2");
        Thread t3=new Thread(myRunnable3,"Thread-3");
        
        t1.start();
        t2.start();
        Thread.sleep(100);  //Used to ensure that thread1 and thread2 starts before thread-3
                    //because thread-1 and 2 calls wait(), while thread-3 calls notify or notifyAll() 
        t3.start();

	}

}
