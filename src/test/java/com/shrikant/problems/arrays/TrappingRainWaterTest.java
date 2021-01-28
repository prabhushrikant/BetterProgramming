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
public class TrappingRainWaterTest {

    TrappingRainWater testObj;

    private int[] inputArray;
    private int expectedResult;

    // constructor
    public TrappingRainWaterTest(int[] arr, int expectedTrappedWater) {
        this.inputArray = arr;
        this.expectedResult = expectedTrappedWater;
    }

    @Before
    public void init() {
        testObj = new TrappingRainWater();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new int[] {2, 0, 2}, 2 },
         { new int[] {3, 0, 2, 0, 4}, 7 },
         { new int[] {2, -1, 2}, 3 },
         { new int[] {-3, -1, 2}, 4 },
         { new int[] {-3, -1, -2}, 6 },
         { new int[] {-3, 2, 2}, 3 },
         { new int[] {3, -2, 2, 0, 4, -1}, 10 },
      });
   }



    @Test
    public void testTrappingRainWaterWithDips() {
        assertThat(expectedResult, is(testObj.trappingWater(inputArray, inputArray.length)));
    }
}
