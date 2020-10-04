package com.codeprep.chocolatefeast;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {

    	int totalchocolates = Math.abs(n / c);
        int wrappers = totalchocolates;
        int wrappersLeftExchange = wrappers % m;
        int chocolatesAfterReturn = wrappers / m;
        totalchocolates = totalchocolates +  chocolatesAfterReturn;
        
        while(chocolatesAfterReturn > 0) {
        	
        	wrappers = chocolatesAfterReturn + wrappersLeftExchange;
        	wrappersLeftExchange = wrappers % m;
        	
        	if(wrappers % m == 0) {
        		totalchocolates = totalchocolates +  chocolatesAfterReturn;
        	}
        	else {
        		break;
        	}
        }
        
        return totalchocolates;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            System.out.println(String.valueOf(result));
        }
        scanner.close();
    }
}