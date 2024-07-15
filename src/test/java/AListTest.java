import CS61B.week3.AList;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class AListTest {

    @Test
    public void removeTest() {
        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] expected = {1, 2, 3, 4, 5, 6, 8, 9, 0};
        AList.remove(6);
        assertThat(integers).isEqualTo(expected);
    }
}
