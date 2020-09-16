package com.codeprep.beautifultriplets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	// Complete the beautifulTriplets function below.
	static int beautifulTriplets(int d, int[] arr) {

		int count = 0;

		ArrayList<Integer> vals = new ArrayList<>();
		for (int j = 0; j < arr.length; j++) {
			vals.add(arr[j]);
		}

		for (int i = 0; i < arr.length; i++) {

			int p = arr[i];
			int q = p + d;
			int r = p + (2 * d);
			if (vals.contains(q) && vals.contains(r)) {
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = beautifulTriplets(d, arr);

		System.out.println(result);
		scanner.close();
	}
}
