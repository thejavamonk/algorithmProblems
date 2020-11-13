package com.codeprep.max.perimeter;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// Complete the maximumPerimeterTriangle function below.
	static void maximumPerimeterTriangle(int[] sticks) {

		int data[] = new int[3];
		List<int[]> vals = new ArrayList<>();
		HashMap<BigInteger, int[]> map = new HashMap<>();
		getCombination(sticks, data, 0, sticks.length - 1, 0, 3, vals);
		BigInteger max = BigInteger.valueOf(0);
		for (int[] ints : vals) {
			Arrays.sort(ints);
			if (ints[0] + ints[1] > ints[2]) {
				BigInteger sum = BigInteger.valueOf(ints[0]).add(BigInteger.valueOf(ints[1])).add(BigInteger.valueOf(ints[2]));
				if (sum.compareTo(max) > 0) {
					max = sum;
					map.put(max, ints);
				}
			}
		}
		if(max.intValue() != 0) {
			int [] res = map.get(max);
			System.out.println(res[0] + " " + res[1] + " " + res[2]);
		}
		else {
			System.out.println(-1);
		}
	}

	static void getCombination(int arr[], int data[], int start, int end, int index, int r, List<int[]> vals) {
		if (index == r) {
			int [] res = new int[r]; 
			System.arraycopy(data, 0, res, 0, data.length);
			vals.add(res);
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			getCombination(arr, data, i + 1, end, index + 1, r, vals);
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] sticks = new int[n];

		String[] sticksItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int sticksItem = Integer.parseInt(sticksItems[i]);
			sticks[i] = sticksItem;
		}

		maximumPerimeterTriangle(sticks);
		scanner.close();
	}
}
