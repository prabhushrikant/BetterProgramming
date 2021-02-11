package com.shrikant.problems.strings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class AllPermutationsOfStringTest {

    AllPermutationsOfString testObj;

    private String input;
    private String expectedOutput;

    // constructor
    // public AllPermutationsOfStringTest(String input, String expectedOutput) {
    //     this.input = input;
    //     this.expectedOutput = expectedOutput;
    // }

    @Before
    public void init() {
        testObj = new AllPermutationsOfString();
    }

//     @Parameterized.Parameters
//     public static List<Object[]> data() {
//       return Arrays.asList(new Object[][] {
//          { "ABC", 6 }
//       });
//    }

    @Test
    public void testAllPermutationsOfString() {
        String S = "ABC";
        testObj.printAllPermutations(S, S.length(), "");
    }
    
    @Test
    public void testCharSubstraction() {
        
        System.out.println("%d", 'G');
        assertEquals('G'-'a', 'g'-'a');
    }
}
