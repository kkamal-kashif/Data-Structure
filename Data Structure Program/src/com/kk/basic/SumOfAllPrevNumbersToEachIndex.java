package com.kk.basic;

import java.util.Arrays;

//function to sum of all the previous numbers to each index of array
//i/p - {1, 2, 3, 4, 5, 6, 7}
//o/p - {1, 3, 6, 10, 15, 21, 28}
public class SumOfAllPrevNumbersToEachIndex {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int a[] = sumAtIndex(arr, 0, 0);
		System.out.println(Arrays.toString(a));
	}

	public static int[] sumAtIndex(int[] array, int sum, int length) {
		if (length > array.length - 1) {
			return array;
		} else {
			sum = sum + array[length];
			array[length] = sum;
			sumAtIndex(array, sum, length + 1);
		}
		return array;
	}
}
