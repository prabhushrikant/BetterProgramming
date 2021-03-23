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
public class HeightOfTreeTest {
    HeightOfTree testObj;

    private String input;
    private int expectedOutput;

    public HeightOfTreeTest(String input, int expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new HeightOfTree();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3", 1 },
        { "2 N 3 4 N", 2},
        { "1 2 3 4 5 6 7", 2},
        { "1 N 2 N 3 N 4", 3}
      });
   }

   @Test
   public void testHeightOfTree() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.getHeight(root), is(expectedOutput));
   }

   @Test
   public void testHeightOfTree2() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.getHeight2(root), is(expectedOutput));
   }
}
