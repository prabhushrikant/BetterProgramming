package com.shrikant.problems.arrays;

public class RotateArrayByK {
    
    public int[] rotateArrayByK(int arr[], int k) {
        k = k % arr.length;
        reverse(arr, 0 , arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);  
        
        return arr;
    }

    void reverse(int arr[], int start, int end) {
        while(start < end) {
            int temp = arr[end];
            arr[end--] = arr[start];
            arr[start++] = temp; 
        }
    }
}
