import CS61B.week3.JavaSort;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;


public class JavaSortTest {
    @Test
    public void javaSortTest() {
        String[] input = {"cc", "dd", "aa", "bb"};
        String[] expected = {"aa", "bb", "cc", "dd"};
        // 原地修改input
        JavaSort.javaSort(input);

        assertThat(input).isEqualTo(expected);
    }

    @Test
    public void findSmallestIndexTest() {
        String[] input = {"cc", "dd", "aa", "bb"};
        int expected = 2;
        int actual = JavaSort.findSmallestIndex(input, 0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void swapTest() {
        String[] input = {"cc", "dd", "aa", "bb"};
        String[] expected = {"aa", "bb", "cc", "dd"};
        JavaSort.swap(input, 0, 2);
        JavaSort.swap(input, 1, 3);

        assertThat(input).isEqualTo(expected);
    }
    
}
