package com.codeprep.freqQueries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {

		HashMap<Integer, Integer> freqMap = new HashMap<>();
		HashMap<Integer, Set<Integer>> valFreqMap = new HashMap<>();
		
		List<Integer> out = new ArrayList<>();

		for (List<Integer> operations : queries) {

			Integer opType = operations.get(0);
			Integer opVal = operations.get(1);

			switch (opType) {
			case 1:
				Integer freq1 = freqMap.getOrDefault(opVal, 0) + 1;
				freqMap.put(opVal, freq1);
				valFreqMap.put(freq1, valFreqMap.getOrDefault(freq1, new HashSet<Integer>()));
				valFreqMap.get(freq1).add(opVal);
				break;
			case 2:
				Integer freq2 = freqMap.getOrDefault(opVal, 1) - 1;
				freqMap.put(opVal, freq2);
				if(valFreqMap.containsKey(freq2)){
					valFreqMap.get(freq2).remove(opVal);
					valFreqMap.putIfAbsent(freq2 - 1, new HashSet());
					valFreqMap.get(freq2 - 1).add(opVal);
				}
				break;
			case 3:
				if (valFreqMap.containsKey(opVal)) {
					out.add(1);
				} else {
					out.add(0);
				}
				break;
			}
		}
		return out;
	}

	private static boolean checkFrequency(HashMap<Integer, Integer> freqMap, Integer opVal) {
		Iterator<Entry<Integer, Integer>> mapItr = freqMap.entrySet().iterator();
		while (mapItr.hasNext()) {
			Entry<Integer, Integer> value = mapItr.next();
			if (value.getValue().equals(opVal)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		System.out.println(ans);
		bufferedReader.close();
	}
}
