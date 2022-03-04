package com.company.All;

/**
 * 25. K 个一组翻转链表        Hard
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 *
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 *
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 *
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = dummy;
        while (fast != null){
            for (int i = 0; i < k - 1 && fast != null; i++){
                fast = fast.next;
            }
            if (fast != null){
                ListNode temp = fast.next;
                fast.next = null;
                ListNode tempPrev = new ListNode(-1);
                ListNode tempEnd = slow;
                while (slow != null){
                    ListNode tempSlow = slow.next;
                    slow.next = null;
                    slow.next = tempPrev;
                    tempPrev = slow;
                    slow = tempSlow;
                }
                prev.next = tempPrev;
                while(tempPrev.next.val != -1){
                    tempPrev = tempPrev.next;
                }
                prev = tempPrev;
                tempPrev.next = temp;
                fast = temp;
                slow = temp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(root, 2);
    }
}
