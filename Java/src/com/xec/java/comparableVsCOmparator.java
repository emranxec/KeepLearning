package com.xec.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparableVsCOmparator {

    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"imran",21));
        employeeList.add(new Employee(2,"salman",11));
        employeeList.add(new Employee(3,"ibrahim",41));
        employeeList.add(new Employee(4,"imtiaz",31));
        System.out.println(employeeList);
        Collections.sort(employeeList);
        System.out.println(employeeList);
        CompareByName compareByName=new CompareByName();
        employeeList.sort(compareByName);
        System.out.println(employeeList);
        CompareByAge compareByAge=new CompareByAge();
        employeeList.sort(compareByAge);
        System.out.println(employeeList);
    }
}

class CompareByName implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
       return e1.getName().compareTo(e2.getName());
    }
}

class CompareByAge implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getAge()>e2.getAge()){
            return 1;
        }
        if(e1.getAge()<e2.getAge()){
            return -1;
        }
        return 0;
    }
}


