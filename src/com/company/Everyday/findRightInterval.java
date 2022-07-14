package com.company.Everyday;

import java.util.*;

/**
 * 436. 寻找右区间
 *
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 *
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 *
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 *
 *  
 * 示例 1：
 *
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 *
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 *
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-right-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class findRightInterval {



    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> map_start = new HashMap<>();
        int len = intervals.length;
        for(int i = 0; i < len; i++){
            map_start.put(intervals[i][0], i);
        }
        int[] res = new int[len];
        int[] key = new int[len];
        int k = 0;
        Set<Integer> set = map_start.keySet();
        for (Integer keyValue : set) {
            key[k++] = keyValue;
        }
        Arrays.sort(key);
        for(int i = 0; i < len; i++){
            if(set.contains(intervals[i][1])){
                res[i] = map_start.get(intervals[i][1]);
            }else{
                res[i] = getResult(intervals[i][1], key);
            }
        }
        return res;
    }

    public int getResult(int k, int[] key){
        if(k > key[key.length - 1]){
            return -1;
        }
        int left = 0, right = key.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(key[mid] > k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
