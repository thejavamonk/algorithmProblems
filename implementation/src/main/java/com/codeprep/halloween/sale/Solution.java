package com.codeprep.halloween.sale;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the howManyGames function below.
	static int howManyGames(int p, int d, int m, int s) {
		// Return the number of games you can buy

		int count = 0;
		int cost = p;
		int sumOfCost = 0;

		while (sumOfCost + cost <= s) {
			
			if(count >= 3900) {
				System.out.println("here");
			}

			if (sumOfCost == 0) {
				sumOfCost = p;
				count++;
				continue;
			}

			if (cost > m && (cost - d > m)) {
				cost = cost - d;
				sumOfCost = sumOfCost + cost;
				count++;
			} else {
				cost = m;
				sumOfCost = sumOfCost + m;
				count++;
			}
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] pdms = scanner.nextLine().split(" ");

		int p = Integer.parseInt(pdms[0]);

		int d = Integer.parseInt(pdms[1]);

		int m = Integer.parseInt(pdms[2]);

		int s = Integer.parseInt(pdms[3]);

		int answer = howManyGames(p, d, m, s);

		System.out.println(String.valueOf(answer));
		scanner.close();
	}
}