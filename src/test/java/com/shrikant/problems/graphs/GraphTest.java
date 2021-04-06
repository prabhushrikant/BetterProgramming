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

    private List<Pair> input;
    private String expectedResult;

    // constructor
    public GraphTest(List<String> input, String dfsTraversal) {
        this.input = processInput(input);
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

    private List<Pair> processInput(List<String> input) {
        List<Pair> result = new ArrayList<Pair>();
        for(int i=0; i < input.size(); i++) {
            String arr[] = input.get(i).split(" ");
            Pair p = new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            result.add(p);
        }

        return result;
    }
}
