package com.shrikant.problems.linkedlist;

public class ReverseInGroups {

    public ListNode reverse(ListNode node, int k)
    {
        //Your code here
        if (node == null)
          return null;
            
        int i=0;
        ListNode nextt = node;
        while(i < k-1 && nextt.next != null) {
            nextt = nextt.next;
            i++;
        }    

        //this order is important, reversing the order makes it go in infite loop.
        //reverse the next group first, so that we can connect it to this group after reversing this group.
        nextt = reverse(nextt.next, k);
        //reverse this group and get the new head of this group.
        ListNode newHead = reverseSubList(node, k);

        //connect next reversed groups to this one.
        node.next = nextt;

        return newHead;
    }
    
    private ListNode reverseSubList(ListNode node, int k) 
    {
        if (k == 0) {
            return node;
        }
        ListNode prev = null;
        int i = 0;
        while(i < k && node != null) {
            ListNode nextt = node.next;
            node.next = prev;
            prev = node;
            node = nextt;
            i++;
        }
        
        return prev;
    }
    
}
