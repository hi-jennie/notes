package CS61B.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Stream;

public class JavaStream {
    public static void main(String[] args) {
        // single-column collection
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bbd");
        list.add("adb");
        list.add("d");
        list.add("adb");


        // print all elements in the list
        list.stream().forEach(letter -> System.out.println(letter));
        System.out.println("---------------------------------");
        list.stream().filter(letter -> letter.length() == 3).filter(letter -> letter.startsWith("a")).forEach(letter -> System.out.println(letter));

        // there is no need to use stream() for the following code
        Stream<String> stream1 = list.stream().filter(letter -> letter.length() == 3);
        Stream<String> stream2 = stream1.filter(letter -> letter.startsWith("a"));
        System.out.println("---------------------------------");
        stream2.forEach(letter -> System.out.println(letter));
        // because we can only use stream() once, so we can combine the above code into one line
        // String<String> stream3 = stream1.filter(letter -> letter.length() == 3).filter(letter -> letter.startsWith("a"));
        // we will get wrong answer

        // limit and skip
        System.out.println("---------------------------------");
        list.stream().skip(1).limit(2).forEach(letter -> System.out.println(letter));

        // distinct() rely on the equals() and hashCode() method of the object to remove the duplicate elements
        // so if we write our own class, we need to override the equals() and hashCode() method
        System.out.println("---------------------------------");
        list.stream().distinct().forEach(letter -> System.out.println(letter));

        // concat two streams
        System.out.println("---------------------------------");
        Stream<String> stream3 = Stream.of("a", "b", "c");
        Stream<String> stream4 = Stream.of("d", "e", "f");
        Stream.concat(stream3, stream4).forEach(letter -> System.out.println(letter));

        // two-column collection
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);
        hm.put("d", 4);

        // we need to use keySet() to get the key set of the hashmap,then get the stream
        System.out.println("---------------------------------");
        hm.keySet().stream().forEach(key -> System.out.println(key));

        hm.entrySet().stream().forEach(entry -> System.out.println(entry));


        // how to use stream with array by using Arrays.stream()
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("---------------------------------");
        Arrays.stream(arr).forEach(num -> System.out.println(num));

        Stream.of(1, 2, 3, 5, 7, 2, 6, 7).forEach(num -> System.out.println(num));

        // map() method
        System.out.println("---------------------------------");
        ArrayList<String> ls = new ArrayList<>();
        Collections.addAll(ls, "Jennie-24", "Lisa-23", "Rose-25", "Jisoo-26");


        ls.stream().map(new Function<String, Integer>() {
            @Override
            // s represents every single element in the list
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        }).forEach(age -> System.out.println(age));

        // we can use lambda expression to simplify the code
        Object[] ob = ls.stream().map(s -> Integer.parseInt(s.split("-")[1])).toArray();
        System.out.println(Arrays.toString(ob));
        long cnt = ls.stream().count();
        System.out.println(cnt);
    }
}
