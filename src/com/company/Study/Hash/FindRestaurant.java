package com.company.Study.Hash;

import java.util.*;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++){
            if (map.containsKey(list2[i])){
                if (map.get(list2[i]) + i <= min){
                    temp.put(map.get(list2[i]), i);
                    min = map.get(list2[i]) + i;
                }
            }
        }
        Set<Integer> set = temp.keySet();
        for (Integer integer : set) {
            if (integer + temp.get(integer) == min){
                list.add(list1[integer]);
            }
        }
        String[] res = new String[list.size()];
        int k = 0;
        for (String s : list) {
            res[k++] = s;
        }
        return res;
    }
}
