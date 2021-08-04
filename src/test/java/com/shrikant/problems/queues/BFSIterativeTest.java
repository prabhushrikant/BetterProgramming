package com.shrikant.problems.queues;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import com.shrikant.problems.trees.Node;
import com.shrikant.problems.trees.Tree;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BFSIterativeTest {

    BFSIterative testObj;

    private String input;
    private String expectedOutput;

    public BFSIterativeTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new BFSIterative();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3", "[[1], [2, 3]]" },
        { "1 2 N 3 N 4 N 5", "[[1], [2], [3], [4], [5]]"},
        { "1 N 2 N 3 N 4 N 5", "[[1], [2], [3], [4], [5]]"},
        { "", "[]"},
        { "1", "[[1]]"}
      });
   }

   @Test
   public void testBFSIterative() {
       Node root = Tree.buildTree(input);
       assertThat(testObj.levelOrder(root).toString(), is(expectedOutput));
   }
}
