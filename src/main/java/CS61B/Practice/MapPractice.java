package CS61B.Practice;

import java.util.*;

public class MapPractice {
    // mock 80 students voting for 4 different tourist destinations
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        String[] arr = {"A", "B", "C", "D"};
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }

        // count the number of votes for each destination
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
        // find the destination with the most votes
        int max = 0;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > max) max = entry.getValue();
        }
        System.out.println(max);

        // find other destinations with the same number of votes
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == max) System.out.println(entry.getKey());
        }
    }

    public static class Student {
        private final String name;
        private final int age;

        public Student(String name, int id) {
            this.name = name;
            this.age = id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return age == student.age && name.equals(student.name);
        }

        @Override
        public int hashCode() {
            return 31 * name.hashCode() + age;
        }
    }
}
