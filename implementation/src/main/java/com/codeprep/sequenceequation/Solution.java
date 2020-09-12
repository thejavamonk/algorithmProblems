package com.codeprep.sequenceequation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	// Complete the permutationEquation function below.
	static int[] permutationEquation(int[] p) {

		int[] sol = new int[p.length];
		HashMap<Integer, Integer> valIndexMap = new HashMap<>();
		for (int j = 0; j < p.length; j++) {
			valIndexMap.put(p[j], j + 1);
		}

		for (int i = 1; i <= p.length; i++) {

			int firstIndex = valIndexMap.get(i);
			int secondIndex = valIndexMap.get(firstIndex);

			if (i == 1) {
				sol[0] = secondIndex;
			} else {
				sol[i - 1] = secondIndex;
			}

		}
		return sol;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] p = new int[n];

		String[] pItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int pItem = Integer.parseInt(pItems[i]);
			p[i] = pItem;
		}

		int[] result = permutationEquation(p);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}
}
