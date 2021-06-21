package com.kk.string.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("abc", "cbaebabacd"));
		System.out.println(checkInclusion1("abc", "cbaebabacd"));
		System.out.println(checkInclusion2("abc", "cbaebabacd"));
	}

	// Using sorting [Time Limit Exceeded]
	// TC: O(l1log(l1) + (l2-l1) : l1, l2 - length of string s1, s2
	// SC: O(l1) as array s used in sort()
	public static boolean checkInclusion(String s1, String s2) {
		s1 = sort(s1);
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			System.out.println(s2.substring(i, i + s1.length()));
			if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
				return true;
			}

		}
		return false;
	}

	// Using Hashmap [Time Limit Exceeded]
	// TC: O(l1 + 26 * l1 * (l2 - l1)) : l1, l2 - length of string s1, s2, hashmap
	// contains atmost 26 key
	// SC: O(1) hashmap contains atmost 26 key-value pairs.
	public static boolean checkInclusion1(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int l1 = s1.length();
		int l2 = s2.length();
		Map<Character, Integer> map1 = new HashMap<>();
		for (char c : s1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i <= l2 - l1; i++) {
			Map<Character, Integer> map2 = new HashMap<>();
			for (int j = 0; j < l1; j++) {
				map2.put(s2.charAt(i + j), map2.getOrDefault(s2.charAt(i + j), 0) + 1);
			}
			if (matches(map1, map2)) {
				return true;
			}
		}
		return false;
	}

	// Using Array [Accepted]
	// TC and SC -same as above
	// need to take an array of size 26.The rest of the process remains the same as
	// the last approach.
	public static boolean checkInclusion2(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int[] sa1 = new int[26];
		int l1 = s1.length();
		int l2 = s2.length();

		for (int i = 0; i < l1; i++) {
			sa1[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i <= l2 - l1; i++) {
			int[] sa2 = new int[26];
			for (int j = 0; j < l1; j++) {
				sa2[s2.charAt(i + j) - 'a']++;
			}
			if (Arrays.equals(sa1, sa2)) {
				return true;
			}
		}

		return false;
	}

	// Sliding Window [Accepted]
	// TC: O(l1 + 26 * l1 * (l2 - l1)) : l1, l2 - length of string s1, s2
	// SC: O(1) Constant space is used.
	public static boolean checkInclusion3(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;

		if (s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
			return s2.equals(s1);
		}

		int[] s1map = new int[26];
		int[] s2map = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			s1map[s1.charAt(i) - 'a']++;
			s2map[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length() - s1.length(); i++) {
			if (Arrays.equals(s1map, s2map)) {
				return true;
			}
			s2map[s2.charAt(i + s1.length()) - 'a']++;
			s2map[s2.charAt(i) - 'a']--;
		}

		return Arrays.equals(s1map, s2map);
	}

	private static boolean matches(Map<Character, Integer> s1map, Map<Character, Integer> s2map) {
		for (char key : s1map.keySet()) {
			if (s1map.get(key) != s2map.getOrDefault(key, -1)) {
				return false;
			}
		}
		return true;
	}

	private static String sort(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
