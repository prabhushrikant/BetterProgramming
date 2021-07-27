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
public class ReverseAnIntegerTest {

    ReverseAnInteger testObj;

    private int input;
    private int expectedResult;

    // constructor
    public ReverseAnIntegerTest(long input, int equilibriumPointIndex) {
        this.input = (int)input;
        this.expectedResult = equilibriumPointIndex;
    }

    @Before
    public void init() {
        testObj = new ReverseAnInteger();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { 0, 0 },
         { 123, 321},
         { -123, -321},        
        //  { -2147483649, 0},
        //  { 2147483648, 0},         
      });
   }

    @Test
    public void testReverseAnInteger() {
        assertThat(testObj.reverseInteger(input), is(expectedResult));
    }
}
