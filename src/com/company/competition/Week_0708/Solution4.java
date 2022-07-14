package com.company.competition.Week_0708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4 {

    int result_min = Integer.MAX_VALUE;

    public int minTransfers(int[][] distributions) {
        int max = 0;
        for(int i = 0; i < distributions.length; i++){
            max = Math.max(max, distributions[i][0]);
            max = Math.max(max, distributions[i][1]);
        }
        int[] a = new int[max + 1];
        for (int i = 0; i < distributions.length; i++){
            a[distributions[i][0]] -= distributions[i][2];
            a[distributions[i][1]] += distributions[i][2];
        }
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < a.length; i++){
            if(a[i] > 0){
                pos.add(a[i]);
            }
            if(a[i] < 0){
                neg.add(a[i]);
            }
        }
        count(pos, neg, 0);
        return result_min;
    }

    private void count(List<Integer> pos, List<Integer> neg, int count) {
        if (pos.size() == 0 || neg.size() == 0){
            result_min = Math.min(result_min, count);
        }
        for (int i = 0; i < pos.size(); i++){
            if (neg.contains(-pos.get(i))){
                int temp = pos.get(i);
                pos.remove(pos.get(i));
                for(int j = 0; j < neg.size(); j++){
                    if(neg.get(j) == -temp){
                        neg.remove(neg.get(j));
                        break;
                    }
                }
                count(pos, neg, count + 1);
            }
        }
        for(int i = 0; i < pos.size(); i++){
            for(int j = 0; j < neg.size(); j++){
                List<Integer> temp_pos = new ArrayList<>();
                temp_pos.addAll(pos);
                List<Integer> temp_neg = new ArrayList<>();
                temp_neg.addAll(neg);
                Match(i, j, pos, neg);
                count(pos, neg, count + 1);
                pos = temp_pos;
                neg = temp_neg;
            }
        }
    }

    private void Match(int i, int j, List<Integer> pos, List<Integer> neg) {
        int temp_i = pos.get(i);
        int temp_j = neg.get(j);
        if(temp_i > -temp_j){
            for (int m = 0; m < pos.size(); m++){
                if(pos.get(m) == temp_i){
                    pos.remove(pos.get(m));
                    pos.add(temp_i + temp_j);
                    break;
                }
            }
            for(int m = 0; m < neg.size(); m++){
                if(neg.get(m) == temp_j){
                    neg.remove(neg.get(m));
                    break;
                }
            }
        }else{
            for(int m = 0; m < neg.size(); m++){
                if(neg.get(m) == temp_j){
                    neg.remove(neg.get(m));
                    neg.add(temp_i + temp_j);
                    break;
                }
            }
            for (int m = 0; m < pos.size(); m++){
                if(pos.get(m) == temp_i){
                    pos.remove(pos.get(m));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution4 minTransfers = new Solution4();
        minTransfers.minTransfers(new int[][]{{0,1,1},{1,2,1},{2,3,4},{3,4,5}});
    }

}
