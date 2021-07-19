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
public class ValidateSuDoKuTest {
    ValidateSuDoKu testObj;

    private int[][] inputArray;
    private boolean expectedResult;

    public ValidateSuDoKuTest(int[][] board, boolean isValid) {
        this.inputArray = board;
        this.expectedResult = isValid;
    }

    @Before
    public void init() {
        testObj = new ValidateSuDoKu();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {
                new int[][] {
                     {5,3,-1,-1,7,-1,-1,-1,-1}
                    ,{6,-1,-1,1,9,5,-1,-1,-1}
                    ,{-1,9,8,-1,-1,-1,-1,6,-1}
                    ,{8,-1,-1,-1,6,-1,-1,-1,3}
                    ,{4,-1,-1,8,-1,3,-1,-1,1}
                    ,{7,-1,-1,-1,2,-1,-1,-1,6}
                    ,{-1,6,-1,-1,-1,-1,2,8,-1}
                    ,{-1,-1,-1,4,1,9,-1,-1,5}
                    ,{-1,-1,-1,-1,8,-1,-1,7,9}
                    }, 
                true
            },
            {
                new int[][] {
                     {8,3,-1,-1,7,-1,-1,-1,-1}
                    ,{6,-1,-1,1,9,5,-1,-1,-1}
                    ,{-1,9,8,-1,-1,-1,-1,6,-1}
                    ,{8,-1,-1,-1,6,-1,-1,-1,3}
                    ,{4,-1,-1,8,-1,3,-1,-1,1}
                    ,{7,-1,-1,-1,2,-1,-1,-1,6}
                    ,{-1,6,-1,-1,-1,-1,2,8,-1}
                    ,{-1,-1,-1,4,1,9,-1,-1,5}
                    ,{-1,-1,-1,-1,8,-1,-1,7,9}
                    }, 
                false
            }
        });
    }

    @Test
    public void testValidateSuDoKu() {
        assertThat(testObj.validateSoDoKu(inputArray), is(expectedResult));
    }
}
