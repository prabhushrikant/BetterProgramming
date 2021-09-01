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
public class LongestPalindromSubStringTest {
    LongestPalindromeSubString testObj;

    private String input;
    private int expectedResult;
    private String palindrome;
    
    // constructor
    public LongestPalindromSubStringTest(String input, int expectedResult, String palindrome) {
        this.input = input;
        this.expectedResult = expectedResult;
        this.palindrome = palindrome;
    }

    @Before
    public void init() {
        testObj = new LongestPalindromeSubString();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { "babad", 3 , "bab"},
         { "cbbd", 2 , "bb"},
         { "a", 1 , "a"},
         { "baadaa", 5, "aadaa"},
         { "bada", 3, "ada"}
      });
   }

    @Test
    public void testLongestPalindromSubStringTest() {
        assertThat(testObj.longestPalindromeSubString(input), is(expectedResult));
    }

    @Test
    public void testGetLongestPalindromeString() {
        assertThat(testObj.getLongestPalindromeSubString(input), is(palindrome));
    }
}
