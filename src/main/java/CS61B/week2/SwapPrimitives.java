package CS61B.week2;

public class SwapPrimitives {
    public static class IntWrapper{
        int value;
        IntWrapper(int x){
            this.value = x;
        }
    }

    public static void swap(IntWrapper a,IntWrapper b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        IntWrapper wrapperA = new IntWrapper(a);
        IntWrapper wrapperB = new IntWrapper(b);

        swap(wrapperA,wrapperB);
        a = wrapperA.value;
        b = wrapperB.value;

        System.out.println(a);
        System.out.println(b);
    }
}
