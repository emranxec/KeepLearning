package programs;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;


public class SecondFridayUsingDate {

    public static void main(String[] args) {

        Date date=new Date();
        LocalDate firstInYear = LocalDate.of(date.getYear(),date.getMonth(), 1);
        LocalDate secondFriday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("Second friday :" + secondFriday);


    }






}
