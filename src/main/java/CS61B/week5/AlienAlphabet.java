package CS61B.week5;

import java.util.Comparator;

public class AlienAlphabet {
    // 这个是外星人的letter 顺序
    private final String order;

    public AlienAlphabet(String alphabetOrder) {
        order = alphabetOrder;
    }

    public class AlienComparator implements Comparator<String> {

        @Override
        public int compare(String word1, String word2) {
            int minLength = Math.min(word1.length(), word2.length());
            for (int i = 0; i < minLength; i++) {
                int char1Rank = order.indexOf(word1.charAt(i));
                int char2Rank = order.indexOf(word2.charAt(i));
                if (char1Rank < char2Rank) {
                    return -1;
                } else if (char1Rank > char2Rank) {
                    return 1;
                }
            }
            // when reaches this line
            // it means that :after compare the item of minLength,One contains the other
            // if word1.length() - word2.length() return a positive number ,
            // represent word1 is longer and bigger
            return word1.length() - word2.length();
        }
    }
}
