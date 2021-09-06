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
public class TopKFrequentItemsTest {
    TopKFrequentItems testObj;
    private int[] input;
    private int k;
    private int[] expectedOutput;

    public TopKFrequentItemsTest(int[] input, int k, int[] expectedOutput) {
        this.input = input;
        this.k = k;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new TopKFrequentItems();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { new int[] { 1,1,1,2,2,3 }, 2 , new int[] {1,2}},
            { new int[] { 1 }, 1 , new int[] {1}}
        });
    }

    @Test
    public void testKthLargestItem() {
        assertThat(testObj.topKFrequent(input, k), is(expectedOutput));
    }
}
