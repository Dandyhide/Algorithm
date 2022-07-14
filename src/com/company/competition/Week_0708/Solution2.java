package com.company.competition.Week_0708;

public class Solution2 {
    public int minSwaps(int[] chess) {
        int count = 0;
        for(int i = 0; i < chess.length; i++){
            if(chess[i] == 1){
                count++;
            }
        }
        int curr = 0;
        int max_size = 0;
        for(int i = 0; i < count; i++){
            if(chess[i] == 1){
                curr++;
            }
        }
        max_size = curr;
        for(int i = count; i < chess.length; i++){
            if(chess[i] == 1){
                curr++;
            }
            if(chess[i - count] == 1){
                curr--;
            }
            max_size = Math.max(max_size, curr);
        }
        return count - max_size;
    }
}
