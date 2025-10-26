package com.shrikant.problems.graphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeightedGraphTest {
    
    @ParameterizedTest
    @CsvSource({
        "'4 5,0 1 8,0 2 10,0 3 6,2 4 -1', '[(0,0), (1,8), (2,10), (3,6), (4,9)]'",
        "'7 5,0 1 4,0 2 1,2 1 2,1 3 1,2 3 5,3 4 3,1 4 7', '[(0,0), (1,3), (2,1), (3,4), (4,7)]'"
    })
    public void testGettingShortestPath(String inputStr, String expectedResultStr) {
        var inputList = new ArrayList<String>(Arrays.asList(inputStr.split(",")));
        var g = WeightedGraph.Build(inputList);
        var result = g.getShortestPath(0, g.v - 1);
        assertThat(result.toString(), is(expectedResultStr));
    }

    @ParameterizedTest
    @CsvSource({
        "'4 5,0 1 8,0 2 10,0 3 6,2 4 -1', '[(0,0), (1,14), (2,24), (3,6), (4,23)]'",
        "'7 5,0 1 4,0 2 1,2 1 2,1 3 1,2 3 5,3 4 3,1 4 7', '[(0,0), (1,3), (2,1), (3,4), (4,7)]'"
    })
    public void testGetMinSpanningTree(String inputStr, String expectedResultStr) {
        var inputList = new ArrayList<String>(Arrays.asList(inputStr.split(",")));
        var g = WeightedGraph.Build(inputList);
        var result = g.getMinSpanningTree();
        assertThat(result.toString(), is(expectedResultStr));
    }
}
