package com.xec.collections;

public class CollectionTest {
    //Sort hashmap on basis of value.\
    public static void main(String[] args)
    {

        // Creating object of class3 type
        Base base = new Base();

        // Calling method fun() over this object
        // inside main() method
        base.fun(new A());
        base.fun(new B());

        System.out.println("--------");

        // Creating object of class4 type
        Derived derived = new Derived();

        // Again calling method fun() over this object
        // inside main() method
        derived.fun(new A());
        derived.fun(new B());


        System.out.println("--------");


        Base base1 = new Derived();
        base1.fun(new A());
        base1.fun(new B());

    }
}





// Java Program to Demonstrate Different Return Types
// if Return Type in Overridden method is Sub-type

// Class 1
class A {
}

// Class 2
class B extends A {
}

// Class 3
// Helper class (Base class)
class Base {

    Base(){
        System.out.println("const base");
    }
    // Method of this class of class1 return type
    Base fun(A a)
    {
        // Display message only
        System.out.println("Base fun()");

        return this;
    }

}

// Class 4
// Helper class extending above class
class Derived extends Base {

    Derived(){
        System.out.println("const Derived");
    }
    // Method of this class of class1 return type
    Derived fun(B b)
    {
        // Display message only
        System.out.println("Derived fun()");

        return this;
    }
}

