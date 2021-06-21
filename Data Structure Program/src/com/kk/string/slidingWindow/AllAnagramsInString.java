package com.kk.string.slidingWindow;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=aZwMXTtEGPo
//Anagram Substring Search
//Search for all permutations
//sliding window
public class AllAnagramsInString {

	public static void main(String[] args) {
		System.out.println(findAnagram("cbaebabacd", "abc"));
	}

	public static List<Integer> findAnagram(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (p.length() >= s.length())
			return res;
		int pl = p.length();
		int sl = s.length();
		int count[] = frequency(p);
		int currentCount[] = frequency(s.substring(0, pl));

		if (areSame(count, currentCount)) {
			res.add(0);
		}
		int i;
		for (i = pl; i < sl; i++) {
			currentCount[s.charAt(i) - 97]++;
			currentCount[s.charAt(i - pl) - 97]--;
			if (areSame(count, currentCount)) {
				res.add(i - pl + 1);
			}
		}
		return res;
	}

	private static boolean areSame(int[] x, int[] y) {
		for (int i = 0; i < 26; i++) {
			if (x[i] != y[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] frequency(String p) {
		int count[] = new int[26];
		for (int i = 0; i < p.length(); i++) {
			count[p.charAt(i) - 97]++;
		}
		return count;
	}
}
