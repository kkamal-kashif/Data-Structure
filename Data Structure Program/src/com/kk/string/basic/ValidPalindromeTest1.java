package com.kk.string.basic;

//https://leetcode.com/problems/valid-palindrome-ii/
//https://github.com/prakashshuklahub/Interview-Questions/blob/master/680%20Valid%20Palindrome%20II
//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//Input: "aba"
//Output: True
//Input: "abca"
//Output: True  - Explanation: You could delete the character 'c'.
public class ValidPalindromeTest1 {

	public static void main(String[] args) {
		String s = "abca";
		System.out.println(test(s));
	}

	private static boolean test(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
			}
			start++;
			end--;
		}
		return true;
	}

	private static boolean isPalindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
