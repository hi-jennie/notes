package CS61B.Practice;

import java.util.Comparator;
import java.util.TreeMap;

public class JavaTreeMap {
    public static void main(String[] args) {
        // Comparator prioritise over Comparable of String (the key)
        TreeMap<String, Integer> families = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        families.put("Jennie", 24);
        families.put("Rustin", 28);
        families.put("AoBy", 2);
        families.put("Turkey", 2);

        // Sorted in ascending order by default
        // String and Integer implements Comparable interface,they are sorted in ascending order
        // {AoBy=2, Jennie=24, Rustin=28, Turkey=2}
        System.out.println(families);

        TreeMap<Student, String> students = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int cmp = o1.getId() - o2.getId();
                cmp = cmp == 0 ? o1.getName().compareTo(o2.getName()) : cmp;

                // if (cmp == 0) represent this two students have the same id and name,they should be the same student
                // these will be used to determine whether two students are the same student(to avoid duplicate)
                return cmp;
                // 如果返回值是0，表示两个对象是相等的，TreeMap会认为是同一个对象，不会插入
                // 如果返回值是正数，表明o1比o2大，o1会存在红黑树右边
                // 如果返回值是负数，表明o1比o2小，o1会存在红黑树左边
            }
        });

        // 先按照id排序，ID一样再按照name升序排序

        Student s1 = new Student("Jennie", 24);
        Student s2 = new Student("Jennie", 24);

        students.put(s1, "China");
        students.put(new Student("Rustin", 28), "USA");
        students.put(new Student("AoBy", 2), "Vietnam");
        students.put(new Student("Turkey", 2), "Turkey");
        students.put(s2, "Chi");

        // {Student{name='AoBy', id=2}=Vietnam, Student{name='Turkey', id=2}=Turkey, Student{name='Jennie', id=24}=China, Student{name='Rustin', id=28}=USA}
        System.out.println(students);

        System.out.println(countFrequency("aababcabcdabcde"));
    }

    public static TreeMap<Character, Integer> countFrequency(String str) {
        TreeMap<Character, Integer> result = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (result.containsKey(str.charAt(i))) {
                result.put(str.charAt(i), result.get(str.charAt(i)) + 1);
            } else {
                result.put(str.charAt(i), 1);
            }
        }

        return result;
    }
}
