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
public class EquilibriumPointTest {

    EquilibriumPoint testObj;

    private int[] inputArray;
    private int expectedResult;

    // constructor
    public EquilibriumPointTest(int[] arr, int equilibriumPointIndex) {
        this.inputArray = arr;
        this.expectedResult = equilibriumPointIndex;
    }

    @Before
    public void init() {
        testObj = new EquilibriumPoint();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new int[] {1}, 0 },
         { new int[] {1, 3, 5, 2, 2}, 2 },
      });
   }



    @Test
    public void testEquilibriumPoint() {
        assertThat(expectedResult, is(testObj.equilibriumPoint(inputArray, inputArray.length)));
    }
}
