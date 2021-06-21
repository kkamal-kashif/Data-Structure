package com.kk.string;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
public class DecodeString {

	public static void main(String[] args) {
		String s =  "2[a]3[bc]"; //"3[a2[c]]";
		System.out.println(decodeString(s));
	}

	private static String decodeString(String str) {
		String res = "";
		Stack<Integer> sti = new Stack<>();
		Stack<String> sts = new Stack<>();
		int ptr = 0;

		while (ptr < str.length()) {
			if (Character.isDigit(str.charAt(ptr))) {
				int num = 0;
				while (Character.isDigit(str.charAt(ptr))) {
					num = num * 10 + (str.charAt(ptr) - '0');
					ptr++;
				}
				sti.push(num);
			} else if (str.charAt(ptr) == '[') {
				sts.push(res);
				res = "";
				ptr++;
			} else if (str.charAt(ptr) == ']') {
				System.out.println(sts.peek());
				StringBuilder sb = new StringBuilder(sts.pop());
				int count = sti.pop();
				for (int i = 0; i < count; i++) {
					sb.append(res);
				}
				
				res = sb.toString();
				ptr++;
			} else {
				res = res + str.charAt(ptr);
				ptr++;
			}
		}

		return res;
	}

}
