package com.company.Everyday;

import java.util.HashMap;
import java.util.Map;

public class WordFilter1 {

    Map<String, Integer> map;

    public WordFilter1(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            int len = word.length();
            for (int j = 1; j < len; j++){
                for(int k = 1; k < len; k++){
                    map.put(word.substring(0, j) + "_" + word.substring(len - k), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "_" + suff, -1);
    }

}
