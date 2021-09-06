package com.shrikant.problems.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.PriorityQueue;

//Given an integer array nums and an integer k, return the k most frequent elements. 
//You may return the answer in any order.

//Note: This problem can also be solved using QuickSelect algorithm. o(N) - avg case, 0(n^2) -worst case

//It can also be solved using buckets of each frequency and traversing the bucket list. 0(n) - worst case
//maximum frequence a number can have is n = length of the given array. So create buckets of 1 to n 
//filling it up with numbers having that many frequencies.
//like here: https://leetcode.com/problems/top-k-frequent-elements/discuss/740374/Python-5-lines-O(n)-buckets-solution-explained./856266

//It can also be solved by creating TreeMap<freq, num[]> of frequencies in descending order. 
//Values for the TreeMap could be numbers in array with that much frequecy key.
//return values for top k keys in TreeMap.
public class TopKFrequentItems {
    
    //because we need most frequent items, i.e. largest by frequency , hence we can use minHeap.
    public int[] topKFrequent(int[] nums, int k) {
    
        Map<Integer, Integer> map = new HashMap<>();

        //because we want 
        Queue<Integer> q = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));
        for(int i : nums)
        {
            map.merge(i, 1, (oldVal, newVal) -> oldVal + 1);
            //or u can use.
            //map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(Integer key : map.keySet())
        {
            if (q.size() > k)
            {   
                if(map.get(q.peek()) <= map.get(key))
                {
                    //because we want most frequent items , if current items freq is lesser than current root of the minheap
                    //it's of no interest to us , hence ignore it.
                    q.add(key);
                }
            } 
            else {
                q.add(key);
            }
            

            if (q.size() > k)
            {
                q.poll();
            }
        }

        //empty the queue to a array beasue those are top frequent items.
        int[] result = q.stream().mapToInt(Integer :: intValue).toArray();
        //Integer[] result = q.stream().toArray(Integer[]::new);
        Arrays.sort(result);
        return result;
    }
}
