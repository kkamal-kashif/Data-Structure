package com.kk.array;

//https://gist.github.com/kanahaiya/bdd3e87b06b7006ac7dc6d0149a8659a
//https://www.youtube.com/watch?v=__guhvzO540
//{ 1, 9, -1, -2, 7, 3, -1, 2 }; // max sum [9, -1, -2, 7] = 13, k=4 ,window size
public class MaxSumSubArrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = { 1, 9, -1, -2, 7, 3, -1, 2 };
		int k = 4;
		System.out.println(getMaxSumSubArrayOfSizeKM1(arr, k));
		System.out.println(getMaxSumSubArrayOfSizeKM2(arr, k));
	}

	// brute force solution
	// time complexity - O(n*k)
	public static int getMaxSumSubArrayOfSizeKM1(int[] arr, int k) {
		int maxSum = 0;
		int n = arr.length;
		// total loop = 0, n-k
		for (int i = 0; i < n - k; i++) {
			int winSum = 0;
			for (int j = i; j < i + k; j++) {
				winSum = winSum + arr[j];
			}
			maxSum = Math.max(winSum, maxSum);
		}
		return maxSum;
	}

	// optimized solution using sliding window technique
	// time complexity - O(n)
	public static int getMaxSumSubArrayOfSizeKM2(int[] arr, int k) {
		int maxSum = 0;
		int winSum = 0;
		for (int i = 0; i < k; i++) {
			winSum = winSum + arr[i];
		}
		for (int end = k; end < arr.length; end++) {
			winSum = winSum + arr[end] - arr[end - k];
			maxSum = Math.max(maxSum, winSum);
		}

		return maxSum;
	}
}
