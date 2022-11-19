package com.xec.keywood;

public class Program
{
    public static void main(String[] args) {
        System.out.println("c.y in main "+c.y);
    }
}

class p{
    static int y=4;
    static {
        System.out.println("p static "+y);
    }
}
class c extends p{
    // static int y=5;
    static {
        y=6;                                        //compile error
        System.out.println("c static "+y );
    }
}
