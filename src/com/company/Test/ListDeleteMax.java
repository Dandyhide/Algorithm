package com.company.Test;


import com.company.ListNode;

public class ListDeleteMax {
    public ListNode deleteMax(ListNode node){
        if (node == null || node.next == null){
            return null;
        }
        int max = Integer.MIN_VALUE;
        ListNode temp = node;
        while (temp != null){
            if (temp.val > max){
                max = temp.val;
            }
            temp = temp.next;
        }
        if (max == node.val){
            return node.next;
        }
        temp = node.next;
        ListNode prev = node;
        while (temp.val != max){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return node;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(12);
        root.next = new ListNode(12);
        root.next.next = new ListNode(5);
        root.next.next.next = new ListNode(8);
        root.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next = new ListNode(4);
        ListDeleteMax listDeleteMax = new ListDeleteMax();
        ListNode res = listDeleteMax.deleteMax(root);
        while (res != null){
            System.out.print(res.val + " -> ");
            res = res.next;
        }

    }
}
