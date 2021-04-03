package com.shrikant.problems.linkedlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ReverseInGroupsTest {
    ReverseInGroups testObj;

    private String input;
    private int groupSize;
    private String expectedOutput;

    public ReverseInGroupsTest(String input, int groupSize, String expectedOutput)
    {
        this.input = input;
        this.groupSize = groupSize;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new ReverseInGroups();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3", 2, "[2, 1, 3]" },
        { "1 2 3 4 5", 3, "[3, 2, 1, 5, 4]"},
        { "1 2 2 4 5 6 7 8", 4, "[4, 2, 2, 1, 8, 7, 6, 5]" },
        { "2 3", 2, "[3, 2]" },
        { "2", 0, "[2]"},
        { "2", 1, "[2]"},
        { "2", 3, "[2]"},
      });
   }

   @Test
   public void testReverseInGroups() {
       ListNode head = SinglyLinkedList.build(input);
       ListNode newHead = testObj.reverse(head, groupSize);
       assertThat(SinglyLinkedList.getList(newHead).toString(), is(expectedOutput));
   }
}
