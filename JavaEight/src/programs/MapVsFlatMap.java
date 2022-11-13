package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    public static void main(String[] args) {
        //todo making the array list object
        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("mango");
        fruit.add("pineapple");
        fruit.add("kiwi");
        System.out.println("List of fruit-" + fruit);

        List<List<Integer>> number = new ArrayList<>();

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

    }

}
