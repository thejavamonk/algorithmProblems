package com.codeprep.newyearchaos;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] arr) {

		int swapCount = 0;
		for (int i = arr.length - 1; i >= 0; i--) {

			int curElement = arr[i];
			int actElement = i + 1;
			
			if(curElement != actElement) {

				if(((i - 1) >= 0) && arr[i - 1] == actElement) {
					swapCount++;
					swap(arr, i, i - 1);
				}
				else if( ((i - 2) >= 0) && arr[i - 2] == actElement){
					swapCount = swapCount + 2;
					swap(arr, i - 2, i - 1);
					swap(arr, i - 1, i);
				}
				else {
					System.out.println("Too chaotic");
					return;
				}
			}
		}
		System.out.println(swapCount);
	}

	private static void swap(int[] arr, int initalPos, int finalPos) {

		int temp = arr[initalPos];
		arr[initalPos] = arr[finalPos];
		arr[finalPos] = temp;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}