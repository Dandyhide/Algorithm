package com.company.Study.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums1.length; j++){
                map1.put(nums1[i] + nums2[j], map1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
                map2.put(nums3[i] + nums4[j], map2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }
        Set<Integer> integers = map1.keySet();
        for (Integer integer : integers) {
            if (map2.containsKey(-integer)){
                count += map1.get(integer) * map2.get(-integer);
            }
        }
        return count;
    }
}
