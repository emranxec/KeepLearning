package programs;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorProgram {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,24,-1,8,-3,0));

        System.out.println("for loop-----start------");
        List<Integer> clonedList = new ArrayList<>(numbers);
        for (Integer i: clonedList){
            if(i<1)
                numbers.remove(i);
        }
        System.out.println(numbers);
        System.out.println("for loop-----ends------");
        System.out.println("CopyOnWriteArrayList-----start------");

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList =
                new CopyOnWriteArrayList<>(Arrays.asList(1,24,-1,8,-3,0));
        for (Integer i: copyOnWriteArrayList){
            if(i<1)
                copyOnWriteArrayList.remove(i);
        }
        System.out.println(copyOnWriteArrayList);
        System.out.println("CopyOnWriteArrayList-----ends------");

        System.out.println("Iterator-----start------");
        /*Iterator<Integer> integerIterator =copyOnWriteArrayList.iterator();
        while(integerIterator.hasNext()){
            if(integerIterator.next()<2){
                integerIterator.remove();
            }
        }
        System.out.println(copyOnWriteArrayList);*/
        System.out.println("Iterator-----ends------");

        System.out.println("Iterator---No exception--start------");
        Iterator<Integer> integerIterator2 = copyOnWriteArrayList.iterator();
        while (integerIterator2.hasNext()) {
            int num = integerIterator2.next();
            if (num < 1) {
                copyOnWriteArrayList.remove(num);
            }
        }
        System.out.println(copyOnWriteArrayList);
        System.out.println("Iterator---No exception--ends------");

        System.out.println("subList-----start------");
        List <String> names = new ArrayList <>();
        // Adding elements to the object of List class
        // Custom input entries
        names.add("Java");
        names.add("C++");
        names.add("Python");
        names.add("JavaScript");

        List < String > first2Names = names.subList(0,2);
        System.out.println(names + " , " + first2Names);


        // Now we add another string to
        // get ConcurrentModificationException
           names.add("SQL");

        // This line throws an exception
        //System.out.println(first2Names);
        System.out.println("subList-----ends------");

        System.out.println("copy on write-----starts------");
        List<String> myList = new CopyOnWriteArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
       while (it.hasNext()) {
            String value = it.next();
           System.out.println("List Value:" + value);
            if (value.equals("3"))
                myList.remove(value);
        }
        System.out.println("List Value:" + myList);
        System.out.println("-------");
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals("3")) {
                myList.remove("4");
                myList.add("6");
                myList.add("7");
            }
        }
        System.out.println("List Value:" + myList);
        System.out.println("copy on write-----ends------");

        System.out.println("ConcurrentHashMap-----starts------");
        Map<String, String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            System.out.println("Map Value:" + myMap.get(key));
            if (key.equals("2")) {
                myMap.put("1", "4");
                myMap.put("3", "4");
                 myMap.put("4", "4");
            }
        }
        System.out.println("Map Value:" + myMap);
        System.out.println("ConcurrentHashMap-----ends------");

    }

    }


