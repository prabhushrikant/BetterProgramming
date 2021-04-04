package com.shrikant.problems.linkedlist;

//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#
public class FlattenList {
    
    ListNode flatten(ListNode root)
    {
	// Your code here
	    if (root == null) 
	        return null;
        
        ListNode flattenHead = flatten(root.next);
        
        flattenHead = merge(root, flattenHead);
        // System.out.println("flattenHead after merge: " + flattenHead.data);
        
        return flattenHead;
    }
    
    ListNode merge(ListNode root1, ListNode root2) 
    {
        ListNode head = null; 
        ListNode tail = head;
        
        while(root1 != null && root2 != null) 
        {
            ListNode smaller = null;
            if (root1.data <= root2.data)
            {
                if (head == null) {
                    head = root1;
                    tail = head;
                } else {
                    smaller = root1;
                } 
                root1 = root1.bottom;
            } else {
                if (head == null) {
                    head = root2;
                    tail = head;
                } else {
                    smaller = root2;          
                } 
                root2 = root2.bottom;
            }
            
            if (tail.bottom != smaller) {
                //avoid self loop or cycle.
                tail.bottom = smaller;
            } 
            
            if (tail.bottom != null) {
                tail = tail.bottom;
            }
            
        }
        
        //no need to loop through remaining first list since it's already 
        //connected hence just adjust the pointer correctly.
        if(root1 != null) {
            if (head == null) {
                head = root1;
                tail = head;
            } else {
                tail.bottom = root1;
            }
        }
        
        if(root2 != null) {
            if (head == null) {
                head = root2;
                tail = head;
            } else {
                tail.bottom = root2;
            } 
        }
        
        return head;
    }
}
