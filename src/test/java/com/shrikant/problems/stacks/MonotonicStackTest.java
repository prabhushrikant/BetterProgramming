package com.shrikant.problems.stacks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

public class MonotonicStackTest {

    MonotonicStack testObj;

    @BeforeEach
    public void init() {
        testObj = new MonotonicStack();
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "2,1,3,2,4,3; 1,-1,2,-1,3,-1",
        "5,4,3,2,1; 4,3,2,1,-1",
        "1,2,3,4,5; -1,-1,-1,-1,-1",
        "3,3,3; -1,-1,-1"
    })
    public void testMonotonicIncreasingStack(String input, String expected) {
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] expectedArray = Arrays.stream(expected.split(",")).mapToInt(Integer::parseInt).toArray();
        
        assertThat(testObj.monotonicIncreasingStack(inputArray), is(expectedArray));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "2,1,3,2,4,3; 3,3,4,4,-1,-1",
        "5,4,3,2,1; -1,-1,-1,-1,-1",
        "1,2,3,4,5; 2,3,4,5,-1",
        "3,3,3; -1,-1,-1"
    })  
    public void testMonotonicDecreasingStack(String input, String expected) {
        int[] inputArray = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] expectedArray = Arrays.stream(expected.split(",")).mapToInt(Integer::parseInt).toArray();
        
        assertThat(testObj.monotonicDecreasingStack(inputArray), is(expectedArray));
    }
}
