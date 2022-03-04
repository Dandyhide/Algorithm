package com.company.Everyday;

import java.util.HashMap;
import java.util.Map;

public class integerReplacement2 {
    Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1){
            return 0;
        }
        if (!map.containsKey(n)){
            if (n % 2 == 0){
                map.put(n, integerReplacement(n / 2) + 1);
            }else{
                map.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return map.get(n);
    }
}
