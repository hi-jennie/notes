package CS61B.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class JavaStream {
    public static void main(String[] args) {
        // single-column collection
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bbd");
        list.add("adb");
        list.add("d");

        // print all elements in the list
        list.stream().forEach(letter -> System.out.println(letter));
        list.stream().filter(letter -> letter.length() == 3).filter(letter -> letter.startsWith("a")).forEach(letter -> System.out.println(letter));

        // there is no need to use stream() for the following code
        Stream<String> stream1 = list.stream().filter(letter -> letter.length() == 3);
        Stream<String> stream2 = stream1.filter(letter -> letter.startsWith("a"));
        stream2.forEach(letter -> System.out.println(letter));
        // because we can only use stream() once, so we can combine the above code into one line
        // String<String> stream3 = stream1.filter(letter -> letter.length() == 3).filter(letter -> letter.startsWith("a"));
        // we will get wrong answer

        // two-column collection
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);
        hm.put("d", 4);

        // we need to use keySet() to get the key set of the hashmap,then get the stream
        hm.keySet().stream().forEach(key -> System.out.println(key));

        hm.entrySet().stream().forEach(entry -> System.out.println(entry));


        // how to use stream with array by using Arrays.stream()
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(num -> System.out.println(num));

        Stream.of(1, 2, 3, 5, 7, 2, 6, 7).forEach(num -> System.out.println(num));


    }
}
