package com.shrikant.problems.trees;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LeftViewOfATreeTest {
    
    LeftViewOfATree testObj;

    private String input;
    private String expectedOutput;

    public LeftViewOfATreeTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new LeftViewOfATree();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { "1 2 3", "[1, 2]" },
         { "4 5 2 N N 3 1 6 7", "[4, 5, 3, 6]"}
      });
   }

   @Test
   public void testLeftViewOfTheTree() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.leftView(root).toString(), is(expectedOutput));
   }
}
