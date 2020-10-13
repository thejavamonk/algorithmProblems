package com.codeprep.quicksort1.partition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the quickSort function below.
	static int[] quickSort(int[] arr) {

		int pivot = arr[0];
		List<Integer> greater = new ArrayList<>();
		List<Integer> lesser = new ArrayList<>();
		List<Integer> equal = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > pivot) {
				greater.add(arr[i]);
			} else if (arr[i] < pivot) {
				lesser.add(arr[i]);
			} else if(arr[i] == pivot) {
				equal.add(arr[i]);
			}
		}

		int[] res = new int[arr.length];
		res = append(lesser, res, 0);
		res = append(equal, res, lesser.size());
		res = append(greater, res, lesser.size() + equal.size());
		return res;

	}

	private static int[] append(List<Integer> data, int[] res, Integer index) {

		for (Integer val : data) {
			res[index] = val;
			index = index + 1;
		}
		return res;
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

		int[] result = quickSort(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));
		}
		scanner.close();
	}
}