package CS61B.week4;

public class HofDemo {
    public static int do_twice(IntUnaryFunction cls, int x) {
        //  is quite similar to Python pass in a function as parameter.
        //  but in java, we don't pass in a function as parameter directly
        // by contrast, we pass in a class that implements that function.
        return cls.apply(cls.apply(x));
    }

    public static void main(String[] args) {
        System.out.println(do_twice(new TenX(), 2));
    }
}
