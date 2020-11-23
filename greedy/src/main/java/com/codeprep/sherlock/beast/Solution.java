package com.codeprep.sherlock.beast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {

	// Complete the decentNumber function below.
	static void decentNumber(int n) {

		Map<Integer, Integer> map = getCombination(n);
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() > max) {
				max = entry.getKey();
			}
		}

		if (map.isEmpty()) {
			System.out.println("-1");
		} else {
			int five = max;
			int three = map.get(max);
			StringBuilder builder = new StringBuilder();
			builder = getValues(builder, "5", five);
			builder = getValues(builder, "3", three);
			System.out.println(builder.toString());
		}
	}

	private static StringBuilder getValues(StringBuilder builder, String val, int num) {

		for (int i = 0; i < num; i++) {
			builder.append(val);
		}
		return builder;
	}

	private static Map<Integer, Integer> getCombination(int n) {

		Map<Integer, Integer> map = new HashMap();
		int three = 0;
		int five = 0;

		while (true) {
			five = n - three;

			if (five < 0) {
				break;
			}

			if (five % 3 == 0) {
				map.put(five, three);
			}
			three = three + 5;
		}
		return map;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				decentNumber(n);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
