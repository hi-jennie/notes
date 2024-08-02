package CS61B.Practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class JavaMap {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();

        // put (add and overlap)
        // if the key is already in the map, the value will be replaced and return the old value
        m.put("Marty", "Step");
        m.put("Stuart", "Reges");
        m.put("Jessica", "Miller");
        System.out.println(m.put("Marty", "Camp"));// Step

        // remove
        m.remove("Marty");
        System.out.println(m.containsKey("Marty"));
        // false
        System.out.println(m.containsKey("Stuart"));
        // true

        // isEmpty
        System.out.println(m.isEmpty()); // false

        System.out.println(m.size()); // 2


        Map<String, String> m2 = new HashMap<>();
        m2.put("Jennie", "Rustin");
        m2.put("AoBy", "Turkey");
        // 1. keySet
        Set<String> keys = m2.keySet();
        for (String key : keys) {
            System.out.println(key + " " + m2.get(key));
        }

        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = m2.get(key);
            System.out.println(key + " " + value);
        }

        keys.forEach(key -> System.out.println(key + " " + m2.get(key)));

        // 2. entrySet
        Set<Map.Entry<String, String>> entries = m2.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // lambda
        m2.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + " " + value);
            }
        });
    }
}
