package com.codeprep.jumpingclouds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {

		int step = 0;
		int noOfSteps = 0;
		int end = c.length - 1;
		int pos = 0;

		return jump(c, step, end, pos);
	}

	static int jump(int[] c, int step, int end, int pos) {

		if (pos >= end) {
			return step;
		}
		if (checkStep(c, 2, step, pos)) {
			step = step + 1;
			pos = pos + 2;
		} else if (checkStep(c, 1, step, pos)) {
			step++;
			pos++;
		}
		return jump(c, step, end, pos);
	}

	static boolean checkStep(int[] c, int stepType, int step, int pos) {
		if (stepType == 1 && pos + 1 < c.length && c[pos + 1] == 0) {
			return true;
		} else if (stepType == 2 && pos + 2 < c.length && c[pos + 2] == 0) {
			return true;
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);
		System.out.println(result);

		scanner.close();
	}
}
