package com.shrikant.problems.stacks;

//Actual solution is here: https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/ 

// // Given a string containing just the characters “)” and “(“, find the length of longest well formed parentheses substring. 

// // input: s = "(()"
// Output: 2

// Example 2:
// Input: s = ")()())"
// Output: 4 - "()()".

// Example 3:
// Input: s = “)(”
// Output: 0

// Example 4
// Input: s = “(())(()”
// Output: 4

// Example 5
// Input: s = “(()())()”
// Output: 8

//Assume : only one kinda of parenthesis () 
//use of stack
//opening bracket -> push
//closing bracket -> pop 

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        
        LongestValidParenthesis vmware = new LongestValidParenthesis();

        // System.out.println(vmware.getLongestParenthesis("(()"));
        // System.out.println(vmware.getLongestParenthesis("(())()"));
        // System.out.println(vmware.getLongestParenthesis(""));
        // System.out.println(vmware.getLongestParenthesis("(((("));
        // System.out.println(vmware.getLongestParenthesis("()((())"));
        // System.out.println(vmware.getLongestParenthesis("(()))()")); 
        // System.out.println(vmware.getLongestParenthesis("(())(()")); //doesn't work in this case
        // System.out.println(vmware.getLongestParenthesis(")()())"));
        // System.out.println(vmware.getLongestParenthesis("))"));
    }
      
    public int getLongestParenthesis(String str)
    {
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;
        int currLength = 0;
        int validEndIndex = -1;
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i] == '(')
            {
                stack.push(arr[i]);
            }
            else if (arr[i] == ')')
            {   //closing bracket.
                if (stack.isEmpty())
                {
                    //start new result.
                    currLength = 0;    
                }
                else {
                    stack.pop();
                    currLength += 2;
                    //check if this is continuous
                    if (validEndIndex > -1 && i - validEndIndex > 2)
                    {
                        currLength = 2;
                        validEndIndex = i;
                    }
                    if (currLength > maxLength)
                    {
                        maxLength = currLength;
                        validEndIndex = i;
                    }                        
                }
            }
        }
        
        return maxLength;
    }
}
