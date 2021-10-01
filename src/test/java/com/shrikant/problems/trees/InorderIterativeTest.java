package com.shrikant.problems.trees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class InorderIterativeTest {
    InorderIterative testObj;

    private String input;
    private String expectedOutput;

    public InorderIterativeTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new InorderIterative();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] { 
        { "1 2 3", "[2, 1, 3]" },
        { "1 N 2 N 3", "[1, 2, 3]" }
      });
   }

   @Test
   public void testConvertToDLL() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.inorderIterative(root).toString(), is(expectedOutput));
   }
}
