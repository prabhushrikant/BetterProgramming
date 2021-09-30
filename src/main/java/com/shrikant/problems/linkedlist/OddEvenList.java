package com.shrikant.problems.linkedlist;

public class OddEvenList {
    
    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return null;

        ListNode oddHead = head;
        ListNode odd = oddHead;

        //start with the even node after the head.
        ListNode node = head.next;
        boolean isOddNode = false;
        ListNode evenHead = null;
        ListNode even = null;

        while(node != null)
        {
            if (isOddNode) 
            {
                odd.next = node;
                odd = odd.next;                
            }
            else 
            {
                if (evenHead == null)
                {
                    evenHead = node;
                    even = evenHead;
                }
                else {
                    even.next = node;
                    even = even.next;
                }
            }

            node = node.next;
            isOddNode = !isOddNode;
        }

        odd.next = evenHead;
        //don't forget to remove the loop it might create when last even 
        //node points to last odd node in case of odd length list.
        if (even != null) {
            even.next = null;
        }
        return head;
    }
}
