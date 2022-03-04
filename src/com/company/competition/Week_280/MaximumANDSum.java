package com.company.competition.Week_280;

import java.util.*;

public class MaximumANDSum {
    Map<Integer, Integer> map = new HashMap<>();
    int numSlots;
    public int  maximumANDSum(int[] nums, int numSlots) {
        this.numSlots = numSlots;
        for (int i = 1; i <= numSlots; i++){
            map.put(i, 2);
        }
        Set<Integer> keySet = map.keySet();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int num = iterator.next();
            if (keySet.contains(num) && map.get(num) > 0){
                sum += num;
                iterator.remove();
                map.put(num, map.get(num) - 1);
                if (map.get(num) <= 0){
                    map.remove(num);
                }
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (Integer num : list) {
            sum += getKey(num);
        }
        return sum;
    }

    private int getKey(int i){
        Set<Integer> set = map.keySet();
        int max = 0;
        int key = 0;
        for (Integer num : set) {
            if ((num & i) >= max){
                max = num & i;
                key = num;
            }
        }
        map.put(key, map.get(key) - 1);
        if (map.get(key) <= 0){
            map.remove(key);
        }
        return max;
    }
//    private int getKey(int i) {
//        boolean flag = i % 2 == 0;
//        for (int j = numSlots; j >= 0; j--){
//            if ((flag && j % 2 == 0) || (!flag && j % 2 != 0)){
//                if (map.get(j) > 0){
//                    map.put(j, map.get(j) - 1);
//                    return j;
//                }else{
//                    if (j - 2 > 0 && map.get(j - 2) > 0){
//                        map.put(j - 2, map.get(j - 2) - 1);
//                        return j - 2;
//                    }else{
//                        return getKey(j - 1);
//                    }
//                }
//            }
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        int[] a = new int[]{14,7,9,8,2,4,11,1,9};
        MaximumANDSum maximumANDSum = new MaximumANDSum();
        maximumANDSum.maximumANDSum(a, 8);
    }
}
