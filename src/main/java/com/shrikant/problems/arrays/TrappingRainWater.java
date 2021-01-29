package com.shrikant.problems.arrays;

// Trapping rainwater between blocks but can have dips also, based on solutions here.
//https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
public class TrappingRainWater {
    
    public int trappingWater(int arr[], int n)
    {
        int result = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i < n; i++) {
            if (arr[i] < 0) {
                //it's a dip, so it should contain atleast that much water.
                //hence we can directly add that much to the result and replace negatives in original array to 0
                result += Math.abs(arr[i]);
                arr[i] = 0;
            }
        }

        //now process as regular with all positive numbers in array.
        //i.e calculate leftmax & rightmax for each array position
        //amount of water at that position would be 
        int leftMax = arr[0];
        int rightMax = arr[n-1];
        left[0] = arr[0];    
        for(int i=1; i<n; i++) 
        {
            if (arr[i] > leftMax) 
            {
                leftMax = arr[i];
            }
            left[i] = leftMax;
        }
        
        right[n-1] = arr[n-1];
        for(int j=n-2; j>=0; j--)
        {
            if(arr[j] > rightMax)
            {
                rightMax = arr[j];
            }

            right[j] = rightMax;
        }

        //go over entire array again to calculate trapping water.
        for(int i=0; i < n; i++) 
        {
            result += Math.min(left[i], right[i]) - arr[i];
        }
         
        return result;
    } 

}
