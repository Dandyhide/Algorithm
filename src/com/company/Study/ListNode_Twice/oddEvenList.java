package com.company.Study.ListNode_Twice;

import com.company.ListNode;

public class oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
