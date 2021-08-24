package com.shrikant.problems.DP;

public class ClimbingStairs {
    // recursive solution
    // public int climbStairs(int n) {        
    //     if (n == 0)
    //         return 1;
    //     else if (n == 1)
    //         return climbStairs(n-1);
    //     else 
    //         return climbStairs(n-1) + climbStairs(n-2);                    
    // }
    
    //dynamic programming
    public int climbStairs(int n)
    {
        if (n <= 1) {
            return n == 1 ? 1 : 0;
        }
        int[] dpTable = new int[n];
        dpTable[0] = 1;
        dpTable[1] = 2;
        
        int i = 2;
        while(i < n)
        {
            dpTable[i] = dpTable[i-1] + dpTable[i-2];
            i++;
        }
        
        return dpTable[n-1];
    }

}
