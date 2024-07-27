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

        int[] insertion = insertionSort(arr);
        for (int i : insertion) {
            System.out.print(i + " ");
        }

        System.out.println(recursionSum(100));
        System.out.println(factorialRecursion(5));
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

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // There are cases of unnecessary iterations.
            // when arr[i]>arr[i-1], no need to compare with the previous elements.
//            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    swap(arr, j, j - 1);
//                }
//            }

            // used to store the original value of i;
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        return arr;
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        return arr;
    }

    // Determine the base case.
    public static int recursionSum(int i) {
        // Determine the base case.
        if (i == 1) {
            return i;
        }
        return recursionSum(i - 1) + i;
    }

    //  求阶乘
    public static int factorialRecursion(int i) {
        if (i == 1) {
            return i;
        }
        // 递归的参数要不断的接近递归基
        return i * factorialRecursion(i - 1);
    }
}
