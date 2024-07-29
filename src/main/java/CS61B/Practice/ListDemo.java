package CS61B.Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // remove the element at index 1
        list.remove(1);

        // remove the element 1——boxing
        Integer i = Integer.valueOf(1);
        list.remove(i);

        list.set(1, 10);

        System.out.println(list);

        // iterator
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int number = it.next();
            System.out.println(number);

        }

        // enhanced for loop
        for (Integer integer : list) {
            System.out.println(integer);
        }

        // Lambda expression
        list.forEach((Integer integer) -> System.out.println(integer));

        // normal for loop
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(i));
        }

        // ListIterator:lsIt.add()/lsIt.remove()
        ListIterator<Integer> lsIt = list.listIterator();
        while (lsIt.hasNext()) {
            Integer a = lsIt.next();
            System.out.println(a);
        }


        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add("jennie");
        System.out.println(arr);
    }
}
