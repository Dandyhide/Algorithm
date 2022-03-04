package com.company.All;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int key = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if (sum < min){
                min = sum;
                key = i;
            }
        }
        if (sum < 0){
            return -1;
        }
        return key == gas.length - 1 ? 0 : key + 1;
    }
}
