package com.shrikant.problems.strings;

//This is a very simple looking problem but candidate might miss an important test case which changes the whole solution.
//It can also produce an empty string as output, hence I found it really interesting to solve.

//https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0

//Note: This produces a non-recursive solution.
public class RemoveAdjascentDuplicateChars {
    
    public String removeAdjDuplicateChars(String S) {
        
        int i = 0;
        Boolean skipLastChar = false;
        String result = "";
        while(i < S.length() - 1)
        {
            int j = i + 1;
            Boolean foundDuplicates = false;
            while (j < S.length()) 
            {
                if (S.charAt(i) == S.charAt(j))
                {                    
                    j++;
                    foundDuplicates = true; 
                }
                else {
                    break;
                }
            }
            if(!foundDuplicates)
            {
                result = makeNewString(result, S.charAt(i));
            }
            if (j >= S.length()) 
            {
                //don't process last character when j has processed all
                //the way till end of the string.
                skipLastChar = true;
                break;
            } 
            i = j;
        }
        
        if (!skipLastChar) {
            //work with last remaining char in orig string
            result = makeNewString(result, S.charAt(i));            
        }

        return result;
    }

    private String makeNewString(String result, char charToAppend)
    {
        if (result.length() == 0) {
            return String.valueOf(charToAppend);
        }
        if (result.charAt(result.length()-1) != charToAppend)
        {
            return result + String.valueOf(charToAppend);
        }
        //if here means appending the char causes repetition in the end.
        //remove the last repeating character from result which can also lead to empty string.    
        return result.substring(0, result.length()-1); 
    }
}


