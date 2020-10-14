package com.codeprep.icecream.parlor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the icecreamParlor function below.
	static int[] icecreamParlor(int m, int[] arr) {

		int [] result = new int [2];
		Map<Integer, Integer> valueIndexMap = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			int x = arr[i];
			int y = m - x;
			
			Integer j = valueIndexMap.get(y);
			if(j != null) {
				result[0] = j + 1;
				result[1] = i + 1;
				break;
			}
			valueIndexMap.put(x, i);
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int m = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] arr = new int[n];

			String[] arrItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int arrItem = Integer.parseInt(arrItems[i]);
				arr[i] = arrItem;
			}

			int[] result = icecreamParlor(m, arr);

			for (int i = 0; i < result.length; i++) {
				System.out.println(String.valueOf(result[i]));
			}
		}
		scanner.close();
	}
}
