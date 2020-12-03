package com.codeprep.flatland.spacestations;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BruteForceSolution {

	// Complete the flatlandSpaceStations function below.
	static int flatlandSpaceStations(int n, int[] c) {

		Arrays.sort(c);
		int maxDistance = c[0];
		for (int i = 1; i < c.length; i++) {
			int distance = (c[i] - c[i - 1]) / 2;
			if (maxDistance < distance)
				maxDistance = distance;
		}
		int lastGap = (n - 1) - c[c.length - 1];
		return (lastGap < maxDistance) ? maxDistance : lastGap;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[] c = new int[m];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = flatlandSpaceStations(n, c);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}