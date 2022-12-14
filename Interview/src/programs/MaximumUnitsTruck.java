package programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumUnitsTruck {

    public static void main(String[] args) {
        //int[][] myArray= {{2,2},{3,1},{1,3}};
        int[][] myArray= {{5,10},{2,5},{4,7},{3,9}};

        int maximumUnits = maximumUnits(myArray, 10);
        System.out.println("maximum unit truck can carry is : " + maximumUnits);
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int quantity=0;
        Map<Object, Object> collect = Stream.of(boxTypes).collect(Collectors.toMap(x -> x[0], x -> x[1],(v1, v2) -> v1,
                LinkedHashMap::new)).entrySet().stream().sorted( (c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(v1, v2) -> v1,
                        LinkedHashMap::new));
        System.out.println(collect);
        for(Map.Entry map:collect.entrySet()){
            if((int)map.getKey()<=truckSize){
                quantity=quantity+(int)map.getValue()*(int)map.getKey();
                truckSize=truckSize-(int)map.getKey();
            }else if(truckSize>=0){
                quantity=quantity+(int)map.getValue()* truckSize;
                truckSize=0;
            }
        }


        return quantity;
    }
}
