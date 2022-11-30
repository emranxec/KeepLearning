package com.xec.abstractt;

abstract  class A {
    A(){
        System.out.println("abstract constructor of A");
        hello();
    }
    abstract void hello();
    void NonHello(){}
}

class B extends A{

    @Override
    void hello() {
        System.out.println("Hello B");
    }
    void helloB() {
        System.out.println("Hello special B");
    }
}

public class C extends B{

    @Override
    void hello() {
        System.out.println("Hello C");
    }
}

class D{
    public static void main(String[] args) {
        B a=new B();
        a.helloB();
    }
}

