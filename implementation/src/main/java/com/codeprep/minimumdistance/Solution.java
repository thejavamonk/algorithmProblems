package com.codeprep.minimumdistance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	// Complete the minimumDistances function below.
	static int minimumDistances(int[] a) {

		int min = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			Integer lastIndex = map.get(a[i]);
			if (lastIndex == null) {
				map.put(a[i], i);
			} else {
				Integer currentIndex = i;
				min = Math.min((currentIndex - lastIndex), min);
			}
		}
		return (min == Integer.MAX_VALUE) ? -1 : min;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int result = minimumDistances(a);

		System.out.println(result);
		scanner.close();
	}
}
