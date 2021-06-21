package com.kk.string.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersUsingTemplate {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	// Time complexity : O(n). Index j will iterate n times.
	// Space complexity : O(min(m, n))
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		int ans = 0;
		int counter = 0;
		int beg = 0, end = 0;

		while (end < s.length()) {
			// count > 0 means repeating character
			char cRight = s.charAt(end);
			map.put(cRight, map.getOrDefault(cRight, 0) + 1);
			if (map.get(cRight) > 1) {
				counter++;
			}

			while (counter > 0) {
				char cLeft = s.charAt(beg);
				map.put(cLeft, map.get(cLeft) - 1);
				// map.get(cLeft) == 1 means the cLeft is the duplicated character,
				// and we have remove it, so after left++, it will be distinct.
				if (map.get(cLeft) == 1) {
					counter--;
				}
				beg++;
			}
			ans = Math.max(ans, end - beg + 1);
			end++;
		}

		return ans;
	}
}
