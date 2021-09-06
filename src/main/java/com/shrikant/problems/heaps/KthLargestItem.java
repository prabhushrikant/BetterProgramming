package com.shrikant.problems.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

//complexity explaination:
// 1) Build a Max-Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array. O(k)
// 2) For each element, after the k’th element (arr[k] to arr[n-1]), compare it with root of MH. 
// ……a) If the element is less than the root then make it root and call heapify for MH 
// ……b) Else ignore it. 
// // The step 2 is O((n-k)*logk)
// 3) Finally, the root of the MH is the kth smallest element.
// Time complexity of this solution is O(k + (n-k)*Logk)
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
