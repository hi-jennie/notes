package CS61B.Practice;

import java.util.Arrays;

public class MethodReference {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 3, 57, 89};
        // use lambda expression
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        // use method reference
        Arrays.sort(arr, MethodReference::compare);
        /*
        使用method reference的时候，我们需要注意以下几点：
        1.it has to be functional interface
        2.the method is already defined
        3.the parameter and return type of the method should be the same as the functional interface
        4.the method is able to satisfy the requirements
         */
    }

    public static int compare(int o1, int o2) {
        return o2 - o1;
    }
}
