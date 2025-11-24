package com.shrikant.problems.trie;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FindLongestCommonPrefixTest {

    FindLongestCommonPrefix testObj;

    private List<String> inputs;
    private String expectedResult;

    // constructor
    public FindLongestCommonPrefixTest(List<String> inputs, String lcp) {
        this.inputs = inputs;
        this.expectedResult = lcp;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { Arrays.asList("flower","flow","flight"), "fl"},
        { Arrays.asList("flower","flow","floss"), "flo"},
        { Arrays.asList("Shrikant", "Sheetal", "Mandar", "Manu"), ""},
      });
   }

   @Before
   public void init() {
       testObj = new FindLongestCommonPrefix();
   }

   @Test
   public void testFindLCP() {
       assertEquals(expectedResult, testObj.longestCommonPrefix(this.inputs.stream().toArray(String[]::new)));
   }
}
