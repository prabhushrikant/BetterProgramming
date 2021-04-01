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
public class ReverseListTest {
    ReverseALinkedList testObj;

    private String input;
    private String expectedOutput;

    public ReverseListTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new ReverseALinkedList();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3", "[3, 2, 1]" },
        { "2", "[2]"},
      });
   }

   @Test
   public void testReverseALinkedList() {
       ListNode head = SinglyLinkedList.build(input);
       assertThat(SinglyLinkedList.getList(testObj.reverse(head)).toString(), is(expectedOutput));
   }
}
