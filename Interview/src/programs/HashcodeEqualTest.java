package programs;

import programs.utilClasses.EmployeeHashcodeTest;

import java.util.HashSet;
import java.util.Set;

public class HashcodeEqualTest {

    public static void main(String[] args) {
        EmployeeHashcodeTest imran = new EmployeeHashcodeTest(1, "imran", 21); //same
        EmployeeHashcodeTest salman = new EmployeeHashcodeTest(2, "salman", 11);
        EmployeeHashcodeTest ibrahim = new EmployeeHashcodeTest(1, "imran", 21); //same
        EmployeeHashcodeTest imtiaz = new EmployeeHashcodeTest(4, "imran", 31);

        Set<EmployeeHashcodeTest> employees = new HashSet<>();

        employees.add(imran);
        employees.add(salman);
        employees.add(ibrahim);
        employees.add(imtiaz);

        System.out.println(employees);
    }
}
