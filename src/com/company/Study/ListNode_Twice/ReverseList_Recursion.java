package com.company.Study.ListNode_Twice;

import com.company.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseList_Recursion {
    /**
     * Recursion
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
