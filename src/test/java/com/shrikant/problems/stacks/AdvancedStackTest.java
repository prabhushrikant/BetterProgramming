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
public class AdvancedStackTest {
    private List<Integer> input;
    private int expectedResult;

    public AdvancedStackTest(List<Integer> input, int minValue) {
        this.input = input;
        this.expectedResult = minValue;
    }

    @Before
    public void init() {
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { Arrays.asList(2, 1, 6, 5, 0, 1), 0},
            { Arrays.asList(2, 1, 6, 5), 1},
            { Arrays.asList(2), 2},
          });
    }

   @Test
   public void testShowMin() {
       AdvancedStack<Integer> advStack = new AdvancedStack<>(this.input);
       assertThat(advStack.getMin(), is(expectedResult));
   }
}
