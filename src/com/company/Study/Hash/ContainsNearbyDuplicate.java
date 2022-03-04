package com.company.Study.Hash;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k && i < nums.length; i++){
            set.add(nums[i]);
        }
        if (set.size() <= k && set.size() < nums.length){
            return true;
        }
        for (int i = k + 1; i < nums.length; i++){
            if (set.size() <= k && set.size() < nums.length){
                return true;
            }
            set.remove(nums[i - k - 1]);
            set.add(nums[i]);
        }
        if (set.size() <= k && set.size() < nums.length){
            return true;
        }
        return false;
    }
}
