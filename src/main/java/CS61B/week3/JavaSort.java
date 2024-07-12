package CS61B.week3;

public class JavaSort {


    public static void javaSort(String[] x) {
        sortHelper(x, 0);
    }

    public static void sortHelper(String[] x, int start) {
        int sIndex = findSmallestIndex(x, start);
        swap(x, start, sIndex);
        // ++start 表示先自增然后于x.length比较
        if (++start < x.length) {
            sortHelper(x, start);
        }


    }

    // find the index of smallest item,
    public static int findSmallestIndex(String[] x, int start) {
        int sIndex = start;

        for (int i = start; i < x.length; i++) {
            if (x[i].compareTo(x[sIndex]) < 0) {
                sIndex = i;
            }
        }
        return sIndex;
    }

    public static void swap(String[] x, int start, int end) {
        String temp = x[start];
        x[start] = x[end];
        x[end] = temp;
    }
}
