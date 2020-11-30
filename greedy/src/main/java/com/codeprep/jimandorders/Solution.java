package com.codeprep.jimandorders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	// Complete the jimOrders function below.
	static int[] jimOrders(int[][] orders) {
		class Pair {
			int finish;
			int customer;

			Pair(int f, int c) {
				finish = f;
				customer = c;
			}
		}
		ArrayList<Pair> order = new ArrayList<Pair>();
		for (int i = 0; i < orders.length; i++) {
			order.add(new Pair(orders[i][0] + orders[i][1], i + 1));
		}
		Collections.sort(order, new Comparator<Pair>() {
			public int compare(Pair o1, Pair o2) {
				if (o1.finish < o2.finish) {
					return -1;
				} else if (o1.finish == o2.finish) {
					if (o1.customer < o2.customer) {
						return -1;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			}
		});
		int[] ret = new int[orders.length];
		for (int i = 0; i < order.size(); i++) {
			ret[i] = order.get(i).customer;
		}
		return ret;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] orders = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] ordersRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int ordersItem = Integer.parseInt(ordersRowItems[j]);
				orders[i][j] = ordersItem;
			}
		}

		int[] result = jimOrders(orders);

		for (int i = 0; i < result.length; i++) {
			System.out.println(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}
		scanner.close();
	}
}
