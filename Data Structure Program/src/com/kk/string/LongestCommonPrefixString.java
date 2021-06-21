package com.kk.string;

//https://leetcode.com/problems/longest-common-prefix/
//https://www.youtube.com/watch?v=GlfrtRKIHPM
public class LongestCommonPrefixString {

	public static void main(String[] args) {
		String sa[] = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(sa));
		String sa1[] = { "dog", "racecar", "car" };
		System.out.println(longestCommonPrefix(sa1));
	}
//Time complexity : O(S) , where S is the sum of all characters in all strings.
//In the worst case all n strings are the same. The algorithm compares the string S1 with the other strings [S_2...S_n]
//There are S character comparisons, where S is the sum of all characters in the input array.F
//Space complexity : O(1). We only used constant extra space.

	public static String longestCommonPrefix(String[] sa) {
		 if(sa == null || sa.length == 0) return "";
		String prefix = sa[0];
		for (String word : sa) {
			while (word.indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				// flowe
				// flow
				// flo
				// fl
				if (prefix.isEmpty())
					return "There is no common prefix among the input strings";
			}
		}
		return prefix;
	}

}
