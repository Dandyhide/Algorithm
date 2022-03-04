package com.company.All;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountPairs {

    public int countPairs(int[] deliciousness) {
        int mod = (int) 1e9+7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deliciousness) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> integers = map.keySet();
        int[] res = new int[integers.size()];
        int k = 0;
        for (Integer integer : integers) {
            res[k++] = integer;
        }
        int result = 0;
        int max = 1 << 22;
        for (int i = 0; i < res.length; i++){
            for (int j = 1; j < max; j++){
                if (map.containsKey(j - res[i])){
                    if (res[i] == j - res[i] && map.get(res[i]) > 1){
                        result += map.get(res[i]) * (map.get(j - res[i]) - 1) / 2 % mod;
                    } else if (i < j - res[i]){
                        result += map.get(res[i]) * map.get(j - res[i]) % mod;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = new int[]{};
        CountPairs countPairs = new CountPairs();
        countPairs.countPairs(res);
    }

}
