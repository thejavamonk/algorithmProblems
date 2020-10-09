package com.codeprep.fairrations;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static String fairRations(int[] B) {

		int sum = 0;
		for (int B_i = 0; B_i < B.length; B_i++) {
			sum += B[B_i];
		}

		int count = 0;
		if (sum % 2 == 1) {
			return "NO";
		} else {
			for (int i = 0; i < B.length; i++) {
				if (B[i] % 2 != 0) {
					B[i] = B[i] + 1;
					B[i + 1] = B[i + 1] + 1;
					count += 2;
				}
			}
			return Integer.toString(count);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] B = new int[N];

		String[] BItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < N; i++) {
			int BItem = Integer.parseInt(BItems[i]);
			B[i] = BItem;
		}

		String result = fairRations(B);
		System.out.println(String.valueOf(result));

		scanner.close();
	}
}