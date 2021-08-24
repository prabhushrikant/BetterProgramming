package com.shrikant.problems.bitProblems;

//https://leetcode.com/problems/reverse-bits/solution/
//ie. convert 0000 0101 to 1010 0000 instead.
public class ReverseBits {
  
    public int reverseBits(int n)
    {
        n = (n >> 16) | (n << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);

        return n;
    }   
    
    
    public int reverseBits2(int n)
    {
        int result = 0;
        int power = 31;
        while(n != 0)
        {
            result += (n & 1) << power;
            n = n >> 1;
            power--;
        }

        return result;
    }
}
