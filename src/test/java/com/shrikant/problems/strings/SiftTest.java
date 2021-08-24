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
public class SiftTest {
    Sift testObj;

    private String input1;
    private String input2;
    private boolean expectedOutput;

    public SiftTest(String s1, String s2, boolean expectedOutput)
    {
        this.input1 = s1;
        this.input2 = s2;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new Sift();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        {"is", "sift", true},
        {"ad", "fraud", false},
        {"sii", "ssift", false},
        {"sii", "siift", true}
      });
   }

   @Test
   public void testContainment() {
       assertThat(testObj.check(input1, input2), is(expectedOutput));
   }
}
