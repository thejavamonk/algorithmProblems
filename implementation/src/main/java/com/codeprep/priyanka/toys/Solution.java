package com.codeprep.priyanka.toys;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the toys function below.
    static int toys(int[] w) {
    	
    	quickSort(w, 0, w.length - 1);    

    	int i=0, count=0, base;
        while(i!=w.length)
        {
            count++;
            base = w[i];
            while(i!=w.length && w[i]<=base+4) {
            	i++;
            }
            if (i==w.length)    break;
        }
        return count;
    }
    
    public static void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);
	 
	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
    
    private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);
	 
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	 
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    return i+1;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] w = new int[n];

        String[] wItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int wItem = Integer.parseInt(wItems[i]);
            w[i] = wItem;
        }

        int result = toys(w);

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}
