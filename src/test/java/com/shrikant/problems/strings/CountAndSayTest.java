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
public class CountAndSayTest {

    CountAndSay testObj;

    private int input;
    private String expectedResult;
    
    // constructor
    public CountAndSayTest(int input, String expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Before
    public void init() {
        testObj = new CountAndSay();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { 1, "1" },
         { 2, "11"},
         { 3, "21"},
         { 4, "1211"},
         { 5, "111221"},
         { 6, "312211"}
      });
   }

    @Test
    public void testCountAndSay() {
        assertThat(testObj.countAndSay(input), is(expectedResult));
    }
}
