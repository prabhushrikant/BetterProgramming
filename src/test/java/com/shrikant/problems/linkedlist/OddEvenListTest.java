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
public class OddEvenListTest {
    OddEvenList testObj;

    private String input;
    private String expectedOutput;

    public OddEvenListTest(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new OddEvenList();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 3 4 5", "[1, 3, 5, 2, 4]" },
        { "1 2 3 4", "[1, 3, 2, 4]" },
        { "1" , "[1]"}
      });
   }

   @Test
   public void testOddEvenListSuccess() {
       ListNode head = SinglyLinkedList.build(input);
       testObj.oddEvenList(head);
       assertThat(SinglyLinkedList.getList(head).toString(), is(expectedOutput));
   }
}
