package com.company.Study.ListNode_Twice;

import com.company.ListNode;

public class ReverseList0831_Recursion {
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
