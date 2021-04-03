package com.shrikant.problems.linkedlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BreakLoopIfExistsTest {
    BreakLoopIfExists testObj;

    private String input;
    private int loopPosition;
    private String expectedOutput;

    public BreakLoopIfExistsTest(String input, int k, String expectedOutput)
    {
        this.input = input;
        this.loopPosition = k;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new BreakLoopIfExists();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3", 2, "[1, 2, 3]" },
        { "1 2 3", 1, "[1, 2, 3]" }, //circular list (RING), EDGE CASE
      });
   }

   @Test
   public void testBreakLoopIfExists() {
       ListNode head = SinglyLinkedList.buildWithLoop(input, loopPosition);
       testObj.breakLoop(head);
       assertThat(testObj.detectLoop(head), is(IsNull.nullValue()));
       assertThat(SinglyLinkedList.getList(head).toString(), is(expectedOutput));
   }
}
