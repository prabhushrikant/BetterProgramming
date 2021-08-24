package com.shrikant.problems.bitProblems;

//Write a function that takes an unsigned integer and returns the number of '1' bits it has
//(also known as the Hamming weight).
public class HammingWeight {
    

    //method 1
    public int getHammingWeight(int n)
    {
        return Integer.bitCount(n);
    }


    //method 2 - use a mask ans right shift
    public int getHammingWeight2(int n)
    {
        int result = 0;
        int mask = 1; //rightmost bit
        while (n != 0)
        {
            if ((n & mask) == 1)
            {
                result++;
            }

            n = n >> 1;
        }

        return result;
    }


}
