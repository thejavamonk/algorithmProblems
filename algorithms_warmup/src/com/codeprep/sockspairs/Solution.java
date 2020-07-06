package com.codeprep.sockspairs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        HashMap<String, Integer> pairs = new HashMap<>();
        for(int a : ar){
           Integer value = pairs.get(String.valueOf(a));
           if(value != null){
               pairs.put(String.valueOf(a), value + 1);
           }else{
               pairs.put(String.valueOf(a), 1);
           }
        }

        int total = 0;
        Iterator<Entry<String, Integer>> mapItr = pairs.entrySet().iterator();
        while(mapItr.hasNext()){
            Entry<String, Integer> value = mapItr.next();
            Integer val = (Integer) value.getValue();
            if(val != null){
                int noOfPairs = val / 2;
                total = total + Math.abs(noOfPairs);
            }
        }
        return total;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);
        scanner.close();
    }
}

