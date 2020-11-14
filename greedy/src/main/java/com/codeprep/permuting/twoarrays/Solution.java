package com.codeprep.permuting.twoarrays;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the twoArrays function below.
	static String twoArrays(int k, int[] arr, int[] brr) {

		int temp = 0;

		for (int i = 0; i < brr.length; i++) {
			for (int j = i + 1; j < brr.length; j++) {
				if (brr[i] < brr[j]) {
					temp = brr[i];
					brr[i] = brr[j];
					brr[j] = temp;
				}
			}
		}

		temp = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		

		for(int j = 0; j < arr.length; j++) {
			
			if(arr[j] + brr[j] < k) {
				return "NO";
			}
		}
		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			int[] A = new int[n];

			String[] AItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int AItem = Integer.parseInt(AItems[i]);
				A[i] = AItem;
			}

			int[] B = new int[n];

			String[] BItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int BItem = Integer.parseInt(BItems[i]);
				B[i] = BItem;
			}

			String result = twoArrays(k, A, B);

			System.out.println(result);
		}
		scanner.close();
	}
}
