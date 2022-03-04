package com.company.C100;

public class AddList {
    public ListNode mergeNodeList(ListNode ha, ListNode hb, int M, int N){
        ListNode hc = null;
        if (M >= N){
            hc = hb;
            ListNode temp = hb;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = ha;
        }else{
            hc = ha;
            ListNode temp = ha;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = hb;
        }
        return hc;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(){
    }
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
