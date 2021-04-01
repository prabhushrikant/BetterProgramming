package com.shrikant.problems.linkedlist;

public class ReverseALinkedList {

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        while(head != null) {
            ListNode newNode = head.next;
            head.next = prev;
            prev = head;
            head = newNode;
        }
        return prev;
    }
    
}
