package com.company.All;

import java.util.Map;

public class lastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int half = sum / 2;
        boolean[] flag = new boolean[half + 1];
        flag[0] = true;
        for (int stone : stones) {
            for (int i = half; i >= stone; i--){
                flag[i] = flag[i] || flag[i - stone];
            }
        }
        for (int i = half; i >= 0; i--){
            if (flag[i]){
                return sum - i * 2;
            }
        }
        return 0;
    }

}
