package CS61B.week3;

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 13)));
    }


    public static int[] rotate(int[] A, int k) {
        int rightShift = k % A.length;
        if (rightShift < 0) {
            rightShift += A.length;
        }

        int[] newArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int newIndex = (i + rightShift) % A.length;
            newArr[newIndex] = A[i];
        }

        return newArr;
    }
}
