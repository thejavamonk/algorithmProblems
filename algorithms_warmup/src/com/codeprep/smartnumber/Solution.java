package com.codeprep.smartnumber;

import java.util.Scanner;

public class Solution {
	public static boolean isSmartNumber(int num) {
		int val = (int) Math.sqrt(num);
		if((double)num / val == val)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int testCases;
		Scanner in = new Scanner(System.in);
		testCases = in.nextInt();
		int num;
		for (int i = 0; i < testCases; i++) {
			num = in.nextInt();
			boolean ans = isSmartNumber(num);
			if (ans) {
				System.out.println("YES");
			} else
				System.out.println("NO");
		}
	}
}