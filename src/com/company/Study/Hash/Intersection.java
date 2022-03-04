package com.company.Study.Hash;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int k = 0;
        for (int i : nums2) {
            if (set.contains(i)){
                res[k++] = i;
                set.remove(i);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = res[i];
        }
        return result;
    }
}
