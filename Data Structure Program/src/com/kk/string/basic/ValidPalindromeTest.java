package com.kk.string.basic;

//https://leetcode.com/problems/valid-palindrome/ 
public class ValidPalindromeTest {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama"; // "race a car"
		System.out.println(test(str));
	}

	private static boolean test(String str) {
		StringBuilder sb = new StringBuilder();
		// make it like below and check palindrome
		// "A man, a plan, a canal: Panama" => AmanaplanacanalPanama
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}
		return checkPal(sb.toString());
	}

	private static boolean checkPal(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		for (int i = 0; i < n / 2; i++) {
			if (ch[i] != ch[n - 1 - i]) {
				return false;
			}
		}
		return true;
	}

}
