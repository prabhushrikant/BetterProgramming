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
public class VerticalViewOfTreeTest {
    VerticalViewOfTree testObj;

    private String input;
    private String expectedOutput;

    public VerticalViewOfTreeTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new VerticalViewOfTree();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { "1 2 3", "[2, 1, 3]" },
         { "2 N 3 4 N", "[2, 4, 3]"},
         { "1 2 3 4 5 6 7", "[4, 2, 1, 5, 6, 3, 7]"}
      });
   }

   @Test
   public void testVerticalViewOfTheTree() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.verticalOrder(root).toString(), is(expectedOutput));
   }
}
