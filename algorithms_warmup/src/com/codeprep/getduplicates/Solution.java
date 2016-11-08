package com.codeprep.getduplicates;

import java.util.HashMap;

public class Solution {
	
	public static void main(String[] args) {
		
		int [] arrayOfInts = {1, 2, 1, 3};
		HashMap<Integer, Integer> noDuplicates = new HashMap<>();
		for (int i : arrayOfInts) {
			Integer value = noDuplicates.get(new Integer(i));
			if(value == null){
				noDuplicates.put(new Integer(i), 1);
			}else{
				noDuplicates.put(new Integer(i), value + 1);
			}
		}
		System.out.println("Array without duplicates:");
		for(Integer key : noDuplicates.keySet()){
			System.out.println(key.intValue());
		}
	}

}
