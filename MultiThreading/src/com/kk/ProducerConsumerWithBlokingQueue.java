package com.kk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Producer2 implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;
	public Producer2(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
	
	public void run() {
		for(int i=1; i<=5; i++){
			try {
	             System.out.println("Produced : " + i);
	             sharedQueue.put(i); //put produce into sharedQueue.         
	         } catch (InterruptedException ex) {
	             
	         }
		}
		
	}
	
}
class Consumer2 implements Runnable{
	 
    private BlockingQueue<Integer> sharedQueue;
    public Consumer2 (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

	@Override
	public void run() {
		while(true){
			try {
				System.out.println("CONSUMED : "+ sharedQueue.take());  
		} catch (InterruptedException ex) {
            
        }
		
	}
}
}
public class ProducerConsumerWithBlokingQueue {

	public static void main(String[] args) {
		//Creating shared object  
	     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
	    
	     Producer2 producer=new Producer2(sharedQueue);
	     Consumer2 consumer=new Consumer2(sharedQueue);
	    
	     Thread producerThread = new Thread(producer, "ProducerThread");
	     Thread consumerThread = new Thread(consumer, "ConsumerThread");
	     producerThread.start();
	     consumerThread.start();

	}

}
