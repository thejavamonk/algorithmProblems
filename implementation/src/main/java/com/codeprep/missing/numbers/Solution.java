package com.codeprep.missing.numbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	// Complete the missingNumbers function below.
	static int[] missingNumbers(int[] arr, int[] brr) {
		
		List<Integer> real = new ArrayList<>();
		for (int i = 0; i < brr.length; i++) {
			real.add(brr[i]);
		}
		for (int j = 0; j < arr.length; j++) {
			for (int k = 0; k < arr.length; k++) {
				if (arr[j] == real.get(k)) {
					real.remove(arr[j]);
					break;
				}
			}
		}
		List<Integer> finalreal = real.stream().distinct().collect(Collectors.toList());

		int[] myArray = new int[finalreal.size()];
		for (int h = 0; h < finalreal.size(); h++) {
			myArray[h] = finalreal.get(h);
		}
		Arrays.sort(myArray);
		return myArray;
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

		int m = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] brr = new int[m];

		String[] brrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int brrItem = Integer.parseInt(brrItems[i]);
			brr[i] = brrItem;
		}

		int[] result = missingNumbers(arr, brr);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}
		scanner.close();
	}
}
