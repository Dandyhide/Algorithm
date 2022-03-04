package com.company.All;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        for (char c : chars1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : chars2) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) <= 0){
                map.remove(c);
                if (map.isEmpty()){     //快一些
                    return true;
                }
            }
        }
        return map.isEmpty();
    }
}
