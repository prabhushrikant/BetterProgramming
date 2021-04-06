package com.shrikant.problems.graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TopologicalSortTest {

    TopologicalSort testObj;

    private List<String> input;
    private String expectedResult;

    // constructor
    public TopologicalSortTest(List<String> input, String topologicalSort) {
        this.input = input;
        this.expectedResult = topologicalSort;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new ArrayList<String>(Arrays.asList("3 4", "3 0", "1 0", "2 0")), "[3, 2, 1, 0]"}, 
         { new ArrayList<String>(Arrays.asList(
             "6 6", 
             "5 0", 
             "5 2", 
             "2 3",
             "4 0",
             "4 1",
             "1 3")), "[5, 4, 2, 1, 3, 0]"},     
      });
   }

   @Before
   public void init() {
        Graph g = Graph.Build(input);
        testObj = new TopologicalSort(g);
   }

    @Test
    public void testTopologicalSort() {
        assertThat(testObj.topologicalSort().toString(), is(expectedResult));
    }
}
