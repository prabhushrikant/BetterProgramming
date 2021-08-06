package com.shrikant.problems.hashmap;

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
public class SalesTest {
    
    Sales testObj;

    private int[] inputArray;
    private List<Order> orders;
    private int expectedResult;

    // constructor
    public SalesTest(int[] arr, List<Order> orders,  int expectedResult) {
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

        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order(6, 55));
        orders.add(new Order(6, 45));
        orders.add(new Order(6, 55));
        orders.add(new Order(4, 40));
        orders.add(new Order(18, 60));
        orders.add(new Order(10, 50)); 

      return Arrays.asList(new Object[][] {
         { new int[] {2,3,4,5,6,8,7,6,5,18}, orders,  200 }
      });
    }

      @Test
      public void testTotalSales() {
          assertThat(testObj.getTotalSales(inputArray, orders), is(expectedResult));
      }  
}
