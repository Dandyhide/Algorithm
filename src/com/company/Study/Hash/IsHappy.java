package com.company.Study.Hash;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            n = GetTemp(n);
            if (n == 1){
                return true;
            }
            if (set.contains(n)){
                return false;
            }
            set.add(n);
        }
    }

    private int GetTemp(int n) {
        int res = 0;
        while (n > 0){
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }
}
