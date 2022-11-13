package programs;

import java.util.HashMap;
import java.util.Map;

public class CreateMap {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("goa", 1);
        hashMap.put("karnataka", 2);

        userDefinedMap userDefinedMap = new userDefinedMap();
        userDefinedMap.put("imran", 1);
        userDefinedMap.putAll(hashMap);
        userDefinedMap.putIfAbsent("imran", 2);
        userDefinedMap.putIfAbsent("salman", 0);

        System.out.println(userDefinedMap.getCounter());

/*
    Design a new implementation of the Map interface which will also keep a count of all the calls
        to add a key value pair in the Map. It should count the calls to put, putAll and putIfAbsent methods.
    The implementation should also be able to provide all the features of any Map implementation that user wants.
        (e.g. HashMap, TreeMap etc)
*/


    }
}

    class userDefinedMap<K, V> {
        HashMap hashMap = new HashMap();
        HashMap counter = new HashMap();

        Map getCounter() {
            return counter;
        }

        userDefinedMap() {
            counter.put("put", 0);
            counter.put("putAll", 0);
            counter.put("putIfAbsent", 0);
        }

        Object put(K key, V value) {
            int count = (int) counter.get("put");
            counter.put("put", count + 1);
            return hashMap.put(key, value);
        }

        void putAll(Map map) {
            int count = (int) counter.get("putAll");
            counter.put("putAll", count + 1);
            hashMap.putAll(map);
        }

        public Object putIfAbsent(K key, V value) {
            int count = (int) counter.get("putIfAbsent");
            counter.put("putIfAbsent", count + 1);
            return hashMap.putIfAbsent(key, value);
        }
    }



