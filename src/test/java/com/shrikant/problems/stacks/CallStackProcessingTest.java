package com.shrikant.problems.stacks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CallStackProcessingTest {

    CallStackProcessing testObj;

    private List<String> input;
    private HashMap<String, Integer> expectedResult;

    public CallStackProcessingTest(List<String> input, HashMap<String, Integer> functionTimes) {
        this.input = input;
        this.expectedResult = functionTimes;
    }

    @Before
    public void init() {
        testObj = new CallStackProcessing();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
      return Arrays.asList(new Object[][] {
        //test case 1
        { new ArrayList<String>(Arrays.asList(
             "foo:start:0", 
             "bar:start:2", 
             "bar:end:4",
             "foo:end:6")),
            new HashMap<String, Integer>() {{
                put("bar", 2);
                put("foo", 6-0-2);}},
        },
        { new ArrayList<String>(Arrays.asList(
            "foo:start:0", 
            "bar:start:2", 
            "bar:end:4",
            "foo:end:6")),
           new HashMap<String, Integer>() {{
               put("bar", 2);
               put("foo", 6-0-2);}},
       },
       //test case 2
        { new ArrayList<String>(Arrays.asList(
            "foo:start:0",
            "bar:start:2",
            "baz:start:4",
            "baz:end:5",  
            "bar:end:6",  
            "test:start:7",
            "test:end:9",   
            "baz:start:10", 
            "baz:end:13", 
            "foo:end:14" 
            )),
        new HashMap<String, Integer>() {{
            put("baz", 4);
            put("bar", 3);
            put("test", 2);
            put("foo", 5);}},
        },
      }); 
   }

   @Test
   public void testProcessing() {
       var processedInput = testObj.processLog(input); 
       assertThat(testObj.getExclusiveTime(processedInput), is(expectedResult));
   }
}
