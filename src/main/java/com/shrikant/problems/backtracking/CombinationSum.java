package com.shrikant.problems.backtracking;

import java.util.List;

//https://practice.geeksforgeeks.org/problems/combination-sum-part-21208/1

//we need to sort the given array, since we don't need subarray 
//trick is add the next element in array, do recursion from that element onwards and reduced sum till sum == 0 , if sum becomes -ve discard the element.
//once done, backtrack, meaning remove that element from the result go for next of next and so on.
public class CombinationSum {

    public List<List<Integer>> combinationSum(int a[], int N, int Sum) {

        return null;
    }
}
