package CS61B.Practice;

import java.util.ArrayList;

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
    }
}
