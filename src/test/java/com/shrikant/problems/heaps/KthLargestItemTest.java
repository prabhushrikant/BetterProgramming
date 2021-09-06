package com.shrikant.problems.heaps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class KthLargestItemTest {
    KthLargestItem testObj;
    private int[] input;
    private int k;
    private int expectedOutput;

    public KthLargestItemTest(int[] input, int k, int expectedOutput) {
        this.input = input;
        this.k = k;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new KthLargestItem();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { new int[] { 7, 10, 4, 3, 20, 15 }, 2 , 15},
            { new int[] { 7, 10, 4, 3, 20, 15 }, 100 , 20}
        });
    }

    @Test
    public void testKthLargestItem() {
        assertThat(testObj.getKthLargestItem(input, k), is(expectedOutput));
    }
}
