package com.company.Study.ListNode_Twice;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        if (k == 0 || head == null || head.next == null){
            return head;
        }
        //算出链表长度
        int len = 0;
        while (fast != null){
            fast = fast.next;
            len++;
        }
        System.out.println(len);
        int n = k % len;
        System.out.println(n);
        while (n-- > 0){
            if (fast == null || fast.next == null){
                fast = head;
            }else{
                fast = fast.next;
            }
        }
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
}
