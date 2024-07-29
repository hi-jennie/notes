package CS61B.Practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class Iteration {
    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();
        strings.add("Jennie");
        strings.add("Rustin");
        strings.add("AuBy");
        strings.add("Turkey");
        strings.add("Pumpkin");
        Iterator<String> it = strings.iterator();

        System.out.println(strings);
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("Pumpkin")) {
                // use the iterator to remove the element instead of the collection
                it.remove();
            }
            System.out.println(str);
        }

        System.out.println(strings);

        // string just a variable, modify this variable will not affect the collection
        for (String string : strings) {
            System.out.println(string);
        }

        StringBuilder sb = new StringBuilder();

        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "!");
                sb.append(s);
            }
        });

        System.out.println(sb);
    }
}
