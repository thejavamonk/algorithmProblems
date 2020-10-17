package com.codeprep.marcs.cakewalk;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the marcsCakewalk function below.
	static long marcsCakewalk(int[] calorie) {

		double minDist = 0;
		int temp = 0;
		int power = 0;

		for (int i = 0; i < calorie.length; i++) {
			for (int j = i + 1; j < calorie.length; j++) {
				if (calorie[i] < calorie[j]) {
					temp = calorie[i];
					calorie[i] = calorie[j];
					calorie[j] = temp;
				}
			}
		}

		for (int i = 0; i < calorie.length; i++) {
			minDist = minDist + (calorie[i] * Math.pow(2, power));
			power++;
		}
		return (long) minDist;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] calorie = new int[n];

		String[] calorieItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int calorieItem = Integer.parseInt(calorieItems[i]);
			calorie[i] = calorieItem;
		}

		long result = marcsCakewalk(calorie);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}