package com.codeprep.finddigits;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the findDigits function below.
    static int findDigits(int n) {

        String value = String.valueOf(n);
        char [] nums = value.toCharArray();
        int count = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] != '0'){
            	int m = Integer.valueOf(String.valueOf(nums[i]));
                int sol = n % m;
                if(sol == 0){
                    count++;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        scanner.close();
    }
}