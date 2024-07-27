package CS61B.DS;

import java.util.Arrays;
import java.util.Comparator;

public class JavaLambda {
    public static void main(String[] args) {
        // solution 1
        method(new Swim() {
            @Override
            public void swimming() {
                System.out.println("I'm swimming");
            }
        });
        // solution 2
        // ()accepts the Swim interface, and the method is implemented by lambda expression
        method(() -> System.out.println("I'm swimming"));

        Integer[] arr = {1, 2, 3, 56, 7, 89, 100};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // omit new
        Arrays.sort(arr, (Integer o1, Integer o2) -> {
            return o1 - o2;
        });

        // omit the parameter type: Integer和return keywords
        Arrays.sort(arr, (o1, o2) -> o1 - o2);

        String[] str = {"Jennie", "Rustin", "ldp", "aoBy"};
        System.out.println(Arrays.toString(practice(str)));
    }

    // method accept a class that implements Swim interface
    public static void method(Swim s) {
        s.swimming();
    }

    public static String[] practice(String[] arr) {
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        return arr;
    }

    // this annotation represent that this is a functional interface
    @FunctionalInterface
    interface Swim {
        void swimming();
    }
}
