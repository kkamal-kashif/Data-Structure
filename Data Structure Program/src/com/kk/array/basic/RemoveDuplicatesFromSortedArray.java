package com.kk.array.basic;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int arr1[] = { 1, 1, 2 };
		System.out.println(removeDuplicates(arr1));
		System.out.println(Arrays.toString(arr1));
		int arr2[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(removeDuplicates(arr2));
		System.out.println(Arrays.toString(arr2));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
