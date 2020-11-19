package com.codeprep.sumvsxor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	// Complete the sumXor function below.
	static long sumXor(long n) {

		long result = 64 - Long.numberOfLeadingZeros(n) - Long.bitCount(n);
		return (long) Math.pow(2, result);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bufferedReader.readLine().trim());

		long result = sumXor(n);

		System.out.println(String.valueOf(result));
		bufferedReader.close();
	}
}