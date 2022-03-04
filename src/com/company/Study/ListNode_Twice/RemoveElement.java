package com.company.Study.ListNode_Twice;

import com.company.ListNode;

public class RemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode dummyNode = prev;
        ListNode curr = head;
        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
                curr = prev.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }
}
