package com.codeprep.beautiful.binarystring;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the beautifulBinaryString function below.
	static int beautifulBinaryString(String b) {

		char[] vals = b.toCharArray();
		int count = 0;
		for (int i = 0; i < vals.length - 2; i++) {

			if (vals[i] == '0' && vals[i + 1] == '1' && vals[i + 2] == '0') {
				vals[i + 2] = '1';
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String b = scanner.nextLine();

		int result = beautifulBinaryString(b);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}
