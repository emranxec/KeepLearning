package programs.utilClasses;

/*

Do not provide any setters
Mark all fields as private
Make the class final

We will declare class as final and all the fields as private final.
        We will provide one parameterized constructor and getter methods.
        We will not provide any setter method, so that field values can not be changed after object creation.*/


/*Advantages of immutable objects:

        An immutable object remains in exactly one state, the state in which it was created.
        Therefore, immutable object is thread-safe so there is no synchronization issue.
        They cannot be corrupted by multiple threads accessing them concurrently.
        This is far and away the easiest approach to achieving thread safety.
        Immutable classes are easier to design, implement, and use than mutable classes.
        Immutable objects are good Map keys and Set elements, since these typically do not change once created.
        Immutability makes it easier to write, use and reason about the code
        (class invariant is established once and then unchanged).
        Immutability makes it easier to parallelize program as there are no conflicts among objects.
        The internal state of program will be consistent even if you have exceptions.
        References to immutable objects can be cached as they are not going to change.
        (i.e. in Hashing it provide fast operations).

 Disadvantages of immutable objects:
        The only real disadvantage of immutable classes is that they require a separate object for each distinct value.*/

import java.util.ArrayList;
import java.util.List;

public class LetsImmutable {


    public static void main(String[] args) {
        List<String> newDegrees= new ArrayList<String>();
        newDegrees.add("english");
        Address address=new Address("goa1","goa2");
        List<Role> employeeRoles= new ArrayList<Role>();
        employeeRoles.add(new Role("Admin"));
        Person p=new Person("imran",21,newDegrees, employeeRoles, address);
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getDegrees());
        List<String> personDegrees=p.getDegrees();
        personDegrees.add("fake");
        System.out.println(p.getDegrees());


    }
}


