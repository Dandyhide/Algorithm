package com.company.All;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间         Medium
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> list = new ArrayList<>();
        boolean flag = false;
        for (int[] temp : intervals){
            if (flag){
                list.add(temp);
            }else if (temp[0] > right){
                list.add(new int[]{left, right});
                list.add(temp);
                flag = true;
            }else if (temp[1] < left){
                list.add(temp);
            }else{
                left = Math.min(left, temp[0]);
                right = Math.max(right, temp[1]);
            }
        }
        if (!flag){
            list.add(new int[]{left, right});
        }
        int[][] result = new int[list.size()][2];
        int k = 0;
        for (int[] arr : list){
            result[k++] = arr;
        }
        return result;
    }
}
