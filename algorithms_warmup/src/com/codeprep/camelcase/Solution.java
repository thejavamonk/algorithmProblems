package com.codeprep.camelcase;

import java.util.Scanner;

public class Solution {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int capsCount = 0;
		Scanner in = new Scanner(System.in);
		String s = in.next();
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			if (Character.isUpperCase(c)) {
				capsCount++;
			}
		}
		if (capsCount > 0) {
			System.out.println(capsCount + 1);
		}else{
			System.out.println(1);
		}
	}

}
