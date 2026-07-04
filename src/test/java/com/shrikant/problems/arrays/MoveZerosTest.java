package com.shrikant.problems.arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

public class MoveZerosTest {
    
    MoveZeros testObj;

    @BeforeEach
    public void init() {
        testObj = new MoveZeros();
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "0,1,0,12,3; 1,12,3,0,0",
        "1,2,3; 1,2,3",
        "0,0,0; 0,0,0",
        "4,5,6; 4,5,6"
    })
    public void testMoveAllZeroesToEnd(String input, String expected) {
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] expectedArray = Arrays.stream(expected.split(",")).mapToInt(Integer::parseInt).toArray();
        
        assertThat(testObj.moveAllZeroesToEnd(inputArray), is(expectedArray));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "0,1,0,12,3; 0,0,1,12,3",
        "1,2,3; 1,2,3",
        "0,0,0; 0,0,0",
        "4,5,6; 4,5,6"
    })
    public void testMoveAllZeroesToFront(String input, String expected) {
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] expectedArray = Arrays.stream(expected.split(",")).mapToInt(Integer::parseInt).toArray();
        
        assertThat(testObj.moveAllZeroesToFront(inputArray), is(expectedArray));
    }        

}
