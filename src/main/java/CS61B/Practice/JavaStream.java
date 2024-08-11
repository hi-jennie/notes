package CS61B.Practice;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaStream {
    public static void main(String[] args) {
        // single-column collection
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        // print all elements in the list
        list.stream().forEach(letter -> System.out.println(letter));

        // two-column collection
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);
        hm.put("d", 4);

        // we need to use keySet() to get the key set of the hashmap,then get the stream
        hm.keySet().stream().forEach(key -> System.out.println(key));

        hm.entrySet().stream().forEach(entry -> System.out.println(entry));

        
    }
}
