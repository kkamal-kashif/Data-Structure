package com.kk.basic;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStonesProg {

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aAb", "aAAbbbb"));
	}

	public static int numJewelsInStones(String jewels, String stones) {
		int[] store = new int[256];
		for (char c : stones.toCharArray()) {
			store[c]++;
		}

		int jwelCount = 0;
		for (char ch : jewels.toCharArray()) {
			int a = store[ch];
			jwelCount = jwelCount + a;
		}
		return jwelCount;
	}

}
