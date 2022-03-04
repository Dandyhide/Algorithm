package com.company.Week_246;

public class NumberOfRounds {
    public int numberOfRounds(String startTime, String finishTime) {
        String[] s0 = startTime.split(":");
        int m0 = Integer.parseInt(s0[0]);
        int m1 = Integer.parseInt(s0[1]);
        String[] s1 = finishTime.split(":");
        int n0 = Integer.parseInt(s1[0]);
        int n1 = Integer.parseInt(s1[1]);
        if (m0 < n0){
            return (n0 - m0 - 1) * 4 + (n1 / 15 * 15 + 60 - (m1 + 14) / 15 * 15) / 15;
        }
        if (m0 > n0){
            return (n0 - m0 + 24 - 1) * 4 + (n1 / 15 * 15 + 60 - (m1 + 14) / 15 * 15) / 15;
        }
        if (m0 == n0){
            if (m1 < n1){
                return (n1 / 15 * 15 - (m1 + 14) / 15 * 15) / 15 > 0 ? (n1 / 15 * 15 - (m1 + 14) / 15 * 15) / 15 : 0;
            }else{
                return 96 - ((m1 + 14) / 15 * 15 - n1 / 15 * 15) / 15;
            }
        }
        return 0;
    }
}
