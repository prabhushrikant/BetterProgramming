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
public class MergingSortedListsTest {
    MergingSortedLists testObj;

    private String l1;
    private String l2;
    private String expectedOutput;

    public MergingSortedListsTest(String l1, String l2, String expectedOutput)
    {
        this.l1 = l1;
        this.l2 = l2;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new MergingSortedLists();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { "1 2 4", "1 3", "[1, 1, 2, 3, 4]" },
        { "1 2 4", "", "[1, 2, 4]" },
        { "", "1 3", "[1, 3]" },
        { "1 2 3", "4 5 6", "[1, 2, 3, 4, 5, 6]" }
      });
   }

   @Test
   public void testMerging() {
       ListNode lh1 = SinglyLinkedList.build(l1);
       ListNode lh2 = SinglyLinkedList.build(l2);
       assertThat(SinglyLinkedList.getList(testObj.mergeTwoLists(lh1, lh2)).toString(), is(expectedOutput));
   }
}
