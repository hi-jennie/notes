package CS61B.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class MethodReference {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 3, 57, 89};
        // use lambda expression
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        // use method reference
        Arrays.sort(arr, MethodReference::compare);
        System.out.println(Arrays.toString(arr));
        /*
        使用method reference的时候，我们需要注意以下几点：
        1.it has to be functional interface
        2.the method is already defined
        3.the parameter and return type of the method should be the same as the functional interface
        4.the method is able to satisfy the requirements
         */


        /*
        we want to cast the array of string to the array of Integer
         */
        ArrayList<String> list = new ArrayList<>();

        // use lambda expression
        Collections.addAll(list, "1", "2", "3", "4", "5");
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });

        // use method reference
        list.stream().map(Integer::parseInt).forEach(s -> System.out.println(s));

    }

    public static int compare(int o1, int o2) {
        return o2 - o1;
    }
}
