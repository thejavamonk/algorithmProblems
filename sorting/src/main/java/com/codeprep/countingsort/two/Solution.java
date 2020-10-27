package com.codeprep.countingsort.two;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the countingSort function below.
	static int[] countingSort(int[] arr) {

		int[] res = new int[100];
		for (int j = 0; j < arr.length; j++) {
			res[arr[j]] = res[arr[j]] + 1;
		}

		int[] fis = new int[arr.length];
		int index = 0;
		for (int j = 0; j < res.length; j++) {
			int val = res[j];
			if (val != 0) {
				for (int p = 0; p < val; p++) {
					fis[index] = j;
					index++;
				}
			}
		}
		return fis;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] result = countingSort(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}
		scanner.close();
	}
}