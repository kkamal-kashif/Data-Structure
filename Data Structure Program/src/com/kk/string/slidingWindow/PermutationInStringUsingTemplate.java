package com.kk.string.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInStringUsingTemplate {
	public static void main(String[] args) {
		System.out.println(checkInclusion("abce", "cbaebabacd"));
	}

	private static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		Map<Character, Integer> map = new HashMap<>();
		// create a hashmap to save the Characters of the target substring.
		// (K, V) = (Character, Frequence of the Characters)
		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		// maintain a counter to check whether match the target string.
		int counter = map.size(); // must be the map size, NOT the string size because the char may be duplicate.

		// Two Pointers: begin - left pointer of the window; end - right pointer of the
		// window
		int begin = 0, end = 0;
		int l1 = s1.length();
		int l2 = s2.length();

		while (end < l2) {
			char c = s2.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			end++;
			while (counter <= 0) {
				char tempc = s2.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				if (end - begin == l1) {
					return true;
				}
				begin++;
			}

		}
		return false;
	}

}
