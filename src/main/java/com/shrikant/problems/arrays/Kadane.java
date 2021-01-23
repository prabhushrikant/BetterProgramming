package com.shrikant.problems.arrays;

class Kadane{
    
    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int arr[], int n){
        
    // Your code here
    int result = -99999;
    int max_till_here = 0;
    int left = 0;
    int right = 0;
    for(int i=0; i< n; i++){
        
        max_till_here += arr[i];
        if (result < max_till_here) {
            result = max_till_here;
            right = i;
        }
        
        if (max_till_here < 0) {
            max_till_here = 0;
            left = i + 1;
        }
    }
    
    System.out.println("Subarray left: " + left + ", right: " + right);
    return result;
        
    }
    
}