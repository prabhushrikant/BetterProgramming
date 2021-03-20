package com.shrikant.problems.strings;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;


public class AllPermutationsOfStringTest {

    AllPermutationsOfString testObj;

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
        assertNotEquals('G'-'a', 'g'-'a');
    }
}
