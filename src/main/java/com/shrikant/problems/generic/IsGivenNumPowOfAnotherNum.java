package com.shrikant.problems.generic;


//Two numbers n and p , write a program without using loop if it's a n is some power of p
//e.g 
//if n = 27 and p = 3 , return true
//if n = 15 and p = 3 , return false
//if n = 16 and p = 2 , return true
//if n = 10 and p = 2 , return false

//Note: don't use any loop.
public class IsGivenNumPowOfAnotherNum {
    
    public boolean isPowerOf(int n , int p)
    {
        //convert given number to the base-p
        //All powers in respective base has the representation has 10, 100, 1000, 10000 etc.

        //e.g. in binary system.
        // 2^1 => 0010
        // 2^2 => 0100
        // 2^3 => 1000
        
        //e.g. in decimal system.
        // 10^1 => 0010
        // 10^2 => 0100
        // 10^3 => 1000

        String baseChangedInteger = Integer.toString(n, p);

        return baseChangedInteger.matches("^10*$");
    }
}
