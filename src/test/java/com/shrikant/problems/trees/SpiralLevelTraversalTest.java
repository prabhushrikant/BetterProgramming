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
public class SpiralLevelTraversalTest {
    SpiralLevelTraversal testObj;

    private String input;
    private String expectedOutput;

    public SpiralLevelTraversalTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new SpiralLevelTraversal();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3", "[1, 2, 3]" },
        { "1 2 3 7 6 5 4", "[1, 2, 3, 4, 5, 6, 7]"},
        { "1 N 2 N 3 N 4", "[1, 2, 3, 4]"}
      });
   }

   @Test
   public void testSpiralLevelTraversal() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.findSpiral(root).toString(), is(expectedOutput));
   }

   @Test
   public void testSpiralLevelTraversalMethod2() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.findSpiral2(root).toString(), is(expectedOutput));
   }
}
