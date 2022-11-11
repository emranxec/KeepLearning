import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Role{
    String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

 class Address implements Cloneable{

    String city;

    public Address(String city) {
        super();
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

     @Override
     public Object clone() throws CloneNotSupportedException {
         return super.clone();
     }

}
//Declare the class as final so it can’t be extended.
//Don’t provide methods that modify the mutable objects.
//Don’t share references to the mutable objects.
//Never store references to external, mutable objects passed to the constructor.
//If necessary, create copies and store references to the copies.
//Similarly, create copies of our internal mutable objects when necessary to avoid returning the originals in our methods.
public final class ImmutableOne {
    //Make all fields private so that direct access is not allowed.
    private final String Ename;
    //Make all mutable fields final so that their values can be assigned only once.
    private final List<Role> EmployeeRoles;

    private final Address address;

    protected ImmutableOne(String ename, List<Role> employeeRoles, Address address){
        this.Ename = ename;
        this.address = address;
        this.EmployeeRoles = employeeRoles;

        //Initialize all the fields through a constructor doing the deep copy.
       /* List<Role> newRoles=new ArrayList<>();
        for(Role role:employeeRoles){
            Role role1=new Role(role.getName());
            newRoles.add(role1);
        }*/

    }

   // Do not provide setter methods (methods that modify fields) for variables, so that it can not be set.
    public String getEname() {
        return Ename;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    //Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
    //If the instance fields include references to mutable objects, don’t allow those objects to be changed
    public List<Role> getEmployeeRoles() {
        return Collections.unmodifiableList(EmployeeRoles);
    }
}


