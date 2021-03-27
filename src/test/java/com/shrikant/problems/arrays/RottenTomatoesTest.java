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
public class RottenTomatoesTest {
    RottenTomatoes testObj;

    private int[][] inputArray;
    private int expectedResult;

    // constructor
    public RottenTomatoesTest(int[][] grid, int timeToRotTheWhole) {
        this.inputArray = grid;
        this.expectedResult = timeToRotTheWhole;
    }

    @Before
    public void init() {
        testObj = new RottenTomatoes();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new int[][] {{2,2,0,1}}, -1 },
         { new int[][] {{0,1,2},{0,1,2},{2,1,1}}, 1 },
      });
   }



    @Test
    public void testTomotoesRotting() {
        assertThat(testObj.tomotoesRotting(inputArray), is(expectedResult));
    }
}
