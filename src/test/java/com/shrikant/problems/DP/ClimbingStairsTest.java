package com.shrikant.problems.DP;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ClimbingStairsTest {
    ClimbingStairs testObj;

    private int input;
    private int expectedOutput;

    public ClimbingStairsTest(int input, int expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new ClimbingStairs();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { 1, 1},  
        { 2, 2},
        { 3, 3},
        { 4, 5},
        { 5, 8},
        { 6, 13}
      });
   }

   @Test
   public void testHowManyWaysToClimb() {
       assertThat(testObj.climbStairs(input), is(expectedOutput));
   }
}
