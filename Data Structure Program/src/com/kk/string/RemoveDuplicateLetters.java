package com.kk.string;

import java.util.Stack;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		String s = "bcacb"; // o/p-abc
		System.out.println(removeDuplicateLetters(s));
	}

	public static String removeDuplicateLetters(String s) {
		int f[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			f[s.charAt(i) - 97]++;
		}
		char[] c = s.toCharArray();
		
		// check if char is present or not
		boolean[] check = new boolean[26];
		Stack<Character> st = new Stack<>();
        int idx = -1;
        for(char ch: c) {
            idx = ch - 'a'; // index of char
            f[idx]--;   // reducing the freq of char
            if (check[idx])
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while (!st.isEmpty() && ch < st.peek() && f[st.peek() - 'a'] != 0)
                check[st.pop() - 'a'] = false;
            
            st.push(ch); //add current character and mark it as visited
            check[idx] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty())
            ans.append(st.pop());
        return ans.reverse().toString();
	}

}
