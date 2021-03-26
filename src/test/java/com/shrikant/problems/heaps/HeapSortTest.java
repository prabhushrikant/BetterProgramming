package com.shrikant.problems.heaps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HeapSortTest {
    HeapSort testObj;
    private int[] input;
    private int[] expectedOutput;

    public HeapSortTest(int[] input, int[] expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        HashMap<Character,Character> openingBrackets = new HashMap<>();
        openingBrackets.put('[', ']');
        openingBrackets.put('(', ')');
        openingBrackets.put('{', '}');
        openingBrackets.put('<', '>');
    }

    @Before
    public void init() {
        testObj = new HeapSort();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] { { new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 } },
                { new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 } }, });
    }

    @Test
    public void testHeapSort() {
        assertThat(testObj.heapSort(input, input.length), is(expectedOutput));
    }
}
