package com.shrikant.problems.generic;

import java.util.*;
import java.text.*;
public class DifferenceInDates {

    static long differenceInDays(String date1, String date2) throws ParseException {
      	//date1 into some java date object?
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
        
        //d2 is more recent.
        long difference = d2.getTime() - d1.getTime();
        
        long days = (difference/(1000 * 60 * 60 * 24));         
            
        return days;
   }
   

    static long differenceInDays2(String date1, String date2) throws ParseException {
          //date1 into some java date object?
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        Map<Integer, Integer> monthDays = new HashMap<>();
        monthDays.put(1, 31);
        monthDays.put(2, 28); //leap year + 1
        monthDays.put(3, 31);
        monthDays.put(4, 30);
        monthDays.put(5, 31);
        monthDays.put(6, 30);
        monthDays.put(7, 31);
        monthDays.put(8, 31);
        monthDays.put(9, 30);
        monthDays.put(10, 31);
        monthDays.put(11, 30);
        monthDays.put(12, 31);
        
        
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
        
        //d2 is more recent.

        //calculate days from 00-00-0000 till d1
        long d1days = calculateDaysFromBegining(d1);

        //calculate days from 00-00-0000 till d1
        long d2days = calculateDaysFromBegining(d2);

        return d2days - d1days;
   }

private static long calculateDaysFromBegining(Date d) {

  //to be implemented.
  return 1000;
}

 public static void main(String[] args) throws ParseException {
        String date2 = "07-04-2021";
        String date1 = "10-03-2021";
        
        long noOfDaysDiff = differenceInDays(date1, date2);
        long noOfDaysDiff2 = differenceInDays2(date1, date2);
        
        System.out.println("Difference 1 in days is : " + noOfDaysDiff);
        System.out.println("Difference 2 in days is : " + noOfDaysDiff2);
   }
}