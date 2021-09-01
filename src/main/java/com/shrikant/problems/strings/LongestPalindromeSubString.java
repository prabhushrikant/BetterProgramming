package com.shrikant.problems.strings;

import org.apache.commons.lang3.mutable.MutableInt;

//https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
public class LongestPalindromeSubString {

    public int longestPalindromeSubString(String str)
    {
        //find longest odd and even length strings which are palindrome
        //e.g. if current position is i
        // odd length palindrome can be obtained if (str[i-1] == str[i+1]),
        // even length palindrome can be obtained if (str[i-1] == str[i]) 

        int low = 0;
        int high = 0;
        // can't use Integer because it's immutable.
        MutableInt result = new MutableInt(1); //beause a single character is always a palindrome
        int startIndex = -1;
        for(int i = 1; i < str.length(); i++)
        {
            //trying even length palindromes
            low = i - 1;
            high = i; 

            checkForPalindrome(str, low, high, result);

            low = i -1;
            high = i + 1;
            
            checkForPalindrome(str, low, high, result);
        }

        return result.getValue();
    }

    private void checkForPalindrome(String str, int low, int high, MutableInt result)
    {
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high))
        {
            low--;
            high++;
        }
        //when above loop breaks, it can break becoz last inequality, hence check for it again.
        if ((--high) - (++low) + 1 > result.getValue())
        {
            result.setValue(high - low + 1); 
        }
    }
    
}
