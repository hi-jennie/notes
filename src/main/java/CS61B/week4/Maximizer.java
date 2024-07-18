package CS61B.week4;

public class Maximizer {
    // max accepts an array of objects that implement the Comparable interface
    // when we call the max method, the compiler will check the parameter we pass in to see if it implements the Comparable interface
    // because the items that implement the Comparable interface have the compareTo method, we can call the compareTo method
    public static <T extends Comparable<T>> T max(T[] items) {
        // check if the array is null or empty
        if (items == null || items.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        T maxItem = items[0];
        if (maxItem == null) {
            // check if the first item is null
            throw new IllegalArgumentException("First item must not be null");
        }
        for (int i = 1; i < items.length; i++) {
            T currentItem = items[i];
            // check if the current item is null
            if (currentItem == null) {
                throw new IllegalArgumentException("Array must not contain null elements");
            }
            if (currentItem.compareTo(maxItem) > 0) {
                maxItem = currentItem;
            }
        }
        return maxItem;
    }
}
