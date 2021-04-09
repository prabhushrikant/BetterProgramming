package com.shrikant.problems.graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class GraphTest {

    private List<String> input;
    private String expectedResult;

    // constructor
    public GraphTest(List<String> input, String dfsTraversal) {
        this.input = input;
        this.expectedResult = dfsTraversal;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        //  { new ArrayList<String>(Arrays.asList("3 4", "3 0", "1 0", "2 0")), "[0, 1, 2, 3]"}, 
         { new ArrayList<String>(Arrays.asList(
             "6 6", 
             "5 0", 
             "5 2", 
             "2 3",
             "4 0",
             "4 1",
             "1 3")), "[0, 1, 3, 2, 4, 5]"},     
      });
        
   }

    @Test
    public void testCreatingGraph() {
        assertThat(Graph.Build(input).dfs().toString(), is(expectedResult));
    }

    @Test
    public void testBFS() {
        var input = new ArrayList<String>(Arrays.asList("4 5", "0 1", "0 2", "0 3", "2 4"));
        var expectedResult = "[0, 1, 2, 3, 4]";
        var g = Graph.Build(input);
        assertThat(g.bfs().toString(), is(expectedResult));
    }
}
