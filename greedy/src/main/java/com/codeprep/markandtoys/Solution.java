package com.codeprep.markandtoys;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {

    	int maxToys = 0;
    	Arrays.sort(prices);
    	
    	for(int i = 0; i < prices.length; i++) {
    		k = k - prices[i];
    		if(k < 0) {
    			return maxToys;
    		}
    		maxToys++;
    	}
    	return maxToys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}