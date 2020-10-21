package com.codeprep.servicelane;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the serviceLane function below.
	static int[] serviceLane(int n, int[][] cases, int[] width) {

		int[] res = new int[n];
		for (int row = 0; row < cases.length; row++) {

			int min = Integer.MAX_VALUE;
			for (int i = cases[row][0]; i <= cases[row][1]; i++) {
				int wide = width[i];
				if (wide < min) {
					min = wide;
				}
			}
			res[row] = min;
		}
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nt = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nt[0]);

		int t = Integer.parseInt(nt[1]);

		int[] width = new int[n];

		String[] widthItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int widthItem = Integer.parseInt(widthItems[i]);
			width[i] = widthItem;
		}

		int[][] cases = new int[t][2];

		for (int i = 0; i < t; i++) {
			String[] casesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int casesItem = Integer.parseInt(casesRowItems[j]);
				cases[i][j] = casesItem;
			}
		}

		int[] result = serviceLane(n, cases, width);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}
		scanner.close();
	}
}