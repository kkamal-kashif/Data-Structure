package com.kk.string;

//https://www.geeksforgeeks.org/print-characters-frequencies-order-occurrence/
//Input : str = "geeksforgeeks"
//Output : g2 e4 k2 s2 f1 o1 r1
//Input : str = "elephant"
//Output : e2 l1 p1 h1 a1 n1 t1
public class PrintCharactersAndFrequenciesInOrderOfOccurrence {

	public static void main(String[] args) {
		String str = "elephant";// "geeksforgeeks";
		System.out.println(print(str));
	}

	// Time Complexity: O(n), where n is the number of characters in the string.
	// Auxiliary Space: O(1), as there are only lowercase letters.
	private static String print(String str) {
		StringBuilder sb = new StringBuilder();

		int[] count = new int[256];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int freq = count[c];
			if (freq != 0) {
				sb.append(c + "" + freq).append(" ");
				count[c] = 0; // do it so that the same character is not printed again.
			}
		}
		return sb.toString();
	}

}
