package CS61B.Practice;

public class Peach {
    // monkey eat peach problem
    // 10th day, monkey eat the last peach, how many peaches on the 1st day

    public static void main(String[] args) {
        System.out.println(sum(10, 1));
        System.out.println(getCount(2));
    }

    public static int sum(int day, int remains) {
        if (day == 1) {
            return remains;
        }
        return sum(day - 1, 2 * (remains + 1));
    }

    public static int getCount(int day) {
        if (day <= 0 || day >= 11) {
            System.out.println("wrong date");
            return -1;
        }

        if (day == 10) {
            return 1;
        }

        // better, we can get the remains on every day;
        // backtracking
        return (getCount(day + 1) + 1) * 2;
    }
}
