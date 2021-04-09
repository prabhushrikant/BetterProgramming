package com.shrikant.problems.trie;

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
        { new ArrayList<String>(Arrays.asList("Shrikant", "Sheetal", "Mandar", "Manu")), "Manu", true},
        { new ArrayList<String>(Arrays.asList("Shrikant", "Sheetal", "Mandar", "Manu")), "Mandy", false},
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

}
