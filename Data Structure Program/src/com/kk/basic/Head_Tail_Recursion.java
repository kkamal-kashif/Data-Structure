package com.kk.basic;

//https://www.youtube.com/watch?v=lG6HxO7cDRw&list=PLSIpQf0NbcCk4be21WNhPHrHMSxFndZtB
public class Head_Tail_Recursion {

	public static void main(String[] args) throws InterruptedException {
		// headRec(5);
		headRec1(5, "");
		System.out.println();
		// tailRec(5);
		tailRec1(5, "");
	}

	public static void headRec(int n) {
		if (n == 0)
			return;
		else
			headRec(n - 1);
		System.out.print(n + " ");
	}

	public static void tailRec(int n) {
		if (n == 0)
			return;
		else
			System.out.print(n + " ");
		headRec(n - 1);

	}

	public static void headRec1(int n, String recDepth) throws InterruptedException {
		System.out.println(recDepth + "headRec(" + n + ")");
		Thread.sleep(1500);
		if (n == 0) {
			System.out.println(recDepth + "return");
			Thread.sleep(1500);
			return;
		} else {
			headRec1(n - 1, recDepth + " ");
			System.out.println(recDepth + n);
			Thread.sleep(1500);
		}
	}

	public static void tailRec1(int n, String recDepth) throws InterruptedException {
		System.out.println(recDepth + "tailRec(" + n + ")");
		Thread.sleep(1500);
		if (n == 0) {
			System.out.println(recDepth + "return");
			Thread.sleep(1500);
			return;
		} else {
			System.out.println(recDepth + n);
			Thread.sleep(1500);
			tailRec1(n - 1, recDepth + " ");
		}

	}
}
