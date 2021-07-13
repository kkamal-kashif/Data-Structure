package com.kk.basic;

//https://leetcode.com/problems/sorting-the-sentence/
public class SentenceSorting {

	public static void main(String[] args) {
		String s = "sentence4 a3 is2 This1";
		System.out.println(sortSentence(s));
	}

	public static String sortSentence(String s) {
		// Split the sentence into separate words
		String[] words = s.split(" ");

		// String Array to Store Words in a Stored Order
		String[] result = new String[words.length];
		for (String word : words) {
			// Each word will have the "index number" at the end
			int index = Integer.parseInt(String.valueOf(word.charAt(word.length() - 1)));
			// Add the word to the result array
			result[index - 1] = word.substring(0, word.length() - 1);
		}

		// Create a new sorted sentence
		StringBuilder sb = new StringBuilder();
		for (String str : result) {
			sb.append(str).append(" ");
		}

		return sb.toString().trim();
	}
}
