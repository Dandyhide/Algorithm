package com.company.Study.ListNode_Twice;

import com.company.ListNode;

import java.util.Scanner;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while (l1 != null && l2 != null){
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            dummy = new ListNode(val);
        }
        return null;
    }
}
