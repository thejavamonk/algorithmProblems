package com.codeprep.equalizearray;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the equalizeArray function below.
    @SuppressWarnings("unused")
	static int equalizeArray(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val: arr){
           Integer value = map.get(val);
           if(value == null){
               map.put(val, 1);
           }else{
               map.put(val, ++value);
           }
        }
        int maxKey = 0;
        int maxVal = 0;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(val > maxVal){
                maxVal = val;
                maxKey = key;
            }
        }

        return arr.length - maxVal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        System.out.println(result);
        scanner.close();
    }
}
