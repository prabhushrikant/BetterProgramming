package com.shrikant.problems.linkedlist;

//detect and break the loop in linked list (if exists), 
//using Floyd's cycle detection algorithm (Tortoise and Hare algorithm)
//This is optimal solution with O(n) time complexity and O(1) space complexity.
//But we can also use HashSet to store the nodes and check if we have already seen the node before, if yes then break the loop. 
//(Easier to implement but not optimal in space complexity, O(n) space complexity and O(n) time complexity.)
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
        //System.out.println("Cycle Starting point : " + fast.data);
        //System.out.println("List real tail point : " + realTail.data);
        
        //break the Cycle ...
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
