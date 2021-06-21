package com.kk.string.basic;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("()[]{}{"));
	}

	// Time complexity : O(n) because we simply traverse the given string one
	// character at a time and push and pop operations on a stack take O(1) time.
	// Space complexity : O(n) as we push all opening brackets onto the stack
	// and in the worst case, we will end up pushing all the brackets onto the
	// stack. e.g. ((((((((((.
	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				st.push(c);
			} else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
				st.pop();
			} else if (c == '}' && !st.isEmpty() && st.peek() == '{') {
				st.pop();
			} else if (c == ']' && !st.isEmpty() && st.peek() == '[') {
				st.pop();
			} else {
				return false;
			}
		}
		return st.isEmpty();
	}

}
