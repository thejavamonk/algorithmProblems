package com.codeprep.hourglass;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int count = Integer.MIN_VALUE;
		for (int m = 0; m < arr.length; m++) {
			for (int n = 0; n < arr.length; n++) {
				
				if(m >= arr.length - 2 || n >= arr.length - 2) {
					
				}else {
					int firstTemp = arr[m][n] + arr[m][n + 1] + arr[m][n + 2];
					int secondTemp = arr[m + 1][n + 1];
					int thirdTemp = arr[m + 2][n] + arr[m + 2][n + 1] + arr[m + 2][n + 2];
					int sum = firstTemp + secondTemp + thirdTemp;
					if(sum > count) {
						count = sum;
					}
				}
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int result = hourglassSum(arr);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}
