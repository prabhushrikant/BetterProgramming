package com.shrikant.problems.stacks;

import java.util.Stack;

//Program to have advanced stack so push(), pop() but also getMin() from stack in O(1) time.
//so that the function returns the lowest number from the current stack. 
//idea: use two stacks one to keep the actual numbers and other to keep the minimum from that level down, 
/* Algorithm 
   push(int n):
     - stack1.push(n);
     - peeked = stack2.peek();
     - stack2.push(peeked < n ? peeked : n);

   pop():
     - stack2.pop();
     - return stack1.pop();
   
   getMin():
     - return stack2.peek();
*/

//Follow up: how to have getMax() in O(1).
public class AdvancedStack extends Stack<Integer> {

  private Stack<Integer> minStack = new Stack<>();
  private Stack<Integer> maxStack = new Stack<>(); 
  private static final long serialVersionUID = 1L;

  @Override
  public Integer push(Integer n) {
    
    return n;
  }
    
}
