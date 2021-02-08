package Calculations;

import Amounts.Amount;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Amounts.*;
import Time.Time;

public class Average {
    private LocalDate averageForDate;
    private List<Amount> amountList;
    private List<Time> timeList;

    public Average(List<Amount> amountList, List<Time> timeList) {
        this.amountList = amountList;
        this.timeList = timeList;
    }

    public float calculateAverage(){
/*        if (getTimeForAverage() > 0){
            return getAmountForAverage()/getTimeForAverage();
        } else throw ArithmeticException ();*/
     float average = 0;
        try {
            average = getAmountForAverage()/getTimeForAverage();
        } catch (ArithmeticException e){

        }
        return average;
    }

   public float getAmountForAverage(){
       return (float) amountList.stream().mapToDouble(x -> x.getAmount()).sum();
   }

   public float getTimeForAverage(){
       return (float) timeList.stream().mapToDouble(x -> x.getDuration()).sum();
   }
}
