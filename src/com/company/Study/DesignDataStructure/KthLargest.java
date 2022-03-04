package com.company.Study.DesignDataStructure;

/**
 * 703. 数据流中的第 K 大元素
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *  
 *
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 *
 * 作者：宫水三叶
 * 链接：https://leetcode-cn.com/leetbook/read/designing-data-structures/rucor5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class KthLargest {
    int index;
    int size;
    int[] a = new int[10000];
    public KthLargest(int k, int[] nums) {
        Arrays.fill(this.a, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++){
            a[i] = nums[i];
        }
        this.index = k - 1;
        this.size = nums.length;
        for (int i = 1; i < nums.length; i++){
            if (a[i] > a[i - 1]){
                int j = i - 1;
                int temp = a[i];
                while (j >= 0 && a[j] < temp){
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = temp;
            }
        }
    }

    public int add(int val) {
        int left = 0, right = size;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (a[mid] >= val){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        for (int i = size; i > left; i--){
            a[i] = a[i - 1];
        }
        a[left] = val;
        return a[index];
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(1, new int[]{2,3,1,5,4});
        kthLargest.add(10);
    }
}
