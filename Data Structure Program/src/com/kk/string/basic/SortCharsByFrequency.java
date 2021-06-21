package com.kk.string.basic;

//https://github.com/prakashshuklahub/Interview-Questions/blob/master/451%20Sort%20Characters%20By%20Frequency
//https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortCharsByFrequency {

	public static void main(String[] args) {
		String str = "tree"; // op=eert
		System.out.println(sort(str));
	}

	private static String sort(String str) {
		StringBuilder sb = new StringBuilder();
		int n = str.length();

		int[] count = new int[256];
		// 1. get count[]
		for (int i = 0; i < n; i++) {
			count[str.charAt(i)]++;
		}

		// 2. create PQ based on count and store it in PQ //PQ - [e, t, r]
		Comparator<Character> comp = (a, b) -> count[b] - count[a];
		PriorityQueue<Character> pqueue = new PriorityQueue<>(comp);
		for (int i = 0; i < count.length; i++) {
			pqueue.add((char) i);
		}

		// 3. empty PQ //PQ - [e, t, r]
		while (!pqueue.isEmpty()) {
			char c = pqueue.poll(); // e
			int freq = count[c]; // 2
			for (int i = 0; i < freq; i++) {
				sb.append(c);
			}

		}
		return sb.toString();
	}

}
