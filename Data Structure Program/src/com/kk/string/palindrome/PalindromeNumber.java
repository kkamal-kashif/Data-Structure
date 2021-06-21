package com.kk.string.palindrome;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(100));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		// reverse process
		int reversed = 0;
		int original = x;
		while (x != 0) {
			int rem = x % 10;
			reversed = reversed * 10 + rem;
			x = x / 10;
		}
		System.out.println(reversed);
		return reversed == original;
	}
}
