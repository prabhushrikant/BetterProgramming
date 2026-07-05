package com.shrikant.problems.stacks;

import java.util.Stack;

// A monotonic stack is a special type of stack in which all elements on the stack are sorted in either 
// descending or ascending order. The ordering can be strict (no duplicates allowed) or 
// non-strict (duplicates allowed), which variant you use depends on the problem. In most problems, 
// including the ones below, a non-strict monotonic stack works. It is used to solve problems that 
// require finding the next greater or next smaller element in an array. If such a number doesn't exist, 
// we can return -1 or any other value that is specified in the problem.

public class MonotonicStack {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 12, 3};
        MonotonicStack monotonicStack = new MonotonicStack();

        // print the array after
        int[] result = monotonicStack.monotonicIncreasingStack(nums);
        System.out.println("\nMonotonic Increasing Stack:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        // print the array after
        result = monotonicStack.monotonicDecreasingStack(nums);
        System.out.println("\nMonotonic Decreasing Stack:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    /**
     * Given an array of integers, find the next smaller element for each element in the array.
     * The next smaller element of an element x is the first element to the right of x that is smaller than x.
     * If there is no such element, then the next smaller element is -1.    
     * Example
     * Input: [2, 1, 3, 2, 4, 3]
     * Output: [1, -1, 2, -1, 3, -1]
     */
    public int[] monotonicIncreasingStack(int[] nums) {
        //stack is storing the index of the elements in the array.
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        java.util.Arrays.fill(result, -1);
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * Given an array of integers, find the next greater element for each element in the array.
     * The next greater element of an element x is the first element to the right of x that is greater than x.
     * If there is no such element, then the next greater element is -1.
     * Example
     * Input: [2, 1, 3, 2, 4, 3]
     * Output: [3, 3, 4, 4, -1, -1]
     */
    public int[] monotonicDecreasingStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        java.util.Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}
