package com.shrikant.problems.stacks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LongestValidParenthesisTest {
    LongestValidParenthesis testObj;

    private String input;
    private int expectedOutput;

    public LongestValidParenthesisTest(String input, int expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new LongestValidParenthesis();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "(()", 2 },
        { "(())()", 6 },
        { "((((", 0 },
        { "))", 0 },
        { "()((())", 4},
        { "(()))()", 4},
        { "(())(()", 4},
        { ")()())", 4},
        { "()()()", 6},
        { "(())((((())))", 8},
      });
   }

   @Test
   public void testLongestValidParenthesisStringLength() {
       assertThat(testObj.getLongestParenthesis(input), is(expectedOutput));
   }
}
