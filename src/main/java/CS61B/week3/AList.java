package CS61B.week3;


/**
 * AList that can be used to store arbitrarily long lists of data, similar to our DLList.
 * Unlike the DLList, the AList will use arrays to store data instead of a linked list.
 */

public class AList<T> {
    private int size;
    private T[] items;

    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public T get(int i) {
        if (i >= 0 && i < size) {
            return items[i];
        } else {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
    }

    public T getLast() {
        if (size > 0) {
            return items[size - 1];
        } else {
            throw new IllegalStateException("List is empty.");
        }
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void downSize() {
        while (size * 4 < items.length && items.length > 100) {
            resize(items.length / 2);
        }
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
        size++;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T item = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[size - 1] = null;
        size--;
        downSize();
        return item;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return items.length;
    }
}

class AListDemo {
    public static void main(String[] args) {
        AList<Integer> aL = new AList<>();
        for (int i = 0; i < 10; i++) {
            aL.addLast(i);
        }
        aL.remove(9);
        for (int i = 0; i < aL.getSize(); i++) {
            System.out.println(aL.get(i));
        }

        System.out.println(aL.getCapacity());
    }
}
//public class AList<T> {
//    private int size;
//    private T[] items;
//
//    public AList() {
//        // items = new int[100];
//        // 不能直接用new T[],因为没有T是什么类型，编译器不知道什么意思
//        items = (T[]) new Object[100];
//        size = 0;
//    }
//
//    public T get(int i) {
//        return items[i];
//    }
//
//    public T getLast() {
//        return items[size - 1];
//    }
//
//    public void resize(int i) {
//        T[] a = (T[]) new Object[i];
//        System.arraycopy(items, 0, a, 0, size);
//        items = a;
//    }
//
//    public void downSize() {
//        if (size * 4 < items.length) {
//            T[] a = (T[]) new Object[items.length / 2];
//            System.arraycopy(items, 0, a, 0, size);
//            items = a;
//            downSize();
//        }
//    }
//
//    public void addLast(T item) {
//        if (size == items.length) {
//            resize(size * 2);
//        }
//        items[size] = item;
//        size++;
//    }
//
//    public T remove(int index) {
//        T item = items[index];
//        for (int i = index; i < size - 1; i++) {
//            items[i] = items[i + 1];
//        }
//        // clear the last element
//        items[size - 1] = null;
//        size--;
//        downSize();
//
//        return item;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void main(String[] args) {
//        AList<Integer> aL = new AList<>();
//        for (int i = 0; i < 10; i++) {
//            aL.addLast(i);
//        }
//        aL.remove(9);
//        for (int i = 0; i < aL.size; i++) {
//            System.out.println(get(i));
//        }
//
//        System.out.println(aL.items.length);
//    }
//}
