package com.kk.string.palindrome;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindromeTest {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int n = s.length();
		int l = 0;
		int r = n - 1;

		while (l <= r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			} else { // Check if same char (ignoring cases)
				if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
					return false;
				}
				l++;
				r--;
			}
		}
		return true;
	}
}
