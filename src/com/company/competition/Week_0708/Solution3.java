package com.company.competition.Week_0708;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public int buildTransferStation(int[][] area) {
        int m = area.length;
        int n = area[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(area[i][j] == 1){
                    int[] a = new int[2];
                    a[0] = i;
                    a[1] = j;
                    list.add(a);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int temp = 0;
                for(int k = 0; k < list.size(); k++){
                    temp += Math.abs(list.get(k)[0] - i);
                    temp += Math.abs(list.get(k)[1] - j);
                }
                min = Math.min(temp, min);
            }
        }
        return min;
    }
}
