package CS61B.week3;


/**
 * AList that can be used to store arbitrarily long lists of data, similar to our DLList.
 * Unlike the DLList, the AList will use arrays to store data instead of a linked list.
 */
public class AList<T> {
    private static int size;
    private T[] items;

    public AList() {
        // items = new int[100];
        // 不能直接用new T[],因为没有T是什么类型，编译器不知道什么意思
        items = (T[]) new Object[100];
        size = 0;
    }

    public T get(int i) {
        return items[i];
    }

    public T getLast() {
        return items[size - 1];
    }

    public void resize(int i) {
        T[] a = (T[]) new Object[i];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void downSize() {
        if (size * 4 < items.length) {
            T[] a = (T[]) new Object[items.length / 2];
            System.arraycopy(items, 0, a, 0, size);
            items = a;
            downSize();
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
        T item = items[index];
        while (index < size - 1) {
            items[index] = items[index + 1];
            index++;
        }
        // clear the last element
        items[size - 1] = null;
        size--;
        downSize();

        return item;
    }

    public void main(String[] args) {
        AList<Integer> aL = new AList<>();
        for (int i = 0; i < 10; i++) {
            aL.addLast(i);
        }
        aL.remove(9);
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }

        System.out.println(items.length);
    }
}
