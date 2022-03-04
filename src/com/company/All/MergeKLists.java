package com.company.All;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表     Hard
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(-1);
        dummy.next = head;
        List<List<Integer>> arr = new ArrayList<>();
        for (ListNode list : lists) {
            ArrayList<Integer> tempList = new ArrayList<>();
            while (list != null) {
                tempList.add(list.val);
                list = list.next;
            }
            if (tempList.size() > 0){
                arr.add(new ArrayList<>(tempList));
            }
        }
        if (arr.size() == 0 || arr.get(0).size() == 0){
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (List<Integer> list : arr) {
            queue.add(list.get(0));
        }
        int k = -1;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            head.next = new ListNode(poll);
            head = head.next;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).get(0) == poll){
                    k = i;
                    break;
                }
            }
            arr.get(k).remove(0);
            if (arr.get(k).size() == 0){
                arr.remove(k);
                k = -1;
            }else{
                queue.add(arr.get(k).get(0));
            }
        }
        return dummy.next.next;
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        mergeKLists.mergeKLists(new ListNode[]{null});
        PriorityQueue<Status> queue = new PriorityQueue<>();
    }

    class Status implements Comparable<Status>{
        int val;
        ListNode node;
        public Status(int val, ListNode node){
            this.val = val;
            this.node = node;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }
}
