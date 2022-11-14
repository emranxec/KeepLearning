package programs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

interface I{
    default void show(){
        System.out.println("I");
    }
}

interface J{
    default void show(){
        System.out.println("J");
    }

    static void hello(){
        System.out.println("hello");
    }
}

public class DefaultMethod implements I,J{
    @Override
    public void show() {
        System.out.println("eight");
    }
}

class newOne extends DefaultMethod implements J{
    @Override
    public void show() {
        super.show();
    }

    public static void main(String[] args) {
        newOne one=new newOne();
        one.show();
        J.hello();

        List<String> mylist= new ArrayList<>();
        mylist.add("imran");
        mylist.add("salman");
        Stream<String> s= mylist.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);//throw exception as stream execute only once;
    }
}

