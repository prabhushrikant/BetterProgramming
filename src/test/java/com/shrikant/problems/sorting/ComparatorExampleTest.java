package com.shrikant.problems.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ComparatorExampleTest {

    ComparatorExample testObj;

    public List<ComparatorExample.Student> inputStudents;
    public List<ComparatorExample.Student> expectedSortedStudents;

    public ComparatorExampleTest(List<ComparatorExample.Student> students, 
        List<ComparatorExample.Student> expectedSortedStudents) {
        this.inputStudents = students;
        this.expectedSortedStudents = expectedSortedStudents;
    }

    @Before
    public void init() {
        testObj = new ComparatorExample();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        {
            //input 1
                Arrays.asList(
                new ComparatorExample.Student(2, "Alice", "Address1"),
                new ComparatorExample.Student(1, "Bob", "Address2"),
                new ComparatorExample.Student(2, "Charlie", "Address3")), 
            // expected output 1
            Arrays.asList(
                new ComparatorExample.Student(1, "Bob", "Address2"),
                new ComparatorExample.Student(2, "Alice", "Address1"),
                new ComparatorExample.Student(2, "Charlie", "Address3")) 
        },
        {   //input 2
            Arrays.asList(
             new ComparatorExample.Student(3, "David", "Address4"),
             new ComparatorExample.Student(1, "Eve", "Address5"),
             new ComparatorExample.Student(2, "Frank", "Address6")),
            // expected output 2
            Arrays.asList(
             new ComparatorExample.Student(1, "Eve", "Address5"),
             new ComparatorExample.Student(2, "Frank", "Address6"),
             new ComparatorExample.Student(3, "David", "Address4"))
        }
      });
    }
 
    @Test
    public void testSortStudentsByNaturalOrder() {
        assertEquals(expectedSortedStudents, testObj.sortStudentsByNaturalOrder(inputStudents));
    }
}
