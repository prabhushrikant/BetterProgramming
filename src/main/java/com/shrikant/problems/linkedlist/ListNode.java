package com.shrikant.problems.linkedlist;

public class ListNode {
    int data;
    ListNode prev;
    ListNode next;
    ListNode bottom; //experimental for some problems.

    ListNode(int item)
    {
        data = item;
        prev = next = bottom = null;
    }
}
