package com.company.Study.Hash;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(map.get(integer));
        }
        Integer[] m = new Integer[list.size()];
        list.toArray(m);
        Arrays.sort(m);
        Set<Integer> set = map.keySet();
        int min = m[m.length - k];
        List<Integer> res = new ArrayList<>();
        for (Integer integer : set) {
            if (map.get(integer) >= min){
                res.add(integer);
            }
        }
        int[] n = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            n[i] = res.get(i);
        }
        return n;
    }
}
