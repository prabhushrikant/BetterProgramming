package com.shrikant.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int convert(String s) {
        
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        
        char[] chars = s.toCharArray();
        int result = 0;
        int curr =0;
        int next = curr + 1;
        while(next < chars.length)
        {
            if (romans.get(chars[curr]) < romans.get(chars[next]))
            {
                result += romans.get(chars[next]) - romans.get(chars[curr]);
                curr = next+1;
                next = curr+1;
            }  
            else
            {
                result += romans.get(chars[curr]);
                curr++;
                next = curr + 1;
            }
        }
        
        if (curr < chars.length) {
            result += romans.get(chars[curr]);
        }
        return result ;
    }
}
