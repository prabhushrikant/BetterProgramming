package com.shrikant.problems.arrays;

import java.util.ArrayList;

// Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:
public class EquilibriumPoint {
    
    public int equilibriumPoint(int arr[], int n) 
    {
        // Your code here
        if (n == 1) return 0;  //edge cases.

        if (n%2 == 0) return -1; //edge cases.

        long totalSum = 0;
        for(long i : arr) {
            totalSum += i;
        }
        
        long leftSum = 0;
        long rightSum = totalSum;
        for (int i=0; i < n; i++) {
            rightSum = rightSum - arr[i];
            if (leftSum == rightSum) {
                return i; //equilibrium point.
            }            
            leftSum += arr[i];
        }
        
        return -1; //no such point exits.

        
    }
}
