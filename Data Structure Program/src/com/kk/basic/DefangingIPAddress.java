package com.kk.basic;

//https://leetcode.com/problems/defanging-an-ip-address/
public class DefangingIPAddress {

	public static void main(String[] args) {
		String s = "1.1.1.1";
		int f = 1;
		String[] sa = s.split("\\.");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sa.length; i++) {
			sb.append(sa[i]);
			if (f < sa.length) {
				sb.append("[.]");
			}
			f++;
		}
		System.out.println(sb.toString());
		// another way
		System.out.println(s.replaceAll("\\.", "[.]"));
		// another way
		StringBuilder output = new StringBuilder();
		for (char c : s.toCharArray()) {
			switch (c) {
			case '.':
				output.append("[.]");
				break;
			default:
				output.append(c);
				break;
			}
		}
		System.out.println(output.toString());
	}

}
