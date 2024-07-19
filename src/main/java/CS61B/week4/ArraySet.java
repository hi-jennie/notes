package CS61B.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// implements Iterable<T> to tell the compiler that we have an iterator method, so we can use the fancy and advanced for each
public class ArraySet<T> implements Iterable<T> {
    // Default initial capacity
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    // Constructor
    public ArraySet() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        ArraySet<Integer> set = new ArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        // only class that implements the Iterable<T> can use the advanced for-each traverse method.
        for (Integer i : set) {
            System.out.println(i);
        }

        System.out.println(set);
    }

    // T... stuff: 这是一个可变参数（varargs），表示可以传递零个或多个类型为 T 的参数。可变参数实际上是一个数组，因此在方法内部，stuff 被当作 T[] 处理。
    public static <T> ArraySet<T> of(T... stuff) {
        // 创建一个新的 ArraySet 实例，returnSet 用于存储传入的元素。
        ArraySet<T> returnSet = new ArraySet<T>();
        // 使用增强的 for 循环遍历 stuff 数组中的每个元素。
        for (T x : stuff) {
            // 将当前元素 x 添加到 returnSet 中。
            returnSet.add(x);
        }
        return returnSet;
    }

    // Adds an element to the set
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        if (size == elements.length) {
            resize();
        }
        elements[size] = element;
        size++;
        return true;
    }

    // Removes an element from the set
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                elements[i] = elements[size - 1];
                elements[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    // Checks if the set contains an element
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Gets the size of the set
    public int size() {
        return size;
    }

    // Checks if the set is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clears the set
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    // Resizes the array
    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    // because the ArraySetIterator is private, so we write an iterator() method to gain access to the iterator
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    /**
     * @Override public String toString() {
     * StringBuilder sb = new StringBuilder("{");
     * for (int i = 0; i < size; i++) {
     * if (i == size - 1) {
     * sb.append(elements[i]);
     * sb.append("}");
     * break;
     * }
     * sb.append(elements[i]);
     * sb.append(",");
     * }
     * return sb.toString();
     * }
     */

    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return STR."{\{String.join(",", listOfItems)}}";
    }

    @Override
    public boolean equals(Object other) {
        // it's a convention to check if this and other are the same object
        if (this == other) {
            return true;
        }
        if (other instanceof ArraySet otherSet) {
            // it's a convention to check if the size is the same
            if (this.size != otherSet.size) {
                return false;
            }
            for (T x : this) {
                if (!otherSet.contains(x)) {
                    return false;
                }
            }
            // after checking all the possible false cases, we can return true
            return true;
        }
        return false;
    }

    // create an inner iterator class
    private class ArraySetIterator implements Iterator<T> {
        private int position;

        public ArraySetIterator() {
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return size > position;
        }

        @Override
        public T next() {
            T returnItem = elements[position];
            position++;
            return returnItem;
        }
    }
}