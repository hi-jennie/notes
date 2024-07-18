package CS61B.week4;


import java.util.Comparator;

// Dog class implements Comparable interface and it has to rewrite the compareTo method
public class Dog implements Comparable<Dog> {
    private final String type;
    private final int size;

    public Dog(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public static Comparator<Dog> getComparator() {
        return new NameComparator();
    }

    @Override
    public int compareTo(Dog daDog) {
        return this.size - daDog.size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return STR."\{this.getType()} \{this.getSize()}";


    }

    public void bark() {
        System.out.println(this.type + " barkkkkkk");
    }

    //  convention:we often use get to instantiate to an inner class
    // instead of Dog.NameComparator nc = new Dog.NameComparator();
    private static class NameComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog a, Dog b) {
            return Integer.compare(a.size, b.size);
            // 也可以按照其他的标准排序
            // return a.type.compareTo(b.type);
        }
    }
}
