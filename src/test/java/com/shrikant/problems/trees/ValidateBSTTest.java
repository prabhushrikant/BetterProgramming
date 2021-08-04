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
public class ValidateBSTTest {
    ValidateBST testObj;

    private String input;
    private Boolean expectedOutput;

    public ValidateBSTTest(String input, Boolean expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new ValidateBST();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3", false },
        { "2 1 3", true },
        { "2 2 2", false},
        { "1 1", true},
        { "1 N 1", false},
        { "2147483647", true}
      });
   }

   @Test
   public void testValidateBST() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.isValidBST(root), is(expectedOutput));
   }
}
