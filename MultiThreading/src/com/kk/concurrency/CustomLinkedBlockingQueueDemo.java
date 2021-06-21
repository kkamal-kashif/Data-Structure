package com.kk.concurrency;

import java.util.LinkedList;
import java.util.List;

interface BlockingQueueCustom<E> {

	// Inserts the specified element into this queue only if space is available
	// else waits for space to become available.
	void put(E item) throws InterruptedException;

	// Retrieves and removes the head of this queue only if elements are
	// available else waits for element to become available.
	E take() throws InterruptedException;

	// Returns size of queue.
	int size();

}

class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {

	private List<E> sharedQueue;
	private int maxSize; // maximum number of elements queue can hold at a time.

	public LinkedBlockingQueueCustom(int maxSize) {
		this.maxSize = maxSize;
		sharedQueue = new LinkedList<E>();
	}

	@Override
	public synchronized void put(E item)  throws InterruptedException  {
        //check space is available or not.
		if (sharedQueue.size() == maxSize) this.wait();
      
		//space is available, insert element and notify all waiting threads.
         sharedQueue.add(item);
         this.notifyAll();
    }

	@Override
	public synchronized E take()  throws InterruptedException{
        //waits element is available or not.
        if (sharedQueue.size() == 0) this.wait();
 
         //element is available, remove element and notify all waiting threads.
        this.notifyAll();
        return sharedQueue.remove(0);
           
      }

	@Override
	 public synchronized int size() {
        return sharedQueue.size();
	}

}

public class CustomLinkedBlockingQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueueCustom<String> bqueue = new LinkedBlockingQueueCustom<String>(2);
		bqueue.put("kk");
		bqueue.put("kk1");
	}
}
