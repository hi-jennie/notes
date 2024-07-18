package CS61B.week4;

// Dog class implements Comparable interface and it has to rewrite the compareTo method
public class Dog implements Comparable<Dog> {
    private final String type;
    private final int size;

    public Dog(String type, int size) {
        this.type = type;
        this.size = size;
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
}
