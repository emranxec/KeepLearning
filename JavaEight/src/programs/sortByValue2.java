package programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class sortByValue2 {
    public static void main(String[] args) {
        sortByValue();
    }
    private static void sortByValue() {
        //Sort hashmap on basis of value.\
        Map<Integer,Integer> beforeSort=new HashMap();
        beforeSort.put(1,6);
        beforeSort.put(2,4);
        beforeSort.put(3,3);
        beforeSort.put(4,2);
        beforeSort.put(5,0);
        sortByValue(beforeSort);
    }

    private static void sortByValue(Map<Integer, Integer> beforeSort) {
        Map<Integer,Integer> afterSort= beforeSort.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e2, LinkedHashMap::new));
        System.out.println(afterSort);
    }
}
