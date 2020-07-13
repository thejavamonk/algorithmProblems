package com.codeprep.twostrings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        HashMap<String, String> s1Vals = cache(s1);
        HashMap<String, String> s2Vals = cache(s2);
        return validate(s1Vals, s2Vals);
    }

    static String validate(HashMap<String, String> s1vals, HashMap<String, String> s2Vals){

        Iterator it = s1vals.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(s2Vals.get(pair.getKey()) != null){
                return "YES";
            }
        }
        return "NO";
    }

    static HashMap<String, String> cache(String s){

        HashMap<String, String> cache = new HashMap<>();
        char [] chars = s.toCharArray();
        for(char val: chars){
            cache.put(String.valueOf(val), String.valueOf(val));
        }
        return cache;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }
        scanner.close();
    }
}
