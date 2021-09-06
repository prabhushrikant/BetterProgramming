package com.shrikant.problems.graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NumberOfIslandsTest {
    NumberOfIslands testObj;

    private char[][] input;
    private int expectedResult;

    // constructor
    public NumberOfIslandsTest(char[][] input, int numberOfIslands) {
        this.input = input;
        this.expectedResult = numberOfIslands;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        {   new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}}, 1
        },            
      });
   }

   @Before
   public void init() {
        testObj = new NumberOfIslands();
   }

    @Test
    public void testNumberOfIslands() {
        assertThat(testObj.numIslands(input), is(expectedResult));
    }    
}
