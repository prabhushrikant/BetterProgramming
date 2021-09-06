package com.shrikant.problems.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestItem {

    public int getKthLargestItem(int[] arr, int k)
    {
        if (k > arr.length)
        {
            k = 1; //return the largest item in arr.
        }

        Queue<Integer> q = new PriorityQueue<Integer>((a, b) -> a - b); //minHeap
        
        for(int i : arr)
        {
            if (q.size() > k)
            {
                if(i >= q.peek()) 
                {
                    //because we want only the largest items we can ignore items less than the current
                    //largest on top of the heap. 
                    q.add(i);
                }
            } 
            else 
            {
                q.add(i);    
            }
            
            if (q.size() > k)
            {
                q.poll();
            }
        }

        //kth largest element should be on top of the minHeap, because we only added larger items to the heap
        //after it was full and whenever it went over capacity removed the next minimum item.
        return q.poll();

    }
    
}
