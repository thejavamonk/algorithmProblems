package com.codeprep.repeatingchar;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {

		long check = 0;
		int i = 0, j = 0, k = 0;
		long count = 0;

		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				count++;
		}

		long div = n / s.length();
		long reminder = n % s.length();

		count = div * count;

		for (i = 0; i < reminder; i++) {
			if (s.charAt(i) == 'a')
				count++;
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		System.out.println(String.valueOf(result));

		scanner.close();
	}
}
