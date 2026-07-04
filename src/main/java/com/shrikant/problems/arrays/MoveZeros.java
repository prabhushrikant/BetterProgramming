package com.shrikant.problems.arrays;

//https://leetcode.com/problems/move-zeroes/

public class MoveZeros {
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 12, 3};
        MoveZeros moveZeros = new MoveZeros();
        
        // print the array after moving zeros to end
        nums = moveZeros.moveAllZeroesToEnd(nums);
        System.out.println("\nArray after moving zeros to end:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        // print the array after moving zeros to front
        nums = moveZeros.moveAllZeroesToFront(nums);
        System.out.println("\nArray after moving zeros to front:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public int[] moveAllZeroesToEnd(int[] nums) {
        int n = nums.length;
        int count = 0; // Count of non-zero elements

        // Traverse the array. If element encountered is non-zero, then
        // replace the element at index 'count' with this element
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i]; // here count is incremented
            }
        }

        // Now all non-zero elements have been shifted to front and 'count' is
        // set as index of first 0. Make all elements 0 from count to end.
        while (count < n) {
            nums[count++] = 0;
        }
        return nums;
    }

    public int[] moveAllZeroesToFront(int[] nums) {
        int n = nums.length;
        int count = n-1; // Count of non-zero elements

        // Traverse the array. If element encountered is non-zero, then
        // replace the element at index 'count' with this element
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] != 0) {
                nums[count--] = nums[i]; // here count is decremented
            }
        }

        // Now all non-zero elements have been shifted to end and 'count' is
        // set as index of first 0 from left. Make all elements 0 from beginning till count.
        while (count >= 0) {
            nums[count--] = 0;
        }
        return nums;
    }
}
