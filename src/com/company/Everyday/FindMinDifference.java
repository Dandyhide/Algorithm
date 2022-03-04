package com.company.Everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] a = new int[timePoints.size()];
        for(int i = 0; i < timePoints.size(); i++){
            a[i] = calculateMinute(timePoints.get(i));
        }
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < a.length; i++){
            int temp = a[i] - a[i - 1];
            if(temp == 0){
                min = 0;
                return min;
            }
            if(temp < min){
                min = temp;
            }
        }
        int last = a[0] + 60 * 24 - a[a.length - 1];
        if (last < min){
            min = last;
        }
        return min;
    }

    public int calculateMinute(String str){
        String[] s = str.split(":");
        return Integer.valueOf(s[0]) * 60 + Integer.valueOf(s[1]);
    }

    public static void main(String[] args) {
        FindMinDifference findMinDifference = new FindMinDifference();
        ArrayList<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        findMinDifference.findMinDifference(list);
    }
}
