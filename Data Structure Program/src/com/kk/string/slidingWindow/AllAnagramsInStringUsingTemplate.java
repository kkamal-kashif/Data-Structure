package com.kk.string.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://github.com/cherryljr/LeetCode/blob/master/Find%20All%20Anagrams%20in%20a%20String.java
//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
public class AllAnagramsInStringUsingTemplate {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}

	/**
	 * Approach 3：Using Sliding Window Template Detail explanations about the
	 * template is here:
	 * https://github.com/cherryljr/LeetCode/blob/master/Sliding%20Window%20Template.java
	 */
	public static List<Integer> findAnagrams(String s, String t) {
		List<Integer> result = new LinkedList<>();
		if (t.length() > s.length())
			return result;
		Map<Character, Integer> map = new HashMap<>();
		// create a hashmap to save the Characters of the target substring.
		// (K, V) = (Character, Frequence of the Characters)
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		// maintain a counter to check whether match the target string.
		int counter = map.size(); // must be the map size, NOT the string size because the char may be duplicate.

		 //Two Pointers: begin - left pointer of the window; end - right pointer of the window
		int begin = 0, end = 0;
		// int head = 0;
		// int len = Integer.MAX_VALUE;
		int tl = t.length();
		int sl = s.length();

		//loop at the begining of the source string
		while (end < sl) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					counter--;
			}
			end++;
			//counter == 0 , means 
			while (counter == 0) {
				char tempc = s.charAt(begin);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				if (end - begin == tl) {
					result.add(begin);
				}
				begin++;
			}

		}
		return result;
	}
}
