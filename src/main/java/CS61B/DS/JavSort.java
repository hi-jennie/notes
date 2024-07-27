package CS61B.DS;

public class JavSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 56, 7, 89, 100};
        int[] bubbleSortedArr = bubbleSort(arr);
        for (int i : bubbleSortedArr) {
            System.out.print(i + " ");
        }

        int[] selSortArr = selectionSort(arr);
        for (int i : selSortArr) {
            System.out.print(i + " ");
        }
    }

    // 相邻元素两两比较
    public static int[] bubbleSort(int[] arr) {
        //  arr.length - 1：The last one doesn't need to be compared, it is definitely the smallest.
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // int j = i + 1: guarantee we compare the next item of arr[i]
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }
}
