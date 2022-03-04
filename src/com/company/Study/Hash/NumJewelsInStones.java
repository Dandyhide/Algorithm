package com.company.Study.Hash;

import java.util.HashMap;
import java.util.Map;

public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length(); i++){
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i), 0)+1);
        }
        int res = 0;
        for (int i = 0; i < jewels.length(); i++){
            if (map.containsKey(jewels.charAt(i))){
                res += map.get(jewels.charAt(i));
            }
        }
        return res;
    }
}
