package com.kk.string.palindrome;

//https://www.youtube.com/watch?v=tEbOmwxmuls
//https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
	}

	public static int longestPalindrome(String s) {
		int lowercase[] = new int[26];
		int uppercase[] = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c - 97 >= 0) {
				lowercase[c - 97]++;
			} else {
				uppercase[c - 97]++;
			}
		}

		int ans = 0;
		boolean isFirstOdd = false;
		for (int i = 0; i < 26; i++) {
			if (lowercase[i] % 2 == 0) {
				ans += lowercase[i];
			} else {
				if (!isFirstOdd) {
					ans += lowercase[i];
					isFirstOdd = true;
				} else {
					ans += lowercase[i] - 1;
				}
			}
		}

		for (int i = 0; i < 26; i++) {
			if (uppercase[i] % 2 == 0) {
				ans += uppercase[i];
			} else {
				if (!isFirstOdd) {
					ans += uppercase[i];
					isFirstOdd = true;
				} else {
					ans += uppercase[i] - 1;
				}
			}
		}
		return ans;
	}
}
