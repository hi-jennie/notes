package CS61B.Practice;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamCollect {
    public static void main(String[] args) {
        practice1();
        practice2();
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

    public static void practice1() {
        ArrayList<String> families = new ArrayList<>();
        Collections.addAll(families, "Jennie,24", "Rustin,28", "Aobi,2", "Turkey,2", "hah", "hah1");
        Map<String, Integer> map = families.stream().filter(s -> s.length() > 4).collect(Collectors.toMap(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split(",")[0];
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split(",")[1]);
            }
        }));
        System.out.println(map);

        Map<String, Integer> map1 = families.stream().filter(s -> s.length() > 4).collect(Collectors.toMap(str -> str.split(",")[0], str -> Integer.parseInt(str.split(",")[1])));
        System.out.println(map1);
    }

    public static void practice2() {
        class Actor {
            final String name;
            final int age;

            Actor(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }

        ArrayList<String> actors = new ArrayList<>();
        Collections.addAll(actors, "Jac,30", "Chris,40", "Tom,50", "Robert,60");
        ArrayList<String> actresses = new ArrayList<>();
        Collections.addAll(actresses, "Scarlett,30", "Elizabeth,40", "Gwyneth,50", "Natalie,60");

        Stream<String> actorStream = actors.stream().filter(actor -> actor.split(",")[0].length() == 3);
        Stream<String> actressStream = actresses.stream().filter(actress -> Integer.parseInt(actress.split(",")[1]) > 40);

        List<Actor> wrapActors = Stream.concat(actressStream, actorStream).map(new Function<String, Actor>() {
            @Override
            public Actor apply(String s) {
                return new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1]));
            }
        }).collect(Collectors.toList());

        wrapActors.forEach(actor -> System.out.println(actor.name + " " + actor.age));
    }
}
