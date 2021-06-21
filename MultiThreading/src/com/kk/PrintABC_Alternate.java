package com.kk;

class ResourceLock {
	public int flag = 1;
}

class ThreadA extends Thread {

	ResourceLock lock;

	ThreadA(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					while (lock.flag != 1) {
						lock.wait();
					}
					System.out.print("A");
					Thread.sleep(500);
					lock.flag = 2;
					lock.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}

	}
}

class ThreadB extends Thread {

	ResourceLock lock;

	ThreadB(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					while (lock.flag != 2) {
						lock.wait();
					}
					System.out.print("B");
					Thread.sleep(500);
					lock.flag = 3;
					lock.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}

	}
}

class ThreadC extends Thread {

	ResourceLock lock;

	ThreadC(ResourceLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					while (lock.flag != 3) {
						lock.wait();
					}
					System.out.print("C");
					Thread.sleep(500);
					lock.flag = 1;
					lock.notifyAll();
				}
			}
		} catch (Exception e) {
			System.out.println("Exception 1 :" + e.getMessage());
		}

	}
}

public class PrintABC_Alternate {

	public static void main(String[] args) {
		ResourceLock lock = new ResourceLock();

		ThreadA a = new ThreadA(lock);
		ThreadB b = new ThreadB(lock);
		ThreadC c = new ThreadC(lock);

		a.start();
		b.start();
		c.start();
	}

}
