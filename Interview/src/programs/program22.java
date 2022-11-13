package programs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class program22 {

    //yet to finish
    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>(Arrays.asList(3, 2, 1));
        List<Integer> l2 = new LinkedList<>(Arrays.asList(1, 2, 1));
        //expected output =123+121=244= 4 4 2
        List<Integer> l3 = initThirdLL(l1, l2);
        System.out.println(l3);
    }
    private static List<Integer> initThirdLL(List<Integer> l1, List<Integer> l2) {
        List<Integer> l3=new LinkedList<>();
        for(int i=0;i<l1.size();i++){
            l3.add(l1.get(i)+l2.get(i));
        }
        return l3;
    }
}
