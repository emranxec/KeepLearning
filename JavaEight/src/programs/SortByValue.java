package programs;

import java.util.*;
import java.util.stream.Collectors;

public class SortByValue {

    public static HashMap   <String, Integer> sortByValue1(HashMap<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hm.entrySet());

        Collections.sort(list, Map.Entry.comparingByValue());

        HashMap<String, Integer> temp= new LinkedHashMap<>();

        for(Map.Entry<String,Integer> val: list){
            temp.put(val.getKey(),val.getValue());
        }
        return temp;
    }

    private static Map<String, Integer> sortByValue2(HashMap<String, Integer> hm) {
        HashMap<String, Integer> temp= hm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                        Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
        return temp;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);

        Map<String, Integer> hm1 = sortByValue1(hm);

        Map<String, Integer> hm2 = sortByValue2(hm);
        System.out.println("-----------sortByValue1------------");
        printMapEntries(hm1);
        System.out.println("-----------sortByValue2------------");
        printMapEntries(hm2);
    }

    private static void printMapEntries(Map<String, Integer> hm1) {
        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }
    }


}
