package CS61B.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.IntFunction;

public class ConstructorReference {
    public static void main(String[] args) {
        class Idol {
            private final String name;
            private final int age;

            public Idol(String name, int age) {
                this.name = name;
                this.age = age;
            }

            // the reason why we need to overload the constructor is that
            // the parameter of the constructor reference should be the same as apply() method
            public Idol(String origin) {
                String[] arr = origin.split("-");
                this.name = arr[0];
                this.age = Integer.parseInt(arr[1]);
            }
        }

        // now we need to cast the array of string to the array of Idol
        ArrayList<String> ls = new ArrayList<>();
        Collections.addAll(ls, "Jennie-24", "Lisa-23", "Rose-25", "Jisoo-26");
        ls.stream().map(new Function<String, Idol>() {
            @Override
            public Idol apply(String s) {
                String[] arr1 = s.split("-");
                String name = arr1[0];
                int age = Integer.parseInt(arr1[1]);
                return new Idol(name, age);
            }
        });
        // use constructor reference
        ls.stream().map(Idol::new).forEach(s -> System.out.println(s.name + " " + s.age));

        reference();
        arr();
    }

    // toUpperCase() is a instance method of String
    public static void reference() {
        String[] arr = {"aaa", "bbb", "ccc"};
        Arrays.stream(arr).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(str -> System.out.println(str));

        Arrays.stream(arr).map(String::toUpperCase).forEach(uppStr -> System.out.println(uppStr));
    }

    // Integer[]::new
    public static void arr() {
        ArrayList<Integer> ls = new ArrayList<>();
        Collections.addAll(ls, 1, 2, 3, 4, 5);
        Integer[] intArr = ls.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(intArr));

        Integer[] intArr2 = ls.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(intArr2));
    }
}
