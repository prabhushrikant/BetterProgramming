package com.shrikant.problems.strings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RomanToIntegerTest {
    RomanToInteger testObj;

    private String input;
    private int expectedOutput;

    public RomanToIntegerTest(String input, int expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new RomanToInteger();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "I", 1},
        { "III", 3},
        { "IV", 4},
        { "IX", 9},
        // { "VX", "invalid input"},
        { "LVIII", 58},
        { "MCMXCIV", 1994},
      });
   }

   @Test
   public void testValidInputs() {
       assertThat(testObj.convert(input), is(expectedOutput));
   }
}
