package com.kk.string.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://github.com/cherryljr/LeetCode/blob/master/Find%20All%20Anagrams%20in%20a%20String.java
public class AllAnagramsInString1 {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams1("cbaebabacd", "abc"));
	}

	/**
	 * Approach 1: Using Array (Similar to HashMap) Instead of making use of a
	 * special HashMap data structure just to store the frequency of occurence of
	 * characters, we can use a simpler array data structure to store the
	 * frequencies. Then we just need to compare the two map is the same or not.
	 */
	private static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0 || s.length() < p.length())
			return res;
		int pl = p.length();
		int sl = s.length();
		int[] pmap = new int[26];

		for (int i = 0; i < pl; i++) {
			pmap[p.charAt(i) - 'a']++;
		}

		for (int i = 0; i < sl - pl; i++) {
			int[] smap = new int[26];
			for (int j = 0; j < pl; j++) {
				smap[s.charAt(i + j) - 'a']++;
			}
			if (Arrays.equals(pmap, smap)) {
				res.add(i);
			}
		}

		return res;
	}

	/**
	 * Approach 2: Sliding Window A easy method, you will get it with the comments
	 */
	private static List<Integer> findAnagrams1(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0 || s.length() < p.length())
			return res;

		int pl = p.length();
		int sl = s.length();

		int[] pmap = new int[26];
		// Initialize the map / window
		for (int i = 0; i < pl; i++) {
			pmap[p.charAt(i) - 'a']++;
		}

		int[] smap = new int[26];
		for (int i = 0; i < pl; i++) {
			smap[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < sl - pl; i++) {
			if (Arrays.equals(pmap, smap)) {
				res.add(i);
			}
			// if don't match, we move the sliding window
			// remove the preceding character and add a new succeeding character to the new
			// window
			smap[s.charAt(i + pl) - 'a']++;
			smap[s.charAt(i) - 'a']--;
		}
		if (Arrays.equals(pmap, smap)) {
			res.add(sl - pl);
		}
		return res;
	}

}
