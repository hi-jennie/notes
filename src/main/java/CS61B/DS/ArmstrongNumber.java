package CS61B.DS;

import java.util.ArrayList;

public class ArmstrongNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 9999; i++) {
            ArrayList<Integer> pows = new ArrayList<>();
            int temp = i;
            while (temp != 0) {
                int currPow = temp % 10;
                pows.add(currPow);
                temp = temp / 10;
            }

            double sum = 0;
            for (int j = 0; j < pows.size(); j++) {
                sum = sum + Math.pow(pows.get(j), pows.size());
            }

            if (sum == i) {
                System.out.println(i);
            }
        }

    }
}
