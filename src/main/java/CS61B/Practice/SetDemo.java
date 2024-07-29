package CS61B.Practice;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        // Set is an interface, HashSet is a class
        // Set extends Collection
        Set<String> persons = new HashSet<>();

        boolean p1 = persons.add("Jennie");
        boolean p2 = persons.add("Rustin");
        persons.add("AuBy");
        persons.add("Turkey");
        boolean p3 = persons.add("Jennie");// return false

        // not in order [Turkey, AuBy, Rustin, Jennie]
        System.out.println(persons);

        // iterate
        Iterator<String> it = persons.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String person : persons) {
            System.out.println(person);
        }

        persons.forEach(str -> System.out.println(str));

        System.out.println("-------------------");

        // in order to keep no duplicate elements and keep in order, we adopt LinkedHashSet
        // normally,use HashSet
        Set<Integer> numbers = new LinkedHashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(3);// false

        // 存、取顺序一致
        numbers.forEach(num -> System.out.println(num));

        System.out.println("-------------------");

        // 如果自定义类，需要实现comparable接口充血compareTo方法或者传入comparator
        TreeSet<Integer> numbers1 = new TreeSet<>();
        numbers1.add(3);
        numbers1.add(1);
        numbers1.add(2);
        numbers1.add(6);

        numbers1.forEach(num -> System.out.println(num));

        System.out.println("-------------------");

        // 使用comparator比较(or comparable<>)
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            // o1 represent the element we want to insert, o2 represent the element in the set
            public int compare(String o1, String o2) {
                // sort according to the length of the string first
                int i = o1.length() - o2.length();

                // if the length is the same, sort according to the lexicographical order
                i = i == 0 ? o1.compareTo(o2) : i;
                return 0;
            }
        });

    }
}
