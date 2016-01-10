package com.codeprep.plusminus;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int arr[] = new int[total];
        for(int arr_i=0; arr_i < total; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        double positive = 0;
        double negative = 0;
        double zeroes = 0;
        for(int i = 0; i < arr.length; i++){
            
            if(arr[i] > 0){
                positive++;
            }else if(arr[i] < 0){
                negative++;
            }else{
                zeroes++;
            }
        }
        System.out.println(positive/total);
        System.out.println(negative/total);
        System.out.println(zeroes/total);
    }

}
