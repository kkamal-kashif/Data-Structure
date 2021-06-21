package com.kk;

import java.util.ArrayList;

/* Producer is producing, Producer will allow consumer to
 * consume only when 5 products have been produced (i.e. when production is over).
 */
class Producer implements Runnable {

	ArrayList<Integer> list;
	boolean prodInprogress;

	Producer() {
		// initially Producer will be producing, so make this
		// productionInProcess true.
		prodInprogress = true;
		list = new ArrayList<Integer>();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			list.add(i);
			System.out.println("Producer is still Producing, Produced : "+i);

            try{
                  Thread.sleep(1000);
            }catch(InterruptedException e){e.printStackTrace();}
		}
		prodInprogress = false;
	}

}
class Consumer extends Thread{
    Producer prod;
    
    Consumer(Producer obj){
     prod=obj;
    }
    
    public void run(){
    	 /*
         * consumer checks whether prodInProgress is true or not, if it's true,
         * consumer will sleep and wake up after certain time and again check whether 
         * prodInProgress is true or false. process will repeat till prodInProgress is true.
         * Once productionInProcess is false we'll exit below while loop.
         */
    	while(this.prod.prodInprogress){
    		 System.out.println("Consumer waiting for production to get over.");
             try{
                 Thread.sleep(4000);
             }catch(InterruptedException e){e.printStackTrace();}
    	}
    	 System.out.println("Production is over, consumer can consume.");
    	 int productSize=this.prod.list.size();
    	 System.out.println(productSize);
    	 for(int i=0;i<productSize;i++){
             System.out.println("Consumed : "+ this.prod.list.remove(0) +" "); 
      
    		}		
    }
}
public class ProducerConsumerWithoutWaitNotify {

	public static void main(String[] args) {
		 Producer prod=new Producer();
         Consumer cons=new Consumer(prod);
         
         Thread prodThread=new Thread(prod,"prodThread");
         Thread consThread=new Thread(cons,"consThread");
         
         prodThread.start();     //start producer thread.
         consThread.start();     //start consumer thread.

	}

}
