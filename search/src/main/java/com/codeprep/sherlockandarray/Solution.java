package com.codeprep.sherlockandarray;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

	// Complete the balancedSums function below.
	static String balancedSums(List<Integer> arr) {

		int x = 0;
		int sum = 0;

		for (int a : arr) {
			sum += a;
		}

		for (int y : arr) {
			if (2 * x == sum - y) {
				return "YES";
			}
			x = x + y;
		}
		return "NO";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, T).forEach(TItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList());

				String result = balancedSums(arr);

				System.out.println(result);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}