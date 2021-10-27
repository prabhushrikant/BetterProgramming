package com.shrikant.problems.backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TelephoneLetters {
    
    public List<String> letterCombinations(String digits) {
        
        HashMap<Character, String> keyMap = new HashMap<>();
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
        
        List<String> result = new ArrayList<String>();
        
        char[] arr = digits.toCharArray();        
        for(int c = 0; c < arr.length; c++)
        {
            Character digit = arr[c];
            if(!keyMap.containsKey(digit))
                continue;
            
            result = createStrings(keyMap.get(digit), result);
        }
        
        return result;
    }
    
    private List<String> createStrings(String input, List<String> result)
    {
        char[] arr = input.toCharArray();
        
        if (result.size() == 0)
        {
            for(char c=0; c < arr.length; c++)
            {
                result.add(Character.toString(arr[c]));
            }
        
            //System.out.println(result);
            return result;
        }
        else 
        {
            List<String> newResult = new ArrayList<String>();
            
            for(char c=0; c < arr.length; c++)
            {
                for(String str : result)
                {
                    String newStr = str + Character.toString(arr[c]);
                    newResult.add(newStr);
                }
            }
            
            //System.out.println(newResult);
            return newResult;
            
        }
    }
}
