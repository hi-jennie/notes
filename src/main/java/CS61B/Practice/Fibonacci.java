package CS61B.Practice;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(12));
    }

    // recursion
    public static int fibonacci(int i) {
        if (i == 2 || i == 1) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    // iteration
    public static int fibonacci2(int i) {
        int[] arr = new int[i];
        arr[0] = 1;
        arr[1] = 1;
        for (int j = 2; j < i; j++) {
            arr[j] = arr[j - 1] + arr[j - 2];
        }
        return arr[i - 1];
    }

}
