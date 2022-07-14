package com.company.competition.Week_284;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        int max = -1;
        for(int i = 0; i < nums.length; i++){
            if(key == nums[i]){
                int m = i - k;
                while(m <= i + k){
                    if(m >= 0 && m < nums.length){
                        if(m > max){
                            max = m;
                            list.add(m);
                        }
                    }
                    m++;
                }
            }
        }
        return list;
    }
}
