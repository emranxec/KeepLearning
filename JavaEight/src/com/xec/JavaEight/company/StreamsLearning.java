package com.xec.JavaEight.company;

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

      /*  Stream<String> lines= Files.lines(Paths.get("README.md"));

        lines.sorted()
            .filter(i->i.length()>9)
           .forEach(x-> System.out.println(x+ " "));
        lines.close();*/

        IntStream.range(0,10)
                .skip(5)
                .forEach(x-> System.out.println(x));
         int a = 12333445;

        System.out.println(countUniqueDigit(a));
        //System.out.println( countPairsWithDiffK(a));

        /* todo Given a List of integers (List<Integer>),
            write code in Java 8 style to get the sum of the squares of all the odd numbers in the array.*/


        int sum = IntStream.of(a).filter(e->e%2==1).map(a1->a1*a1).sum();

        System.out.println(sum);

        //todo making the array list object
       ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("mango");
        fruit.add("pineapple");
        fruit.add("kiwi");
        System.out.println("List of fruit-" + fruit);

        List<List<Integer> > number = new ArrayList<>();

        // adding the elements to number arraylist
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(5, 6,6));
        number.add(Arrays.asList(7, 8));

        System.out.println("List of list-" + number);

        // lets use map() to convert list of fruit
        List list1 = fruit.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());
        System.out.println("List generated by map-" + list1);

        // using flatmap() to flatten this list
        List<Integer> flatList
                = number.stream()
                .flatMap(list -> list.stream()).filter(a4->a4%2==0)
                .collect(Collectors.toList());

        // printing the list
        System.out.println("List generate by flatMap-"
                + flatList);

        Function<Integer,Integer> myFunction= a2->a2*10;
        BiFunction<Integer,Integer,String> myBiFunction= (a3, b)->a3*10/b+"1";

        System.out.println(myFunction.apply(10));
        System.out.println(myBiFunction.apply(10,2));


        // write your code here
        //iterationJava8();

        //filter=predicate ->return boolean
        //reduce=BinaryOperator->data(terminal)
        //Map=function ->stream
        //foreach=consumer->data(terminal)

        explanationToStreamMethod();
    }

    private static int countUniqueDigit(int num) {
        Set<Integer> digits = new HashSet<>();

        while(num>0){
            digits.add(num%10);
            num/=10;
        }
        return digits.size();

        /*     // iterate to each digit
            while (num > 0) {
                // find last digit
                // add it to collection
                digits.add(num % 10);
                // remove last digit
                num /= 10;
            }

            // return size
            return digits.size();*/
    }

    static int countPairsWithDiffK(int arr[],
                                   int n, int k)
    {
        int count = 0;
        //Input: arr[] = {1, 5, 3, 4, 2}, k = 3
        //
        // Pick all elements one by one
        for (int i = 0; i < n; i++)
        {
            // See if there is a pair
            // of this picked element
            for (int j = i + 1; j < n; j++)
               if(arr[i]-arr[j]==k||
                    arr[j]-arr[i]==k){
                   count++;

        }
        }
        return count;
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
        System.out.println(integers.stream().map(i->i*2).reduce(0,(c,e)->c+e));
        System.out.println(integers.stream().limit(2).map(i->i*2).reduce(0,Integer::sum));
        System.out.println(integers.stream().filter(integer -> integer%5==0).map(integer -> integer*2).reduce(0,(c,e)->c+e));
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
        //System.out.println(integers.stream().map(i->i*2).reduce(0,(c,e)->c+e));//c->carry,e->element
        //System.out.println(integers.stream().map(i->i*2).reduce(0,Integer::sum));//c->carry,e->element
        //  System.out.println(integers.stream().filter(StreamsAPI::isDivisible).map(StreamsAPI::mapDouble).reduce(0,(c, e)->c+e));

        // System.out.println("find first");
        //System.out.println(integers.stream().filter(StreamsAPI::isDivisible).map(StreamsAPI::mapDouble).findFirst().orElse(0));

        //todo explanantion


        Predicate<Integer> filterMe=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return isDivisible(integer);
            }
        };
        Function<Integer,Integer> mappingFunction=new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return mapDouble(integer);
            }
        };
        BinaryOperator<Integer> reduceFunction =new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer c, Integer e) {
                return c+e;
            }
        };



        Stream stream=integers.stream();
        Stream stream0=stream.filter(filterMe);
        Stream stream1=stream0.map(mappingFunction);
        Integer value= (Integer) stream1.reduce(0,reduceFunction);

        System.out.println(value);

        //System.out.println(integers.stream().filter(filterMe).map(integer -> integer*2).reduce(0,(c,e)->c+e));
        //System.out.println(integers.stream().filter(filterMe).map(integer -> integer*2).findAny().orElse(0));
    }

    private static void iterationJava8() {
        List<Integer> integers= Arrays.asList(1,2,3);

        Iterator<Integer> integerIterator= integers.iterator();

        System.out.println("external iteration----start");
        System.out.println("iterator");
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }
        System.out.println("for loop");
        for(int i:integers){
            System.out.println(i);
        }
        System.out.println("external iteration----end");

        System.out.println("internal iteration----start");
        System.out.println("for each");

        integers.forEach(i-> System.out.println(i));

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
        Consumer<Integer> consumer1=(Integer i)-> System.out.println(i);
        integers.forEach(consumer1);
        //till-here

        //convert from here-start
        //level=2
        Consumer<Integer> consumer2=i-> System.out.println(i);
        integers.forEach(consumer2);
        //till-here

        //convert from here-start
        //level=3
        integers.forEach(i-> System.out.println(i));
        //till-here

        //method reference
        System.out.println("method referance");
        integers.forEach(System.out::println);
    }
}