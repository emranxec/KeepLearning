package programs;

import java.nio.channels.AcceptPendingException;

public class designClass {


//Design a class such that only one instance of the class and any of its sub-classes can be created.
// To clarify: Assume A is such a class and B is derived from A.
// B does not have any special code apart from extending A
// new A(); // works fine.
// new A(); // causes an exception
// new B(); // works fine as this is the first instance of B
// new B(); // causes an exception
public static void main(String[] args) throws IllegalAccessException {

    A a=new A();
  //  A a1=new A();
    //A a1=new A();
    //A ab1=new B();
    //A ab2=new B();
    A b1=new B();
    //A b2=new B();
}


}

class A{
  public static String myInstance=null;
    A() throws IllegalAccessException {
       if(myInstance!=null){
           throw new IllegalAccessException("cannot create duplicate");
       }
       myInstance= "Now init Done";
        System.out.println(myInstance);
    }
}

class B extends A{
    public static String mySecondInstance=null;
        B() throws IllegalAccessException {
        if(mySecondInstance!=null){
            throw new IllegalAccessException("cannot create duplicate mySecondInstance");
        }
        mySecondInstance= "Now mySecondInstance init Done";
        System.out.println(mySecondInstance);
    }
}
