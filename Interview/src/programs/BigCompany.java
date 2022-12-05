package programs;

import programs.utilClasses.EmployeeSerialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

public class BigCompany {

    //Big Company would like a program that continually processes these files and implements the following requirements:
//1. If a duplicate file is delivered it should be ignored
//2. If a given rate varies by more than 20% day on day this should be "flagged"
//3. A monthly average rate for each EXCHANGE_RATE should be calculated and published by the program
//4. A yearly average rate for each EXCHANGE_RATE should be calculated and published by the program
    static Set FilesProcesses;
    static Map<String,CurrencyExchangeRate> monthlyAverageMap;
    static Map<String,CurrencyExchangeRate> yearlyAverageMap;
    static Map<String,CurrencyExchangeRate> flaggedRatesMap;

    static {

    }

    public static void sendFile(String fileContent){

    }
}

class CurrencyExchangeRate{
    final private String name;
    private boolean isFlagged= false;
    private BigInteger monthlyAverage;
    private BigInteger yearlyAverage;

    public CurrencyExchangeRate(String name, boolean isFlagged, BigInteger monthlyAverage, BigInteger yearlyAverage) {
        this.name = name;
        this.isFlagged = isFlagged;
        this.monthlyAverage = monthlyAverage;
        this.yearlyAverage = yearlyAverage;
    }

    public String getName() {
        return name;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public BigInteger getMonthlyAverage() {
        return monthlyAverage;
    }

    public void setMonthlyAverage(BigInteger monthlyAverage) {
        this.monthlyAverage = monthlyAverage;
    }

    public BigInteger getYearlyAverage() {
        return yearlyAverage;
    }

    public void setYearlyAverage(BigInteger yearlyAverage) {
        this.yearlyAverage = yearlyAverage;
    }
}
