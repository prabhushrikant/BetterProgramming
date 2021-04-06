package com.shrikant.problems.arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FourSumTest {

    FourSum testObj;

    private int[] inputArray;
    private int requiredSum;
    private String expectedResult;

    // constructor
    public FourSumTest(int[] arr, int sum, String fourSums) {
        this.inputArray = arr;
        this.requiredSum = sum;
        this.expectedResult = fourSums;
    }

    @Before
    public void init() {
        testObj = new FourSum();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new int[] {0, 0, 2, 1, 1}, 3, "[[0, 0, 1, 2]]" },
         { new int[] {10,2,3,4,5,7,8}, 23, "[[2, 4, 7, 10], [2, 3, 8, 10], [3, 5, 7, 8]]"},
      });
   }

   @Test
   public void testGetFourSums() {
       assertThat(testObj.fourSum(inputArray, requiredSum).toString(), is(expectedResult));
   }
}
