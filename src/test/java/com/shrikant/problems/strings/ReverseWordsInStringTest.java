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

public class ReverseWordsInStringTest {

    ReverseWordsInString testObj;

    private String input;
    private String expectedOutput;

    // constructor
    public ReverseWordsInStringTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new ReverseWordsInString();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { "hello.world", "world.hello" },
         { "wow", "wow" },
      });
   }

    @Test
    public void testReverseInputStringWords() {
        assertThat(testObj.reverseWords(input), is(expectedOutput));
    }
    
}
