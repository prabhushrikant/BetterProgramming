package com.shrikant.problems.graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TopologicalSortTest {

    TopologicalSort testObj;

    private List<String> input;
    private String expectedResult;
    private boolean isDAG;

    // constructor
    public TopologicalSortTest(List<String> input, String topologicalSort, boolean isDAG) {
        this.input = input;
        this.expectedResult = topologicalSort;
        this.isDAG = isDAG;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new ArrayList<String>(Arrays.asList("4 4", "3 0", "1 0", "2 0", "2 3")), "[2, 3, 1, 0]", true}, 
         { new ArrayList<String>(Arrays.asList(
             "6 6", 
             "5 0", 
             "5 2", 
             "2 3",
             "4 0",
             "4 1",
             "1 3")), "[5, 4, 2, 1, 3, 0]", true},
        { new ArrayList<String>(Arrays.asList(
             "9 8",
             "7 6",
             "6 4",
             "5 4",
             "5 2",
             "4 3",
             "2 3",
             "3 1",
             "1 0")), "[7, 6, 5, 4, 2, 3, 1, 0]", true},
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

    @Test
    public void testIsDagTrue() {
        assertThat(testObj.isDAG(), is(isDAG));
    }

    // run this test separately in a different class since this class is run with parameterized runner
    // @Test
    // public void testIsDagFalse() {
    //     var myInput = new ArrayList<String>(Arrays.asList(
    //         "3 3",
    //         "0 1",
    //         "1 2",
    //         "2 0"));
    //     var g = Graph.Build(myInput);
    //     var testObj = new TopologicalSort(g);
    //     assertThat(testObj.isDAG(), is(false));
    // }
}
