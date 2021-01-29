package com.shrikant.problems.arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

//todo: Convert into parameterized test.
public class KadaneTest {

    Kadane testObj;

    @Before
    public void init() {
        testObj = new Kadane();
    }
    
    @Test
    public void test_all_positive_numbers() {
  
        int[] arr = new int[] {1, 2, 3, 0, 5};
        assertThat(11, is(testObj.maxSubarraySum(arr, arr.length)));

    }

    @Test
    public void test_all_negative_numbers() {
  
        int[] arr = new int[] {-1, -2, -3, -4};
        assertThat(-1, is(testObj.maxSubarraySum(arr, arr.length)));

    }

    @Test
    public void test_max_subarray_is_in_middle_numbers() {
  
        int[] arr = new int[] {2, -5, 1, 9, 0, -4};
        assertThat(10, is(testObj.maxSubarraySum(arr, arr.length)));

    }

    @Test
    public void test_something_random() {
  
        int i = 9;
        int result = i++;
        assertThat(result, is(10));
    }


}
