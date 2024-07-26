package CS61B.DS;

import java.util.ArrayList;

public class JavaToBinaryString {
    public static void main(String[] args) {
        int i = 6;
//        String result = "";
        ArrayList<Integer> list = new ArrayList<>();
        while (i != 0) {
            int number = i % 2;
            list.add(number);
            i = i / 2;
        }
        StringBuilder result = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            // result = result + list.get(j);
            result.append(list.get(j));
        }
        System.out.println(result);

        System.out.println(toBinaryString(6));
    }

    public static String toBinaryString(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            int number = n % 2;
            result.insert(0, number);
            n = n / 2;
        }
        return result.toString();
    }
}
