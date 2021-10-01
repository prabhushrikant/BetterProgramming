package com.shrikant.problems.linkedlist;

//detect and break the loop in linked list (if exists)
public class BreakLoopIfExists {

    public void breakLoop(ListNode head) {
        
        ListNode nodeInTheLoop = detectLoop(head);
        if (nodeInTheLoop == null) 
            return;

        int size = 1;             
        //loop exists hence count number of variables in loop
        ListNode sizer = nodeInTheLoop.next;
        while(sizer != nodeInTheLoop) {
            sizer = sizer.next;
            size++;
        }
        
        //find the starting node of loop, 
        //A node before it, is the real tail node of the linked list after breaking it.
        ListNode slow = head;
        ListNode fast = head;
        ListNode realTail = head;

        //advance fast by size of the loop initially.
        int k = 0;
        while(k < size) {
            realTail = fast;
            fast = fast.next;
            k++;
        }

        //now increment both slow and fast , so that they meet at the starting point of the loop and hence
        //realTail which is following fast, captures the tail of the list.
        while(slow != fast) {
            slow = slow.next;
            realTail = fast;
            fast = fast.next;
        }

        //debugging.
        //System.out.println("Loop Starting point : " + fast.data);
        //System.out.println("List real tail point : " + realTail.data);
        
        //break the loop ...
        realTail.next = null;
        
    }

    public ListNode detectLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode nodeInTheLoop = null;
        while(slow != null && fast != null) {
            if (slow == fast) {
                nodeInTheLoop = slow; 
                break;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return nodeInTheLoop;
    }
    
}
