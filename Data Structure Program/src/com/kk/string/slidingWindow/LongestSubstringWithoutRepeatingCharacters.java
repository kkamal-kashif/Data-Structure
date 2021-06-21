package com.kk.string.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://github.com/cherryljr/LeetCode/blob/master/Longest%20Substring%20Without%20Repeating%20Characters.java
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring1("abcabcbb"));
	}

	// Time complexity : O(n^3)
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) { 
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j - i); // j-i - length of substring
				}
			}
		}
		return ans;
	}

	// Sliding Window
	// Time complexity : O(n). Index j will iterate n times.
	// Space complexity : O(min(m, n))
	public static int lengthOfLongestSubstring1(String s) {
		int n = s.length(), ans = 0;
		// current index of character
		Map<Character, Integer> map = new HashMap<>();
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character c = s.charAt(i);
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

}
