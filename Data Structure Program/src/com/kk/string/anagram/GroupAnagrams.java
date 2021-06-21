package com.kk.string.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Maintain a map ans : {String -> List} where each key  K is a sorted string, and each value is 
//the list of strings from the initial input that when sorted, are equal to  K
public class GroupAnagrams {

	public static void main(String[] args) {
		String[] sa = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(sa));
		System.out.println(groupAnagrams1(sa));
	}

	// Time Complexity:O(NK), where N is the length of strs, and K is the maximum
	// length of a string in str array.
	// Counting each string is linear in the size of the string, and we count every
	// string.

	// Space Complexity: O(NK), the total information content stored in ans.
	public static List<List<String>> groupAnagrams(String[] sa) {
		if (sa.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List> ans = new HashMap<>();
		int count[] = new int[26];
		for (String s : sa) {
			Arrays.fill(count, 0);
			char[] ch = s.toCharArray();
			for (char c : ch) {
				count[c - 97]++;
			}
			StringBuilder sb = new StringBuilder("");
			for (int a : count) {
				sb.append(a);
			}
			String key = sb.toString();
			if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList());
			}
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}

	// Time Complexity: O(NKlogK), where N is the length of strs array, and K is the
	// maximum length of a string in strs. The outer loop has complexity O(N) as we
	// iterate through each string.
	// Then, we sort each string in O(KlogK) time.

	// Space Complexity: O(NK)O(NK), the total information content stored in ans
	private static Collection<List> groupAnagrams1(String[] sa) {
		if (sa.length == 0)
			return new ArrayList();
		Map<String, List> ans = new HashMap<String, List>();
		for (String s : sa) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!ans.containsKey(key)) {
				ans.put(key, new ArrayList());
			}
			ans.get(key).add(s);
		}
		return new ArrayList(ans.values());
	}
}
