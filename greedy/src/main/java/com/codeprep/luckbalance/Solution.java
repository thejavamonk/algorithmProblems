package com.codeprep.luckbalance;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the luckBalance function below.
	static int luckBalance(int k, int[][] contests) {

		int luck_balance = 0;

		Arrays.sort(contests, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				return -1 * Integer.compare(o1[0], o2[0]);
			}
		});

		for (int i = 0; i < contests.length; i++) {

			int luck = contests[i][0];
			int importance = contests[i][1];

			if (importance == 1 && k > 0) {
				k--;
				luck_balance += luck;
			} else if (importance == 1 && k == 0) {
				luck_balance -= luck;
			}

			if (importance == 0) {
				luck_balance += luck;
			}
		}
		return luck_balance;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[][] contests = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] contestsRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int contestsItem = Integer.parseInt(contestsRowItems[j]);
				contests[i][j] = contestsItem;
			}
		}

		int result = luckBalance(k, contests);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}