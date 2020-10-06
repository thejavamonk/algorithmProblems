package com.codeprep.manasaandstones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	// Complete the stones function below.
	static int[] stones(int n, int a, int b) {

		Set<Integer> stones = new TreeSet<>();
		stones.add(0);
		for (int i = 0; i < n - 1; i++) {

			stones = getCombinations(stones, a, b);
		}

		int[] arr = new int[stones.size()];

		int k = 0;
		for (Integer i : stones)
			arr[k++] = i;

		return arr;
	}

	private static Set<Integer> getCombinations(Set<Integer> combinations, int a, int b) {

		Set<Integer> combs = new TreeSet<>();
		for (Integer comb : combinations) {

			combs.add(comb + a);
			combs.add(comb + b);
		}
		return combs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int T = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int TItr = 0; TItr < T; TItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int a = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int b = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] result = stones(n, a, b);

			for (int i = 0; i < result.length; i++) {
				bufferedWriter.write(String.valueOf(result[i]));

				if (i != result.length - 1) {
					bufferedWriter.write(" ");
				}
			}

			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}