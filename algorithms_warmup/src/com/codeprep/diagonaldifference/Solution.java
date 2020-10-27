package com.codeprep.diagonaldifference;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'diagonalDifference' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY arr as parameter.
	 */

	public static int diagonalDifference(List<List<Integer>> arr) {

		int sum1 = 0;
		int sum2 = 0;

		int stIndex = 0;
		int lstIndex = 1;
		for (List<Integer> row : arr) {

			sum1 = sum1 + row.get(stIndex);
			sum2 = sum2 + row.get(row.size() - lstIndex);
			stIndex++;
			lstIndex++;
		}
		return Math.abs(sum1 - sum2);
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result.diagonalDifference(arr);
		System.out.println(String.valueOf(result));
	}
}