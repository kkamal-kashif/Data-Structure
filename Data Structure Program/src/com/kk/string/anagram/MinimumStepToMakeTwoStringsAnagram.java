package com.kk.string.anagram;

import java.util.Arrays;

public class MinimumStepToMakeTwoStringsAnagram {

	public static void main(String[] args) {
		System.out.println(minStep("bab", "aba"));
		System.out.println("=======================");
		System.out.println(minStep("hea", "bcadeh"));
		System.out.println("=======================");
		System.out.println(minStep("cedk","ddcf"));
	}

	private static int minStep(String s, String t) {
		int res = 0;
		int count[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			if(count[t.charAt(i) - 'a']-- <= 0) { //means unequal chars
				System.out.println(Arrays.toString(count));
				res++;
			}
		}
		return res;
	}

}
