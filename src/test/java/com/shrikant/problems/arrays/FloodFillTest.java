package com.shrikant.problems.arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FloodFillTest {
    FloodFill testObj;

    private int[][] inputArray;
    private int startRow;
    private int startCol;
    private int newColor;
    private int[][] expectedResult;

    // constructor
    public FloodFillTest(int[][] image, int sc, int sr, int newColor, int[][] filledImage) {
        this.inputArray = image;
        this.expectedResult = filledImage;
        this.startRow = sr;
        this.startCol = sc;
        this.newColor = newColor;
    }

    @Before
    public void init() {
        testObj = new FloodFill();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2, new int[][] {{2,2,2},{2,2,0},{2,0,1}} },
        { new int[][] {{2, 1, 2, 1, 3}, {2, 3, 3, 3, 2}, {2, 3, 1, 3, 2}, {1, 2, 3, 2, 2}}, 
            0,
            0,
            1, 
            new int[][] {{1, 1, 2, 1, 3}, {1, 3, 3, 3, 2}, {1, 3, 1, 3, 2}, {1, 2, 3, 2, 2}} 
        },
      });
   }



    @Test
    public void testTomotoesRotting() {
        int[][] actual = testObj.floodFill(inputArray, startRow, startCol, newColor);
        assertThat(actual.length, is(expectedResult.length));
        assertThat(actual[0].length, is(expectedResult[0].length));
        for(int i = 0; i < actual.length; i++)
            for(int j = 0; j < actual[0].length; j++) 
            {
                assertThat(actual[i][j], is(expectedResult[i][j]));
            }
    }
}
