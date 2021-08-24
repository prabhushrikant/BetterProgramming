package com.shrikant.problems.strings;

import java.util.HashMap;
import java.util.Map.Entry;

/*
We have two strings s1 and s2. Find if there is any permutation of s1 in s2.

Example 1:
s1 = "is" s2 = "sift"
Output : True

s1 = "ad" s2 = "fraud"
Output: false
*/
public class Sift {
    
    public boolean check(String s1, String s2)
    {
    
      //window 
      int l = 0; int h = s1.length() - 1;
     
      while(h < s2.length())
      {
        
        HashMap<Character, Integer> map = this.createS1Map(s1);
        if (evaluateWindow(map, s2, l, h))
        {
          return true;
        }
        
        //evaluate next window.
        l += 1;
        h += 1; 
      }
    
      return false;
    }

    private boolean evaluateWindow(HashMap<Character, Integer> S1Map, String S2, int low, int high)
    {
        
        int windowSize = high - low + 1;
        int i = 0;
        while(i < windowSize)
        {
            //check if s2 character is in s1 map and reduce its freq if found, to take care when character is repeated in S2 but not in S1.
            Integer newValue = S1Map.computeIfPresent(S2.charAt(low++), (k,v) -> v = v-1);
            if (newValue == null)
                return false;
            i++;
        }
        
        //check if S1map values are all zeros. 
        for(Entry<Character, Integer> entry : S1Map.entrySet()) 
        {
            if (entry.getValue() != 0)
            {
               return false;
            }
        }
        
        return true;
    }
  
    private HashMap<Character, Integer> createS1Map(String S1)
    {
        HashMap<Character, Integer> S1Map = new HashMap<>();
        for (int i = 0; i < S1.length(); i++)
        {
            S1Map.merge(S1.charAt(i), 1, (oldValue, newValue) -> oldValue + 1); 
        }
        
        return S1Map;
    }
}
