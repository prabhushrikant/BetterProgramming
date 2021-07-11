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
public class NonRepeatingElementTest {

    NonRepeatingElement testObj;

    private int[] inputArray;
    private int expectedResult;

    // constructor
    public NonRepeatingElementTest(int[] arr, int equilibriumPointIndex) {
        this.inputArray = arr;
        this.expectedResult = equilibriumPointIndex;
    }

    @Before
    public void init() {
        testObj = new NonRepeatingElement();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         //{ new int[] {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}, 4 },
         { new int[] {-96, -96, -93, -93, -80, -80, -77, -77, -56, -56, -43, -43, -30, -30, -29, -29, -14, -14, -10, -10, 8, 8, 29, 29, 30, 30, 38, 44, 44, 46, 46, 79, 79, 87, 87, 88, 88, 94, 94}, 
         38},

      });
   }

    @Test
    public void testEquilibriumPoint() {
        assertThat(testObj.findOnce(inputArray, inputArray.length), is(expectedResult));
    }
}
