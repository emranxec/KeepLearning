package programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class maxTimesRepeated {

    public static void main(String[] args) {
        //list,0,1,2,3,4,5,6,7,8,9
        System.out.println(maxTimesRepeated("VIPs are statically allocated in parameter files.\n" +
                "\n" +
                "The downside to this method is it is very easy to accidentally re-use an existing hostname and this will break the existing server when it attempts to domain join; it is also easy to fragment the address space when redeploying groups of servers with changing numbers of servers in the group since the space needs to be contiguous. c1`\n" +
                "\n" +
                "To make allocating new NPE JBOSS IP addresses easy in a /24 subnet allocate IPs in these ranges: "));

    }
    static ArrayList maxTimesRepeated(String s){
        String[] allElements= s.split(" ");
        Map<String,Integer> myMap=new HashMap();

        for(String s2:allElements){
            if(myMap.containsKey(s2)){
                myMap.put(s2,myMap.get(s2)+1);
            }else{
                myMap.put(s2,1);
            }
        }

        ArrayList list= (ArrayList) myMap.entrySet()
                .stream()
                .sorted(maxTimesRepeated::compare).limit(5)
                .collect(Collectors.toList());
        return list;
    }
    private static int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> v) {
        return v.getValue().compareTo(a.getValue());
    }
}
