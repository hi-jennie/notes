package CS61B.week6;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        System.out.println(noUniques(arr));
    }

    public static boolean noUniques(int[] array) {
        // assume that this int[] array is sorted
        int l = array.length;

        for (int i = 0; i < l; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < l; j++) {
                // i!=j represents that we don't compare the same element
                if (i != j && array[i] == array[j]) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (!hasDuplicate) {
                return false;
            }
        }
        // this step represents that every element has a duplicate
        return true;
    }
}
