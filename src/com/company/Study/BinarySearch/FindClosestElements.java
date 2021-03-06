package com.company.Study.BinarySearch;

/**
 * 找到 K 个最接近的元素
 *
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *  
 *
 * 提示：
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/binary-search/xeve4m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        List<Integer> list = new ArrayList<>();
        if (k >= arr.length){
            for (int i : arr){
                list.add(i);
            }
            return list;
        }
        int flag = -1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == x){
                flag = mid;
                break;
            }
            if (arr[mid] < x){
                left = mid;
            }else{
                right = mid;
            }
        }
        if (flag == -1){
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                flag = left;
            }else{
                flag = right;
            }
        }
        left = flag - 1;
        right = flag + 1;
        while (k > 1){
            if (left < 0){
                right++;
            }else if (right >= arr.length){
                left--;
            }else{
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                    left--;
                }else{
                    right++;
                }
            }
            k--;
        }
        left++;
        right--;
        for (int i = left; i <= right; i++){
            list.add(arr[i]);
        }
        return list;
    }
}
