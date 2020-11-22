package com.codeprep.happyladybugs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the happyLadybugs function below.
	static String happyLadybugs(String b) {

		char[] board = b.toCharArray();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < board.length; i++) {
			Integer val = map.get(String.valueOf(board[i]));
			if (val == null) {
				map.put(String.valueOf(board[i]), 1);
			} else {
				map.put(String.valueOf(board[i]), val + 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (entry.getValue() == 1 && !entry.getKey().equals("_")) {
				return "NO";
			}
		}
		Integer value = map.get("_");
		if (value == null) {
			return "NO";
		} else {
			int pair = 0;
			for (int j = 0; j < board.length - 1; j++) {
				if (board[j] == board[j + 1]) {
					pair = pair + 1;
				} else if (pair > 0) {
					pair = 0;
				} else {
					return "NO";
				}
			}
		}
		return "YES";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int g = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int gItr = 0; gItr < g; gItr++) {
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String b = scanner.nextLine();

			String result = happyLadybugs(b);

			System.out.println(result);
		}
		scanner.close();
	}
}