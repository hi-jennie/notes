package CS61B.DS;

public class BasicSearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 6));
    }

    public static int binarySearch(int[] arr, int num) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        while (true) {
            // pay attention that the mid should be put inside the loop;
            int mid = (minIndex + maxIndex) / 2;
            if (minIndex > maxIndex) {
                System.out.println("out of boundaries");
                return -1;

            }
            if (num > arr[mid]) {
                minIndex = mid + 1;
            } else if (num < arr[mid]) {
                maxIndex = mid - 1;
            } else {
                return mid;
            }
        }

    }
}
