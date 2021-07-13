package com.kk.array;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class IncerementArrayDigitByOne {

	public static void main(String[] args) {
		int arr[] = { 2, 7, 9 };
		System.out.println(Arrays.toString(plusOne(arr)));
	}

	// TC - O(n)
	public static int[] plusOne(int[] arr) {
		if (arr == null || arr.length == 0)
			return new int[] { 1 };
		int carry = 1;
		for (int i = arr.length- - 1; i >= 0; i--) {
			int sum = arr[i] + 1;
			carry = sum / 10;
			arr[i] = sum % 10;
			if (carry == 0) // no more carry, so terminate here
				return arr;
		}
		// if reaches here, it is cases like 999
		int[] a = new int[arr.length + 1];
		a[0] = 1;
		return a;
	}

}
