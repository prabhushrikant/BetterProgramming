package com.shrikant.problems.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ParenthesisChecker {

    HashMap<Character,Character> openingBrackets = new HashMap<>();
    HashSet<Character> closingBrackets = new HashSet<>();
    Stack<Character> stack = new Stack<>();

    ParenthesisChecker() {
        openingBrackets.put('[', ']');
        openingBrackets.put('(', ')');
        openingBrackets.put('{', '}');
        openingBrackets.put('<', '>');

        closingBrackets.addAll(Arrays.asList(']', ')', '}', '>'));
    }
    
    public boolean isBalanced(String x)
    {
        // add your code here
        char[] arr = x.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (openingBrackets.containsKey(arr[i])) {
                stack.push(arr[i]);
            } else if (closingBrackets.contains(arr[i])) {
                if (stack.isEmpty())
                    return false;
                char popped = stack.pop();
                if (!openingBrackets.containsKey(popped) || openingBrackets.get(popped) != arr[i]) {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty())
            return false;
        return true;
    }
}
