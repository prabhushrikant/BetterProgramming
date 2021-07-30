package com.shrikant.problems.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/longest-common-prefix/
public class CommonPrefix {
    
    public String longestCommonPrefix(String[] strs)
    {
        //divide and conquer strategy.
        List<String> curr = new ArrayList<String>();
        curr.addAll(Arrays.asList(strs));
        List<String> newStrs = new ArrayList<String>();
        while(curr.size() > 1) {
            newStrs = new ArrayList<String>();
            int i = 0; 
            while(i < curr.size() - 1) 
            {
                String prefix = longestCommonPrefix(curr.get(i), curr.get(i+1));
                if (prefix.equals("")) {
                    return "";
                } else {
                    newStrs.add(prefix);
                }
                i += 2;               
            }

            if (i == curr.size() - 1) {
                newStrs.add(curr.get(i));
            }

            if (newStrs.size() > 0) {
                curr = newStrs;
            }
        }
    
        return curr.get(0);    
    }

    private String longestCommonPrefix(String str1, String str2)
    {
        int i = 0;
        int j = 0;
        String commonPrefix = "";
        while (i < str1.length() && j < str2.length())
        {
            if (str1.charAt(i) == str2.charAt(j)) 
            {
                commonPrefix += str1.charAt(i);
                i++;
                j++;
            } else {
                break;
            }
        }

        return commonPrefix;
    }
}
