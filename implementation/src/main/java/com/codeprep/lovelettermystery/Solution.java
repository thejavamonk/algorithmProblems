package com.codeprep.lovelettermystery;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the theLoveLetterMystery function below.
	static int theLoveLetterMystery(String s) {

		int i = 0;
		int j = s.length() - 1;
		int steps = 0;
		char[] a = s.toCharArray();

		while (i < j) {
			steps = steps + Math.abs(a[i] - a[j]);
			i++;
			j--;
		}
		return steps;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = theLoveLetterMystery(s);

			System.out.println(String.valueOf(result));
		}
		scanner.close();
	}
}