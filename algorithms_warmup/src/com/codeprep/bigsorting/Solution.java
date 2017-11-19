package com.codeprep.bigsorting;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		BigInteger temp = new BigInteger("0");
    	BigInteger indexOfSmallest = new BigInteger("0");
        Scanner in = new Scanner(System.in);
        int sizeOfArray = Integer.parseInt(in.next());
        BigInteger arr[] = new BigInteger[sizeOfArray];
        for(int arr_i=0; arr_i < sizeOfArray; arr_i++){
            arr[arr_i] = new BigInteger(in.next());
        }
        
        for(int i=0; i < sizeOfArray; i++){
        	BigInteger small = arr[i];
        	indexOfSmallest = BigInteger.valueOf(new Long(i));
        	for (int j = i + 1; j < sizeOfArray; j++){
        		if(small.compareTo(arr[j]) > 0){
        			indexOfSmallest = BigInteger.valueOf(new Long(j));
        			small = arr[j];
        		}
        	}
        	if(i != indexOfSmallest.intValue()){
        		temp = arr[i];
            	arr[i] = small;
            	arr[indexOfSmallest.intValue()] = temp;
        	}
        }
        for (BigInteger i : arr) {
        	System.out.println(i);
		}
	    
	    
	}
    
}
