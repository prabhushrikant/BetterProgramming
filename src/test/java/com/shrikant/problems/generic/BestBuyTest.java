package com.shrikant.problems.generic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BestBuyTest {
    BestBuy testObj;

    private int[] input;
    private int expectedOutput;

    public BestBuyTest(int[] input, int expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new BestBuy();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { new int[] {5,6,4,3,2,3,4,5}, 18},
        { new int[] {5,6,4,3,5,3,4,5}, 18},
        { new int[] {1,2,3,4}, 0},
        { new int[] {2,2,2,2,3,3,4,4}, 14}
      });
   }

   @Test
   public void testValidInputs() {
       assertThat(testObj.highestScore(input), is(expectedOutput));
   }
}
