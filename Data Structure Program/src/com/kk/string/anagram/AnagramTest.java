package com.kk.string.anagram;

/*we create a separate int array for count. We increment the count of each character for first array and 
 * similarly decrement count of each character for second array.
If the Strings are anagrams, the array should only have zeroes in it.*/
public class AnagramTest {

	public static void main(String[] args) {
		System.out.println(isAnagram("abcd", "dcab"));
	}

//Time complexity :O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
//Space complexity : O(1). Although we do use extra space, the space complexity is O(1) because the table's
	// size stays constant no matter how large nn is.
	private static boolean isAnagram(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int counts[] = new int[256];

		for (int i = 0; i < ch1.length; i++) {
			counts[ch1[i] - 97]++;
			counts[ch2[i] - 97]--;
		}

		for (int i = 0; i < 26; i++) {
			if (counts[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
