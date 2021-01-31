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

public class RemoveAdjascentDuplicateCharsTest {

    RemoveAdjascentDuplicateChars testObj;

    private String input;
    private String expectedOutput;

    // constructor
    public RemoveAdjascentDuplicateCharsTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new RemoveAdjascentDuplicateChars();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         {"geeksforgeek", "gksforgk" },
         {"geeksforgeee", "gksforg" },
         {"geeksforgeeg", "gksfor" },
         {"keek", ""},
         {"azxxzy", "ay"},
         {"azxxza", ""},
         {"caaabbbaacdddd", ""},
         {"acaaabbbacdddd", "acac"},
         {"acbbcddc", "ac"}
      });
   }

    @Test
    public void testRemoveAdjDuplicates() {
        assertThat(testObj.removeAdjDuplicateChars(input), is(expectedOutput));
    }
    
}
