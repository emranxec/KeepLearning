package programs;

import programs.utilClasses.Address;
import programs.utilClasses.Department;
import programs.utilClasses.Employee;

import java.util.*;

public class program20 {

    public static void main(String[] args) {
        Map<Employee, List<Address>> hashMap = new HashMap<>();
        Department department=new Department("IT",10);
        Employee employee=new Employee("A", department);
        hashMap.put(new Employee("A", department),
                Arrays.asList(new Address("St1", "goa"), new Address("St2", "goa")));

        hashMap.put(new Employee("A", department),
                Arrays.asList(new Address("St3", "goa"), new Address("St4", "goa")));
        System.out.println("total hashmap elements :" + hashMap.size());//1(kopal),2(sridharan)
        List<Address> address = hashMap.get(new Employee("A", department));
        System.out.println("get address details "+ address);// //st3,st4(kopal), empty(sriharan)

    }
}

