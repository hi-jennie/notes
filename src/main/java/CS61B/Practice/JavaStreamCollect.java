package CS61B.Practice;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class JavaStreamCollect {
    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<>();
        Collections.addAll(ls, "Jennie-24", "Lisa-23", "Rose-25", "Jisoo-26");

        // 1.we can use toArray() with parameter
        String[] idols1 = ls.stream().toArray(new IntFunction<String[]>() {
            @Override
            // pay attention that int value represent the length of ls
            // then we can create array according to this value;
            public String[] apply(int value) {
                return new String[value];
            }
        });
        String[] idol = ls.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(idols1));
        System.out.println(Arrays.toString(idol));

        // 2.collect data in a List---use Collectors.toList
        List<String> idols2 = ls.stream().collect(Collectors.toList());
        idols2.add("kiki-25");// 可以修改
        System.out.println(idols2);
        // List<String> idols2 = ls.stream().toList(); 不能修改
        // idols2.add("mam");
        // System.out.println(idols2);UnsupportedOperationException

        // 3.collect data in a Set(remove duplicate)
        Set<String> idols3 = idols2.stream().collect(Collectors.toSet());
        System.out.println(idols3);


        // 4.collect data in a map
        Map<String, Integer> map = ls.stream().limit(3).collect(Collectors.toMap(new Function<String, String>() {
            // Function<String, String>() the first String represent the type in the stream,the second one represents the type we gonna return
            // s represent every single element in the stream
            // the first Function is used to generate keys,the second one is used to generate values.
            @Override
            public String apply(String s) {
                return s.split("-")[0];
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        }));

        // use lambda expression to simplify
        Map<String, Integer> map2 = ls.stream().skip(3).collect(Collectors.toMap(s -> s.split("-")[0],
                s -> Integer.parseInt(s.split("-")[1])));
        System.out.println(map2);

    }
}
