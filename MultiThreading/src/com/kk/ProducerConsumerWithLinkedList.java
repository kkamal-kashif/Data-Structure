package com.kk;

import java.util.LinkedList;
import java.util.List;

class Producer3 implements Runnable {

	private List<Integer> sharedQueue;
	private int maxSize = 2; // maximum number of products which sharedQueue can hold at a time.

	public Producer3(List<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	public void run() {
		for (int i = 1; i <= 5; i++) { // produce 5 products.
			try {
				produce(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void produce(int i) throws InterruptedException {
	    
	       synchronized (sharedQueue) {
	           //if sharedQuey is full wait until consumer consumes.
	           while (sharedQueue.size() == maxSize) {
	             System.out.println("Queue is full, producerThread is waiting for "
	                     + "consumerThread to consume, sharedQueue's size= "+maxSize);
	             sharedQueue.wait();
	         }
	        }
	       
	       /* 2 Synchronized blocks have been used means before
	        * producer produces by entering below synchronized block consumer can consume.  
	        */
	      
	       //as soon as producer produces (by adding in sharedQueue) it notifies consumerThread.
	        synchronized (sharedQueue) {  
	           System.out.println("Produced : " + i);
	           sharedQueue.add(i);
	         Thread.sleep((long)(Math.random() * 1000));
	         sharedQueue.notify();
	        }
	    }
}
class Consumer3 implements Runnable {
    private List<Integer> sharedQueue;
    public Consumer3(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
   
    public void run() {
        while (true) {
         try {
             consume();
             Thread.sleep(100);
         } catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }
 
    private void consume() throws InterruptedException {
       synchronized (sharedQueue) {
           //if sharedQuey is empty wait until producer produces.
           while (sharedQueue.size() == 0) {
                  System.out.println("Queue is empty, consumerThread is waiting for "
                               + "producerThread to produce, sharedQueue's size= 0");
             sharedQueue.wait();
         }
       }
       
       /* 2 Synchronized blocks have been used means before
        * consumer start consuming by entering below synchronized block producer can produce.  
        */
      
        //If sharedQueue not empty consumer will consume (by removing from sharedQueue) and notify the producerThread.
        synchronized (sharedQueue) {
           Thread.sleep((long)(Math.random() * 2000));
         System.out.println("CONSUMED : "+ sharedQueue.remove(0));
         sharedQueue.notify();
        }
    }
   
}
public class ProducerConsumerWithLinkedList {

	public static void main(String[] args) {
		List<Integer> sharedQueue = new LinkedList<Integer>(); //Creating shared object
	      
	       Producer3 producer=new Producer3(sharedQueue);
	       Consumer3 consumer=new Consumer3(sharedQueue);
	      
	        Thread producerThread = new Thread(producer, "ProducerThread");
	        Thread consumerThread = new Thread(consumer, "ConsumerThread");
	        producerThread.start();
	        consumerThread.start();

	}

}
