package com.codeprep.xor;

import java.util.Scanner;

public class Solution {

	public static String stringsXOR(String s, String t) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i))
				res.append("0");
			else
				res.append("1");
		}
		return res.toString();
	}

	public static void main(String[] args) {

		String s, t;
		Scanner in = new Scanner(System.in);
		s = in.nextLine();
		t = in.nextLine();
		System.out.println(stringsXOR(s, t));

	}
}