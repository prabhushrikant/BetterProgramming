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
public class ViewsOfATreeTest {
    
    ViewsOfATree testObj;

    private String input;
    private String expectedLeftOutput;
    private String expectedRightOutput;

    public ViewsOfATreeTest(String input, String expectedLeftOutput, String expectedRightOutput)
    {
        this.input = input;
        this.expectedLeftOutput = expectedLeftOutput;
        this.expectedRightOutput = expectedRightOutput;
    }

    @Before
    public void init() {
        testObj = new ViewsOfATree();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { "1 2 3", "[1, 2]", "[1, 3]" },
         { "4 5 2 N N 3 1 6 7", "[4, 5, 3, 6]", "[4, 2, 1, 7]"}
      });
   }

   @Test
   public void testLeftViewOfTheTree() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.leftView(root).toString(), is(expectedLeftOutput));
   }

   @Test
    public void testLeftViewOfTheTreeBfs() {
         Node root = Tree.buildTree(input);
         assertThat(testObj.leftViewBfs(root).toString(), is(expectedLeftOutput));
    }

    @Test
    public void testRightViewOfTheTreeBfs() {
         Node root = Tree.buildTree(input);
         assertThat(testObj.rightViewBfs(root).toString(), is(expectedRightOutput));
    }
}
