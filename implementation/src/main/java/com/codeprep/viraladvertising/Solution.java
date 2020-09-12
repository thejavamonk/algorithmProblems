package com.codeprep.viraladvertising;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the viralAdvertising function below.
	static int viralAdvertising(int n) {

		double totalshare = 0;
		double shares = 5;
		for (int i = 0; i < n; i++) {
			double likes = Math.floor(shares / 2);
			shares = likes * 3;
			totalshare = totalshare + likes;
		}
		return (int) totalshare;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int result = viralAdvertising(n);

		System.out.println(result);
		scanner.close();
	}
}
