package com.codeprep.valleycount;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        char [] steps = s.toCharArray();
        int currStep = 0;
        int noOfValleys = 0;
        for(char ch: steps){
            if(ch == 'U'){
                currStep++;
            }
            else if(ch == 'D'){
                currStep--;
            }
            if(currStep == 0 && ch == 'U'){
                noOfValleys++;
            }
        }
        return noOfValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        String s = scanner.nextLine();
        int result = countingValleys(n, s);
        System.out.println(result);
        scanner.close();
    }
}
