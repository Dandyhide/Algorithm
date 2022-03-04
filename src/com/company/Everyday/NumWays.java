package com.company.Everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumWays {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : relation) {
            if (map.get(ints[0]) == null){
                map.put(ints[0], new ArrayList<>(ints[1]));
            }else{
                map.get(ints[0]).add(ints[1]);
            }
        }
        
        return 0;
    }
}
