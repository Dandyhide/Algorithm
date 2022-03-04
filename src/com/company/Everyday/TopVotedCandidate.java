package com.company.Everyday;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

    int[] result;
    int[] persons;
    int[] times;
    Map<Integer, Integer> map;
    int maxCount = 0;
    int maxCode = -1;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.result = new int[times[times.length - 1] + 1];
        map = new HashMap();
        int j = 0;
        int k = 0;
        for(int i = 0; i <= result.length; i++){
            if(i == times[k]){
                map.put(persons[k], map.getOrDefault(persons[k], 0) + 1);
                if(map.get(persons[k]) >= maxCount){
                    for(int m = j; m <= i; m++){
                        result[m] = persons[k];
                    }
                    maxCode = persons[k];
                }else{
                    for(int m = j; m <= i; m++){
                        result[m] = maxCode;
                    }
                }
                k++;
                j = i + 1;
            }
        }
    }

    public int q(int t) {
        return result[t];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
