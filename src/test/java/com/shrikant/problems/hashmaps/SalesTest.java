package com.shrikant.problems.hashmaps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shrikant.problems.hashmap.Sales;
import com.shrikant.problems.utils.Pair;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SalesTest {
    
    Sales testObj;

    private int[] inputArray;
    private List<Pair> orders;
    private int expectedResult;

    // constructor
    public SalesTest(int[] arr, List<Pair> orders,  int expectedResult) {
        this.inputArray = arr;
        this.orders = orders;
        this.expectedResult = expectedResult;
    }

    @Before
    public void init() {
        testObj = new Sales();
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {

        List<Pair> orders = new ArrayList<Pair>();
        orders.add(new Pair(6, 55));
        orders.add(new Pair(6, 45));
        orders.add(new Pair(6, 55));
        orders.add(new Pair(4, 40));
        orders.add(new Pair(18, 60));
        orders.add(new Pair(10, 50)); 

      return Arrays.asList(new Object[][] {
         { new int[] {2,3,4,5,6,8,7,6,5,18}, orders,  200 }
      });
    }

      @Test
      public void testEquilibriumPoint() {
          assertThat(testObj.getTotalSales(inputArray, orders), is(expectedResult));
      }  
}
