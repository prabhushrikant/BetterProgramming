package com.shrikant.problems.strings;

public class ReverseWordsInString {
    
    String reverseWords(String S) {
        //code here
        //split accept the regex and . is a special character in regex hence escape it. 
        String[] arr = S.split("\\.");
        
        //start popping
        String result = "";
        int i = arr.length - 1;
        while(i >= 0) 
        {
            result = result + (i == 0?  arr[i--] : arr[i--] + ".");
        }
        //not available in java 8
        //result.trim(".");

        return result;
    }
}
