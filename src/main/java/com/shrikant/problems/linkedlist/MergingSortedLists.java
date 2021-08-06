package com.shrikant.problems.linkedlist;

public class MergingSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode resultHead = null;
        ListNode resultEnd = null;
        
        while(l1 != null && l2 != null)
        {
            if (l1.data < l2.data)
            {
                if (resultHead == null)
                {
                    resultHead = l1;
                    resultEnd = resultHead;
                }
                else {
                    resultEnd.next = l1;
                    resultEnd = resultEnd.next;
                }
                l1 = l1.next;
            }
            else if (l1.data > l2.data)
            {
                
               if (resultHead == null)
                {
                    resultHead = l2;
                    resultEnd = resultHead;
                }
                else {
                    resultEnd.next = l2;
                    resultEnd = resultEnd.next;
                }
                l2 = l2.next;
            }
            else {
                
                if (resultHead == null)
                {
                    resultHead = l1;
                    resultEnd = resultHead;
                    
                } else {
                    
                    resultEnd.next = l1;
                    resultEnd = resultEnd.next;
                }
                l1 = l1.next;
                
                resultEnd.next = l2;
                resultEnd = resultEnd.next;
                l2 = l2.next;

                // updating l1 and l2 in the end together creates cycles in final list
                // hence copy next value of l1 into l1 before updating resultEnd with l2.
                // l1 = l1.next;
                // l2 = l2.next; 
            }
        }
        
        if (l1 == null) {
            if (resultHead == null) {
                resultHead = l2;
            } else {
                resultEnd.next = l2;    
            }            
        }
        
        if (l2 == null)
        {
            if (resultHead == null) {
                resultHead = l1;
            } else {
                resultEnd.next = l1;
            }
        }
        
        return resultHead;
    }
}
