package com.shrikant.problems.linkedlist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FlattenListTest {
    FlattenList testObj;

    private String[] inputs;
    private String expectedOutput;

    public FlattenListTest(String[] input, String expectedOutput)
    {
        this.inputs = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void init() {
        testObj = new FlattenList();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { new String[] {"1 2 3 4", "5 6 7"}, "[1, 2, 3, 4, 5, 6, 7]" },
        { new String[] {"1 2 4", "3 5 6"}, "[1, 2, 3, 4, 5, 6]" },
      });
   }

   @Test
   public void testBreakLoopIfExists() {
       ListNode head = makeListOfLists(inputs);
       testObj.flatten(head);
       assertThat(getListUsingBottomPointer(head).toString(), is(expectedOutput));
   }

   private ListNode makeListOfLists(String[] inputs) {
        
        ArrayList<ListNode> heads = new ArrayList<>();
        //make linked list using bottom pointer.
        for(String sortedList : inputs) {
            String[] nodes = sortedList.split(" ");
            ListNode head = null;
            ListNode tail = head;
            for(String nodeData : nodes) {
                ListNode newNode = new ListNode(Integer.parseInt(nodeData));
                if (head == null) {
                    head = newNode;
                    tail = head;
                } else {
                    tail.bottom = newNode;
                    tail = tail.bottom;
                }
            }

            heads.add(head);
        }

        //connect the heads of the linked lists with next pointer.
        ListNode lastHead = null;
        for(ListNode head : heads) {
            if (lastHead == null) {
                lastHead = head;
            } else {
                lastHead.next = head;
            }
        }

        return heads.get(0);
   }

   private List<Integer> getListUsingBottomPointer(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while(head != null) {
            result.add(head.data);
            head = head.bottom;
        }
        return result;
   }
}
