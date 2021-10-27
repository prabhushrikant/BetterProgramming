package com.shrikant.problems.stacks;

import java.util.Stack;
import java.util.List;

//Program to have advanced stack so push(), pop() but also getMin() from stack in O(1) time.
//so that the function returns the lowest number from the current stack. 
//idea: use two stacks one to keep the actual numbers and other to keep the minimum from that level down,
//OPTIMIZATION (Space):  you don't have to keep minStack as high as original stack but 
//only push the value when new value is smaller and remove value from min stack when it's same.
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
public class AdvancedStack<T extends Comparable<? super T>> extends Stack<T> {

  private Stack<T> minStack = new Stack<>();
  // private Stack<Integer> maxStack = new Stack<>();

  public AdvancedStack(List<T> input)
  {
    for(T i : input)
    {
      push(i);
    }
  }

  @Override
  public T push(T n) {
    //fill up minstack
    if (!minStack.isEmpty())
    {
      T minPeeked = minStack.peek();
      if (n.compareTo(minPeeked) < 0)
      {
        minStack.push(n);
      }
      //OPTIMIZATION: Non need to have else here, i.e. 
      //Don't push same value again over on minstack.  
    } 
    else 
    {
      //put first value on both stacks.
      minStack.push(n);
    }

    return super.push(n);
  }

  @Override
  public T pop() {
    //respectively also remove item from minstack
    if (!minStack.isEmpty())
    {
      //OPTIMIZATION : Because both stacks won't be of same size, we need to remove
      //item from min stack only when it's same.
      if (minStack.peek().compareTo(super.peek()) == 0)
      {
        minStack.pop();
      }       
    }
    return super.pop();
  }

  public T getMin() {
    return this.minStack.peek();
  }
    
}
