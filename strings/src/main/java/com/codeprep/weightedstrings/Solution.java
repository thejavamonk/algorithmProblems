package com.codeprep.weightedstrings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the weightedUniformStrings function below.
	static String[] weightedUniformStrings(String s, int[] queries) {

		char[] letters = s.toCharArray();
		String[] result = new String[queries.length];
		Map<Integer, Integer> map = new HashMap();
		int weight = 0;

		for (int i = 0; i < letters.length; i++) {

			if (i == 0 || letters[i] != letters[i - 1]) {
				weight = letters[i] - 'a' + 1;
			} else {
				weight = weight + letters[i] - 'a' + 1;
			}
			map.put(weight, 1);
		}

		for (int j = 0; j < queries.length; j++) {

			Integer val = map.get(queries[j]);
			if (val != null) {
				result[j] = "Yes";
			} else {
				result[j] = "No";
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] queries = new int[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			int queriesItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			queries[i] = queriesItem;
		}

		String[] result = weightedUniformStrings(s, queries);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}
		scanner.close();
	}
}
