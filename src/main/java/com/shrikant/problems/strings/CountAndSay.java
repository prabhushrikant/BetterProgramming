package com.shrikant.problems.strings;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/886/
// 1 <= n <= 30
public class CountAndSay {
   
    public String countAndSay(int n) {
        
        int count = 1;
        String countedString = "1";
        
        while(count < n) {
            countedString = getCounts(countedString);
            count++;
        }
        
        return countedString;
    }
    
    private String getCounts(String s)
    {
        char[] a = s.toCharArray();
        int count;

        if (s.length() < 2) {
            return "1" + s.charAt(0);
        }

        String newString = "";
        
        int i = 0;
        int j = i + 1;
        while( i < s.length() - 1)
        {
            count = 1;
            while(i < s.length()-1 && a[i] == a[j])
            {
                i++ ; j++; count++;
            }

            newString += Integer.valueOf(count).toString() + a[i];

            i++; 
            j++;
        }

        if (i == s.length()-1) {
            newString += "1" + a[i];
        }
    
        return newString;        
    }
}
