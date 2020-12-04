package com.codeprep.cutthesticks;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static Integer[] cutTheSticks(int[] arr) {
		
		Arrays.sort(arr);
		int n = arr.length;
		List<Integer> res = new LinkedList<>();
		res.add(n);
		for (int i = 1; i < arr.length; i++) {
			
			if (arr[i] != arr[i - 1]) {
                res.add(arr.length - i);
            }
		}
		Integer[] result = new Integer[res.size()];
		return res.toArray(result);
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

		Integer[] result = cutTheSticks(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}
		scanner.close();
	}
}