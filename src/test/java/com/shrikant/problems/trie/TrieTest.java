package com.shrikant.problems.trie;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TrieTest {
    Trie testObj;

    private List<String> inputs;
    private String searchString;
    private boolean expectedResult;

    // constructor
    public TrieTest(List<String> inputs, String searchString, boolean searchResult) {
        this.inputs = inputs;
        this.searchString = searchString;
        this.expectedResult = searchResult;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        { new ArrayList<String>(Arrays.asList("Shrikant", "ShrikantPrabhu", "Sheetal", "Mandar", "Manu")), "Manu", true},
        { new ArrayList<String>(Arrays.asList("Shrikant", "ShrikantPrabhu", "Sheetal", "Mandar", "Manu")), "Mandy", false},
      });
   }

   @Before
   public void init() {
       testObj = new Trie();
   }

   @Test
   public void testSearchTrie() {
       for(String str : inputs) {
           testObj.attach(str);
       }
       assertThat(testObj.search(searchString), is(expectedResult));
   }

   @Test
   public void testDeleteFromTrie() {
       for(String str : inputs) {
           testObj.attach(str);
       }
       assertTrue(testObj.delete("Shrikant"));
       assertFalse(testObj.delete("Tom"));
       assertFalse(testObj.delete(""));
       assertTrue(testObj.delete("ShrikantPrabhu"));
       assertTrue(testObj.delete("Manu"));
       assertTrue(testObj.search("Mandar")); //testing that prefix "Man" isnot deleted.
   }

}
