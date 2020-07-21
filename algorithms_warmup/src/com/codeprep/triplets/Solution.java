package com.codeprep.triplets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {

		HashMap<Long, Integer> rightMap = getRightMap(0, arr);
		HashMap<Long, Integer> leftMap = new HashMap<Long, Integer>();

		int noOfTriplets = 0;
		for (int i = 0; i < arr.size(); i++) {

			long midTerm = arr.get(i);
			long leftVal = midTerm / r;
			long rightVal = midTerm * r;
			Integer leftValOccourance = 0;
			Integer rightValOccourance = 0;

			if(leftMap.containsKey(leftVal) && midTerm % r == 0) {
				 leftValOccourance = leftMap.get(leftVal);
			}
			
			if(rightMap.containsKey(rightVal)) {
				rightValOccourance = rightMap.get(rightVal);
			}

			noOfTriplets += leftValOccourance * rightValOccourance;
			
			rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0) - 1);
			leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0) + 1);
		}
		return noOfTriplets;
	}

	public static HashMap<Long, Integer> getRightMap(int index, List<Long> arr) {

		HashMap<Long, Integer> map = new HashMap<>();
		for (Long val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		return map;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Long> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr.add(arrItem);
		}

		long ans = countTriplets(arr, r);

		System.out.println(String.valueOf(ans));
	}
}
