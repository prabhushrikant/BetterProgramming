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
public class ParenthesisCheckerTest {

    ParenthesisChecker testObj;

    private String input;
    private boolean expectedResult;

    // constructor
    public ParenthesisCheckerTest(String input, boolean equilibriumPointIndex) {
        this.input = input;
        this.expectedResult = equilibriumPointIndex;
    }

    @Before
    public void init() {
        testObj = new ParenthesisChecker();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { "[()]{}{[()()]()}", true },
         { "[(])", false },
         { ")", false }, // EDGE CASE
         { "(", false } // EDGE CASE
      });
   }



    @Test
    public void testEquilibriumPoint() {
        assertThat(testObj.isBalanced(input), is(expectedResult));
    }
}
