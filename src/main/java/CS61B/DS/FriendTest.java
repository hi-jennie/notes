package CS61B.DS;

import CS61B.Practice.Friend;

import java.util.Arrays;
import java.util.Comparator;

public class FriendTest {
    public static void main(String[] args) {
        Friend f1 = new Friend("Alice", 20, 5.5);
        Friend f2 = new Friend("Bob", 20, 5.5);
        Friend f3 = new Friend("Charlie", 20, 5.6);

        Friend[] friends = {f1, f2, f3};

        // actually we create a FriendComparator class to implement the Comparator interface
        Arrays.sort(friends, new Comparator<Friend>() {
            @Override
            public int compare(Friend o1, Friend o2) {
                double temp = o1.getAge() - o2.getAge();

                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;

                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;


                if (temp < 0) {
                    return -1;
                } else if (temp > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(Arrays.toString(friends));
    }
}
