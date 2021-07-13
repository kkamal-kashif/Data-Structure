package com.kk.basic;

//https://leetcode.com/problems/shuffle-string/
public class ShuffleString {

	public static void main(String[] args) {
		String s = "codeleet";
		int indices[] = { 4, 5, 6, 7, 0, 2, 1, 3 };
		System.out.println(shuffle(s, indices)); //leetcode
	}

	public static String shuffle(String s, int[] indices) {
		if (s.length() != indices.length)
			return s;
		int n = s.length();
		char[] temp = new char[n];
		for (int i = 0; i < n; i++) {
			int val = indices[i];
			char c = s.charAt(i);
			temp[val] = c;
		}

		return new String(temp);
	}
}
