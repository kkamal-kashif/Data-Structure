package com.kk.string.palindrome;

//https://leetcode.com/problems/palindromic-substrings/
//https://leetcode.com/problems/palindromic-substrings/discuss/105688/Very-Simple-Java-Solution-with-Detail-Explanation
public class PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("aabaa"));
	}

	public static int countSubstrings(String s) {
		if (s.length() == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += checkPalindrome(s, i, i); // To check the palindrome of odd length palindromic sub-string
			count += checkPalindrome(s, i, i + 1); // To check the palindrome of even length palindromic sub-string
		}
		return count;
	}

	private static int checkPalindrome(String s, int i, int j) {
		int count = 0;
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			count++; //// Increment the count if palindrome substring found
			i--; // To trace string in left direction
			j++; // To trace string in right direction
		}
		return count;
	}
}
