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
public class CommonPrefixTest {
    CommonPrefix testObj;

    private String[] input;
    private String expectedResult;
    
    // constructor
    public CommonPrefixTest(String[] input, String expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Before
    public void init() {
        testObj = new CommonPrefix();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new String[] {"flower","flow","flight"}, "fl" },
         { new String[] {"dog","racecar","car"}, ""}
      });
   }

    @Test
    public void testCommonPrefix() {
        assertThat(testObj.longestCommonPrefix(input), is(expectedResult));
    }
}
