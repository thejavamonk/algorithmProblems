package com.codeprep.flatland.spacestations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BruteForceSolution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
    	
    	if(n == c.length) {
    		return 0;
    	}
    	
    	HashMap<Integer, Integer> spacePorts = new HashMap<>();
    	for(int i = 0; i < c.length; i++) {
    		spacePorts.put(c[i], 1);
    	}
    	
    	int max = 0;
    	
    	for(int j = 0; j < n; j++) {
    		
    		if(spacePorts.get(j) == null) {
    			Integer behind = getLastSpaceStation(j, spacePorts);
        		Integer forward = getForwardSpaceStation(j, n, spacePorts);
        		
        		int m = 0;
        		if(behind != null && forward != null) {
        			m = Math.min(Math.abs(j - behind), Math.abs(forward - j));
        			max = Math.max(m, max);
        			continue;
        			
        		}
        		
        		if(behind != null) {
        			m = behind;
        		}
        		else {
        			m = forward;
        		}
        		
        		max = Math.max(m, max);
    		}
    	}
    	return max;
    }
    
    private static Integer getLastSpaceStation(int index, HashMap<Integer, Integer> spacePorts){
    	
    	for(int i = index; i >= 0; i--) {
    		Integer port = spacePorts.get(i);
    		
    		if(port != null) {
    			return i;
    		}
    	}
    	return null;
    }
    
    private static Integer getForwardSpaceStation(int index, int lastIndex, HashMap<Integer, Integer> spacePorts){
    	
    	for(int i = index; i <= lastIndex; i++) {
    		Integer port = spacePorts.get(i);
    		
    		if(port != null) {
    			return i;
    		}
    	}
    	return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}