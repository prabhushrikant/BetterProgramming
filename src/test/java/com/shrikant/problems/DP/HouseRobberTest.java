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
public class HouseRobberTest {
    HouseRobber testObj;

    private int[] input;
    private int expectedOutput;

    public HouseRobberTest(int[] input, int expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new HouseRobber();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { new int[] {1,2,3,1}, 4},
        { new int[] {2,7,9,3,1}, 12},
        { new int[] {2,1,1,4}, 6}
      });
   }

   @Test
   public void testRobValue() {
       assertThat(testObj.rob(input), is(expectedOutput));
   }
}
