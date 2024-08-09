package CS61B.Practice;

import java.util.*;

public class ImmutableList {
    public static void main(String[] args) {
        List<String> family = List.of("Jennie", "Rustin", "AoBy", "Turkey");
        System.out.println(family.get(0));
        System.out.println(family.get(1));
        System.out.println(family.get(2));
        System.out.println(family.get(3));

        // family.add("Jennie");
        // family.remove(0);
        // all of the above will throw UnsupportedOperationException

        System.out.println("------------------------");

        // Set.of("Jennie","Jennie", "Rustin", "AoBy", "Turkey");
        // when we have duplicate elements, it will throw IllegalArgumentException
        // therefore we have to guarantee that all elements are unique
        Set<String> familySet = Set.of("Jennie", "Rustin", "AoBy", "Turkey");
        System.out.println(familySet.contains("Jennie"));
        System.out.println(familySet.contains("Jennie1"));

        Iterator<String> it = familySet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // familySet.add("Jennie1");
        // familySet.remove("Jennie");
        // all of the above will throw UnsupportedOperationException

        System.out.println("------------------------");

        // !! pay attention: no duplicate keys
        // Map.of :the maximum of parameters is 10 key-value pairs
        Map<String, Integer> families = Map.of("Jennie", 1, "Rustin", 2, "AoBy", 3, "Turkey", 4);

        System.out.println(families.get("Jennie"));// get the value of the key
        System.out.println(families.get("Rustin"));
        System.out.println(families.get("AoBy"));
        System.out.println(families.get("Turkey"));

        // keySet()
        // entrySet()


        // what if we have more than 10 key-value pairs
        // Map.ofEntries
        Map<Integer, String> familyMap = new HashMap<>();
        familyMap.put(1, "Jennie");
        familyMap.put(2, "Rustin");
        familyMap.put(3, "AoBy");
        familyMap.put(4, "Turkey");
        familyMap.put(5, "Jennie1");
        familyMap.put(6, "Rustin1");
        familyMap.put(7, "AoBy1");
        familyMap.put(8, "Turkey1");
        familyMap.put(9, "Jennie2");
        familyMap.put(10, "Rustin2");
        familyMap.put(11, "AoBy2");
        familyMap.put(12, "Turkey2");

        Set<Map.Entry<Integer, String>> entries = familyMap.entrySet();

        // we can use ofEntries() to create an immutable map
        // familyMap2 is an immutable map
        // ofEntries() accept an array as its parameter,through new Map.Entry[0] we can define the type of the array
        Map<Integer, String> familyMap2 = Map.ofEntries(entries.toArray(new Map.Entry[0]));

        // an easier one to create an immutable map
        // copyOf will return an immutable map
        Map<Integer, String> familyMap3 = Map.copyOf(familyMap);
    }
}
