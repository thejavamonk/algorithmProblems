package com.codeprep.ransome;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        HashMap<String, Integer> magazineCache = cacheWords(magazine);
        HashMap<String, Integer> noteCache = cacheWords(note);

        if(checkForWords(noteCache, magazineCache)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

static boolean checkForWords(Map<String, Integer> noteCache, Map<String, Integer> magazineCache){

        Iterator it = noteCache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int wordsInMag = 0;
            if(magazineCache.get(pair.getKey()) != null){
                wordsInMag = magazineCache.get(pair.getKey());
            }
            int wordsInNote = (Integer) pair.getValue();
            if(wordsInMag >= wordsInNote){

            }else{
                return false;
            }
        }
        return true;
    }

    static HashMap<String, Integer> cacheWords(String [] input){

        HashMap<String, Integer> cache = new HashMap();
        for(String val: input){
            Integer value = cache.get(val);
            if(value == null){
                cache.put(val, 1);
            }else{
               cache.put(val, value.intValue()+1);
            }
        }
        return cache;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
