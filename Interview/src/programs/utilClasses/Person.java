package programs.utilClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Declare the class as final so it can’t be extended.
//Don’t provide methods that modify the mutable objects.
//Don’t share references to the mutable objects.
//Never store references to external, mutable objects passed to the constructor.
//If necessary, create copies and store references to the copies.
//Similarly, create copies of our internal mutable objects when necessary to avoid returning the originals in our methods.

final class Person implements Serializable {
    //Make all fields private so that direct access is not allowed.
    private final String name;
    final private int age;
    private final List<String> degrees;

    private final List<Role> roleList;

    private Address address;
    //Make all mutable fields final so that their values can be assigned only once.

    //Initialize all the fields through a constructor doing the deep copy.

    Person(String name, int age, List<String> degrees, List<Role> roleList, Address address) {
        super();
        this.name = name;
        this.age = age;
        this.roleList = roleList;
        List<String> newDegrees = new ArrayList<String>();
        for (String degree : degrees) {
            newDegrees.add(degree);
        }
        this.degrees = newDegrees;
        this.address = address;
        //this line prevent it form serialization and reflection
        //  System.setSecurityManager(new SecurityManager());
    }
    // Do not provide setter methods (methods that modify fields) for variables, so that it can not be set.

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getDegrees() {

       /* List<String> newDegrees= new ArrayList<String>();
        for(String degree:degrees){
            newDegrees.add(degree);
        }
        return newDegrees;*/

        return (ArrayList<String>) Collections.unmodifiableCollection(degrees);

    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
/*        clone() method only works if Address has implemented Cloneable interface.
        If it has not implemented it, then we have to manually deep copy all the fields of Address class.
        But most of the user library has support for Cloneable and Serializable interfaces*/
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", degrees=" + degrees +
                ", address=" + address +
                '}';
    }

    //Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
    //If the instance fields include references to mutable objects, don’t allow those objects to be changed

    public List<Role> getRoleList() {
        /*List<Role> EmployeeRoles= new ArrayList<Role>();
        for(Role role:roleList){
            EmployeeRoles.add(role);
        }
        return EmployeeRoles;*/

        return Collections.unmodifiableList(roleList);
    }

}
