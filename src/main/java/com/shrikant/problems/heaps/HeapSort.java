package com.shrikant.problems.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {
    
    Comparator<Integer> nodeComparatorAsc = new Comparator<Integer>(){

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2 ? -1 : o1 > o2 ? 1 : 0;
        }
        
    }; 
    
    PriorityQueue<Integer> apq = new PriorityQueue<>(1000, nodeComparatorAsc);
    
    public int[] heapSort(int arr[], int n)
    {
        for (int i = 0; i < arr.length; i++) {
            apq.add(arr[i]);
        }
    
        int i = 0;
        while(!apq.isEmpty()) {
            arr[i] = apq.poll();
            i++;
        }

        return arr;
    } 
}
