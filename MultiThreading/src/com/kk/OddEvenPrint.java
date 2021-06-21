package com.kk;

class OddNumGenerator implements Runnable {
	private NumberPrinter printer;
    private int max;

	public OddNumGenerator(NumberPrinter printer, int max) {
		this.printer = printer;
		this.max = max;
	}

	@Override
	public void run() {
		 for (int i = 1; i <= max; i = i + 2) {
			 try{
				 printer.printOdd(i, "odd thread");
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
		
	}
	
}

class EvenNumGenerator implements Runnable {
	private NumberPrinter printer;
    private int max;

	public EvenNumGenerator(NumberPrinter printer, int max) {
		this.printer = printer;
		this.max = max;
	}

	@Override
	public void run() {
		 for (int i = 2; i <= max; i = i + 2) {
			 try{
				 printer.printEven(i, "even thread");
			 }catch(Exception e){
				 e.printStackTrace();
			 }
		 }
	}
	
}

class NumberPrinter {
	// To check if even number is printed or not.
    private boolean isEvenNumPrinted = true;

    public void printOdd(int number , String albhabet) throws InterruptedException {
    	synchronized (this) {  // Get a lock on NumberPrinter
    		// Wait until even is not printed.
    		if(!isEvenNumPrinted){
    			wait();
    		}
    		System.out.println(number + " -------- " + albhabet);
            isEvenNumPrinted = false;
         // Notify the other waiting thread which is waiting on NumberPrinter
         // Other thread will get out of waiting state
            this.notify();
		}
    }

    public void printEven(int number, String albhabet) throws InterruptedException {
    	synchronized (this) {  // Get a lock on NumberPrinter
    		if(isEvenNumPrinted){
    			wait();
    		}
            
            System.out.println(number + " -------- " + albhabet);
            isEvenNumPrinted = true;
            this.notify();
    	}
    }
}

public class OddEvenPrint {
	public static void main(String[] args) {
		 int maxNumber = 10;
	     NumberPrinter printer = new NumberPrinter();
	     Thread t1 = new Thread(new EvenNumGenerator(printer, maxNumber));
	     Thread t2 = new Thread(new OddNumGenerator(printer, maxNumber));
	     t1.start();
	     t2.start();
		 
	}
}
