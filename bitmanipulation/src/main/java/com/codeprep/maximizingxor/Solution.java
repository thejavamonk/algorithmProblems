package com.codeprep.maximizingxor;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the maximizingXor function below.
	static int maximizingXor(int l, int r) {

		int max = 0;

		for (int i = l; i <= r; i++) {
			for (int j = l; j <= r; j++) {

				int value = i ^ j;
				if (value > max) {
					max = value;
				}
			}
		}
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int l = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int r = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = maximizingXor(l, r);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}
