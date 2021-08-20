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
public class IsGivenNumPowOfAnotherNumTest {
    IsGivenNumPowOfAnotherNum testObj;

    private int input1;
    private int input2;
    private boolean expectedOutput;

    public IsGivenNumPowOfAnotherNumTest(int n, int p, boolean expectedOutput)
    {
        this.input1 = n;
        this.input2 = p;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new IsGivenNumPowOfAnotherNum();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        {27, 3, true},
        {27, 2, false},
        {16, 2, true},
        {30, 2, false}
      });
   }

   @Test
   public void testValidInputs() {
       assertThat(testObj.isPowerOf(input1, input2), is(expectedOutput));
   }
}
