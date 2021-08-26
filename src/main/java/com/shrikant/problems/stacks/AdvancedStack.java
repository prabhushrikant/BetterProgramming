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

//Second solution
//you can have Stack of type StackNode where node has pointer to minimum value below it.

//Follow up: how to have getMax() in O(1).
public class AdvancedStack extends Stack<Integer> {

  private Stack<Integer> minStack = new Stack<>();
  // private Stack<Integer> maxStack = new Stack<>();
  private static final long serialVersionUID = 1L;

  @Override
  public Integer push(Integer n) {
    //fill up minstack
    if (!minStack.isEmpty())
    {
      Integer minPeeked = minStack.peek();
      if (n < minPeeked)
      {
        minStack.push(n);
      }
    } 
    else {
      minStack.push(n);
    }

    return super.push(n);
  }

  @Override
  public Integer pop() {
    //respectively also remove item from minstack
    if (!minStack.isEmpty())
    {
      minStack.pop();
    }

    return super.pop();
  }

  public Integer getMin() {
    return this.minStack.peek();
  }
    
}
