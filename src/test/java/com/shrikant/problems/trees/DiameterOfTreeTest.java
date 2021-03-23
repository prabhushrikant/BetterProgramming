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
public class DiameterOfTreeTest {
    DiameterOfTree testObj;

    private String input;
    private int expectedOutput;

    public DiameterOfTreeTest(String input, int expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new DiameterOfTree();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] { 
        { "1 2 3", 3 },
        { "5 5 N 4 10 N 8 5 N 8 8 N 6", 7 },
        { "25" , 1} //EDGE CASE
        // { "3 4 5 -10 4", 16},
        // { "1 2 3 4 5 6 7", 18},
        // { "1 2 3 N N 4 6 N 5 N N 7 N", 25},
        // { "-15 5 6 -8 1 3 9 2 -3 N N N N N N", 18},
        // { "1 N 2", Integer.MIN_VALUE },   //EDGE CASE
        // { "1 2 N", Integer.MIN_VALUE },   //EDGE CASE  
        // { "1 N 2 N 3", Integer.MIN_VALUE },  //EDGE CASE
        // { "1 2 3 N N N 4 N N", 10},
        // { "-15 5 6 -8 1 3 9 2 -3 N N N N N 0 N N N N 4 -1 N N 10 N", 27},
        // {"-10 -4 -10 -3 -2 10 -7 5 -1 N -10 -6 -6 10 8 -3 0 5 4 N -7 5", 11}
      });
   }

   @Test
   public void testConvertToDLL() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.diameter(root), is(expectedOutput));
   }
}
