package com.shrikant.problems.arrays;

class Kadane{
    
    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int arr[], int n){
        
    // Your code here
    int result = Integer.MIN_VALUE;
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
    
    //simpler implementation
    //Note: Doesn't return the sub array positions
    // int maxSubarraySum2(int nums[], int n)
    // {
    //     int i = 0;
    //     int maxSum = Integer.MIN_VALUE;
    //     int currSum = 0;
    //     while(i < nums.length)
    //     {
    //         if (currSum + nums[i] < 0)
    //         {
    //             //reset
    //             currSum = 0;
    //         }            
            
    //         currSum = Math.max(nums[i], currSum + nums[i]);
    //         if (currSum > maxSum)
    //             maxSum = currSum;

            
    //         i++;
    //     }
        
    //     return maxSum;
    // }
    
}