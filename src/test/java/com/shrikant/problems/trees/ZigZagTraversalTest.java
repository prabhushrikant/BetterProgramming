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
public class ZigZagTraversalTest {
    ZigZagTraversal testObj;

    private String input;
    private String expectedOutput;

    public ZigZagTraversalTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new ZigZagTraversal();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "3 9 20 N N 15 7", "[[3], [20, 9], [15, 7]]" }
      });
   }

   @Test
   public void testValidateBST() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.zigzagLevelOrder(root).toString(), is(expectedOutput));
   }
}
