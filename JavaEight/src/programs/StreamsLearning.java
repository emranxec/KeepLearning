package programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamsLearning {
    public static void main(String[] args) throws IOException {
        Function<Integer,Integer> multiplyFunction= a2->a2*10;
        BiFunction<Integer,Integer,String> myBiFunction= (a3, b)->a3*10/b+"1";
        System.out.println(multiplyFunction.apply(10));
        System.out.println(myBiFunction.apply(10,2));

        explanationToStreamMethod();
    }

    static boolean isDivisible(int integer){
        System.out.println("processing isDivisible"+ integer);
        return integer%5==0;
    }

    static int mapDouble(int integer){
        System.out.println("processing mapDouble"+ integer);
        return integer*2;
    }

    private static void explanationToStreamMethod() {
        List<Integer> integers= Arrays.asList(6,15,2,30,7);
        System.out.println("inside explanationToStreamMethod");
        System.out.println(integers.stream().map(i->i*2).reduce(0, Integer::sum));
        System.out.println(integers.stream().limit(2).map(i->i*2).reduce(0,Integer::sum));
        System.out.println(integers.stream().filter(integer -> integer%5==0).map(integer -> integer*2).reduce(0, Integer::min));
        System.out.println(integers.stream().findAny().orElse(0));

        Function<String,String> reverseString=new Function<String,String>() {
            @Override
            public String apply(String s) {
                return new StringBuilder(s).reverse().toString();
            }
        };

        String newString = reverseString.apply("imran");
        System.out.println("reverse is :" + newString);




        //todo stream to multiply & print sum
        System.out.println(integers.stream().map(i->i*2).reduce(0, Integer::sum));//c->carry,e->element
        System.out.println(integers.stream().map(i->i*2).reduce(0,Integer::sum));//c->carry,e->element
          System.out.println(integers.stream()
                  .filter(StreamsLearning::isDivisible)
                  .map(StreamsLearning::mapDouble)
                  .reduce(0,(c, e)->c+e));

        System.out.println("find first");
        System.out.println(integers.stream()
                .filter(StreamsLearning::isDivisible)
                .map(StreamsLearning::mapDouble)
                .findFirst().orElse(0));

        //todo explanantion


        Predicate<Integer> filterMe=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return isDivisible(integer);
            }
        };

        Predicate<Integer> filters= StreamsLearning::isDivisible;

        Function<Integer,Integer> mappingFunction=new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return mapDouble(integer);
            }
        };

        Function<Integer,Integer> mappings= StreamsLearning::mapDouble;

        BinaryOperator<Integer> reduceFunction =new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer c, Integer e) {
                return c+e;
            }
        };

        BinaryOperator<Integer> reduces=Integer::sum;



        Stream stream=integers.stream();
        Stream stream0=stream.filter(filterMe);
        Stream stream1=stream0.map(mappingFunction);
        Integer value= (Integer) stream1.reduce(0,reduceFunction);

        Integer values=integers.stream().filter(filters).map(mappings).reduce(reduces).get();

        System.out.println(value);
        System.out.println(values);

        //System.out.println(integers.stream().filter(filterMe).map(integer -> integer*2).reduce(0,(c,e)->c+e));
        //System.out.println(integers.stream().filter(filterMe).map(integer -> integer*2).findAny().orElse(0));
    }


}