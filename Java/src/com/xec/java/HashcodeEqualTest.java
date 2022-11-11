package com.xec.java;

import java.util.HashSet;
import java.util.Set;

public class HashcodeEqualTest {

    public static void main(String[] args) {
        Employee imran = new Employee(1, "imran", 21); //same
        Employee salman = new Employee(2, "salman", 11);
        Employee ibrahim = new Employee(1, "imran", 21); //same
        Employee imtiaz = new Employee(4, "imran", 31);

        Set<Employee> employees = new HashSet<>();

        employees.add(imran);
        employees.add(salman);
        employees.add(ibrahim);
        employees.add(imtiaz);

        System.out.println(employees);
    }
}
