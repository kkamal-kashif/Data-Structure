package com.kk.string;

public class PanagramTest {

	public static void main(String[] args) {
		System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
	}

	public static boolean checkIfPangram(String s) {
		if (s.length() < 26 || s == null)
			return false;
		int[] arr = new int[26];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 97]++;
		}

		for (int i = 0; i < 26; i++) {
			if (arr[i] == 0)
				return false;
		}
		return true;
	}
}
