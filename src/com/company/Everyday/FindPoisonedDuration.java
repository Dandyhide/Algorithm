package com.company.Everyday;

public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0){
            return 0;
        }
        int currMax = 0;
        int total = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (currMax > timeSeries[i]){
                total = total + duration - (timeSeries[i] + duration - currMax);
            }else{
                total = total + duration;
            }
            currMax = timeSeries[i] + duration;
        }
        return total;
    }
}
