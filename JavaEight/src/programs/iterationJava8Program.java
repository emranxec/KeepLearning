package programs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class iterationJava8Program {
    public static void main(String[] args) {
        iterationJava8();
    }
    private static void iterationJava8() {
        List<Integer> integers= Arrays.asList(1,2,3);

        Iterator<Integer> iterator= integers.iterator();

        System.out.println("external iteration----start------------");
        System.out.println("iterator----start");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("iterator----ends");
        System.out.println("for loop----start");
        for(int i:integers){
            System.out.println(i);
        }
        System.out.println("for loop----ends");
        System.out.println("external iteration----end-----------------");

        System.out.println("internal iteration----start--------------------");
        System.out.println("for each----start---------");

        integers.forEach(System.out::println);

        System.out.println("for each----ends---------");

        System.out.println("consumer");
        //convert from here-start
        //level=0
        Consumer<Integer> consumer=new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };
        integers.forEach(consumer);
        //till-here


        //convert from here-start
        //level=1
        System.out.println("level=1");
        Consumer<Integer> consumer1=(Integer i)-> System.out.println(i);
        integers.forEach(consumer1);
        //till-here

        //convert from here-start
        //level=2
        System.out.println("level=2");
        Consumer<Integer> consumer2=i-> System.out.println(i);
        integers.forEach(consumer2);
        //till-here

        //convert from here-start
        //level=3
        System.out.println("level=3");
        integers.forEach(i-> System.out.println(i));
        //till-here

        //method reference
        System.out.println("method referance");
        integers.forEach(System.out::println);
        System.out.println("internal iteration----ends--------------------");
    }
}
