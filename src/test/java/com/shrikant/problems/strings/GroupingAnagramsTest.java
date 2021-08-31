package com.shrikant.problems.strings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GroupingAnagramsTest {
    GroupingAnagrams testObj;

    private String[] input;

    public GroupingAnagramsTest(String[] input)
    {
        this.input = input;
    }

    @Before
    public void init() {
        testObj = new GroupingAnagrams();
    }

//     @Parameterized.Parameters
//     public static List<Object[]> data() {
//       return Arrays.asList(new Object[][] {
//         { new String[] {"eat","tea","tan","ate","nat","bat"}, 1},
//         { new String[] {"eat","tea","tan","ate","nat","bat"}, 1},
//         { new String[] {"eat","tea","tan","ate","nat","bat"}, 1},
//         { new String[] {"eat","tea","tan","ate","nat","bat"}, 1},
//         { new String[] {"eat","tea","tan","ate","nat","bat"}, 1},  
//     });
//    }

   @Test
   public void testSuccess() {
       //given
       List<ArrayList<String>> expected = new ArrayList<ArrayList<String>>(); 
       //when
       List<List<String>> actual = testObj.groupAnagrams(input); 

       //then
       assertThat(actual, is(expected));
   }
}
