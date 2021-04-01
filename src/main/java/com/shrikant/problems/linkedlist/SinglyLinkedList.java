package com.shrikant.problems.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {
    
    static ListNode build(String str)
    {
        if(str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        ListNode head = null;
        ListNode curr = null;
        int i = 0;
        while(i < ip.length)
        {
            ListNode newNode = new ListNode(Integer.parseInt(ip[i]));
            if (head == null) {
                head = newNode;
                curr = newNode;
            } else {
                curr.next = newNode;
                curr = newNode;
            }
            
            i++;
        }
        return head;
    }

    static void print(ListNode head)
    {
        while(head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    static List<Integer> getList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while(head != null) {
            result.add(head.data);
            head = head.next;
        }
        return result;
    }
}
