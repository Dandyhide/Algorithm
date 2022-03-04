package com.company.Study.Hash;

import java.util.HashMap;
import java.util.Map;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int len = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] res = new int[len];
        int k = 0;
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0){
                res[k++] = i;
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = res[i];
        }
        return result;
    }
}
