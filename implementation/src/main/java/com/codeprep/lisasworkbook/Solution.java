package com.codeprep.lisasworkbook;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int workbook(int n, int k, int[] arr) {

		int page = 1;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			int probCount = 0;
			for (int j = 1; j <= arr[i]; j++) {
				probCount++;
				if (j == page) {
					count++;
				}

				if (probCount % k == 0) {
					page += 1;
					probCount = 0;
				}
			}
			if (probCount > 0) {
				page += 1;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = workbook(n, k, arr);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}