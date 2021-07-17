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
public class RotateArrayByKTest {
    
    RotateArrayByK testObj;

    private int[] inputArray;
    private int k;
    private int[] expectedResult;

    // constructor
    public RotateArrayByKTest(int[] arr, int k, int[] rotatedArray) {
        this.inputArray = arr;
        this.k = k;
        this.expectedResult = rotatedArray;
    }

    @Before
    public void init() {
        testObj = new RotateArrayByK();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new int[] {1, 2, 3}, 2, new int[] {2, 3, 1} },
         { new int[] {1}, 2, new int[] {1} },
         { new int[] {1, 2, 3}, 3, new int[] {1, 2, 3} },
         { new int[] {1, 2, 3}, 12, new int[] {1, 2, 3} },
         { new int[] {1, 2, 3, 4, 5, 6}, 3, new int[] {4, 5, 6, 1, 2, 3} }
      });
    }

    @Test
    public void testRotateArrayByK() {
        assertThat(testObj.rotateArrayByK(inputArray, k), is(expectedResult));
    }
}
