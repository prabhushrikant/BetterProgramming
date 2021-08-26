package com.shrikant.problems.DP;


public class HouseRobber {
    
    //recurrance forumula 
    //rob(i) = Math.max(rob(i+1) , nums[i] + rob(i+2))
    public int rob(int[] nums)
    {
        //Note: because from recurrance relation rob(i) depends on future values , i.e. when recursion unfolds
        //this should indicate that we should start filling up our dpTable from bottom to top.

        //we need an extra length because as per recurrance relation above, because 
        //each value i needs values from next two positions (i+1) & (i+2).
        int[] dpTable = new int[nums.length + 1];
        
        dpTable[nums.length] = 0;
        dpTable[nums.length - 1] = nums[nums.length-1];

        for(int i = nums.length - 2; i >= 0; i--)
        {
            dpTable[i] = Math.max(dpTable[i+1], nums[i] + dpTable[i + 2]);
        }

        return dpTable[0];
    }


    //recursion with memoization solution
    // public int rob(int[] nums) {
        
    //     //because description says nums.length <= 100
    //     int[] cache = new int[100];
    //     Arrays.fill(cache, -1);
        
    //     if (nums.length < 2)
    //         return nums[0];
        
        
    //     return rob(0, nums, cache);
    // }
    
    // private int rob(int start, int[] nums, int[] cache)
    // {
    //     if (start >= nums.length)
    //     {
    //         return 0; //there is no more houses to loot hence no more profit.
    //     }
        
    //     if (cache[start] > -1)
    //         return cache[start];
        
    //     int val = Math.max(rob(start+1, nums, cache), nums[start] + rob(start+2, nums, cache));    
    //     cache[start] = val;
        
    //     return val;
    // }
}
