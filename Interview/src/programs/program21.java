package programs;

import programs.utilClasses.Department;
import programs.utilClasses.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class program21 {

    public static void main(String[] args) {
        List<Employee> emplist = new ArrayList<>();//100
        Department department=new Department("IT",10);
        emplist.add(new Employee("imran", department));
        emplist.add(new Employee("imran", department));
        emplist.add(new Employee("kopal", department));
        emplist.add(new Employee("Sridharan", department));
        emplist.add(new Employee("Sridharan", department));

        Map<String,List<Employee>> map=emplist.stream().collect(Collectors.groupingBy(Employee:: getName));
        //1. get only employee having dept = "IT"
        System.out.println(emplist.stream().filter(e->e.getDepartment().getDepartmentName().equals("IT")).collect(Collectors.toList()));
        //2. Convert in map key--id, value--Employee
        Map<String, List<Employee>> employeeMap=emplist.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.toList()));
        System.out.println(employeeMap);


      /*  3. Employee count based on depart
        "IT", 25
        "Civil", 39*/

        emplist.stream().collect(mapping(e->e.department).groupingby(e->e.department),count()).collect(Collectors.toMap());

    }
}
