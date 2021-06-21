package com.kk.string;

import java.util.Arrays;

//https://leetcode.com/problems/rearrange-spaces-between-words/
//find the starting position of the no-empty string, then call split(" ") method
public class RearrangeSpacesBetweenWords {

	public static void main(String[] args) {
		String s = "  this   is  a sentence ";
		System.out.println(rearrange(s));
	}

	private static String rearrange(String s) {
		StringBuilder sb = new StringBuilder();
		// Step 1: Pre-processing :
		// a. find the starting position of the first non-empty string
		// b. words array
		if (s.length() == 1)
			return s;

		char[] ch = s.toCharArray();

		int pos = 0; // To find the starting position of the first non-empty string.
		while (ch[pos] == ' ') { // Finding the starting position of the first non-empty string.
			pos++;
		}
		System.out.println("debug - pos " + pos);

		String[] words = s.substring(pos, ch.length).split("\\s+");
		System.out.println("debug words - " + Arrays.toString(words));
		int space = 0;

		// Step 2: Counting Spaces
		for (char c : ch) {
			if (c == ' ')
				space++;
		}

		// Step 3: Grouping Spaces
		int wlen = words.length;
		int grpSpace = 0;
		if (wlen - 1 == 0) {
			grpSpace = space;
		} else {
			grpSpace = space / (wlen - 1);
		}
		System.out.println("debug - group spaces" + grpSpace);

		// Step 4: Inserting Words and Spaces
		for (String str : words) {
			sb.append(str);
			if (space >= grpSpace) {
				for (int i = 0; i < grpSpace; i++) {
					sb.append(' ');
				}
			} else {
				for (int i = 0; i < space; i++) {
					sb.append(' ');
				}
			}
			// calculating space remained
			space = space - grpSpace;
		}
		return sb.toString();
	}

}
