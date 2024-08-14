package CS61B.Practice;

import java.util.Scanner;

public class JavaException {
    public static void main(String[] args) {
        JavaException je = new JavaException();
        Student s = je.new Student("Alice", 20);
        s.setAge(1);
        je.practice();
//        je.tryCatch();

        try {
            je.javaThrow(new int[]{});
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void tryCatch() {
        int[] arr = {1, 2, 3};
        try {
            // code that may throw an exception
            System.out.println(arr[3]);
            // if there are more than one exception, the first exception will be caught
            // we need to write multiple catch blocks to catch multiple exceptions
            // ArithmeticException | ArrayIndexOutOfBoundsException e can be in the same catch block
            System.out.println(2 / 0);

            // won't be executed
            System.out.println(arr[2]);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            e.printStackTrace();// red error message
        } catch (Exception e) {
            // the parent class of all exceptions should be at the end
            e.printStackTrace();
        } finally {
            // code that runs regardless of whether an exception was thrown
            System.out.println("End of tryCatch");
        }
        // code that runs regardless of whether an exception was thrown
        System.out.println("End of tryCatch");
    }

    public int javaThrow(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null");
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public void practice() {
        Scanner scan = new Scanner(System.in);
        Student s = new Student();
        while (true) {
            try {
                System.out.println("enter name");
                String name = scan.nextLine();
                s.setName(name);

                System.out.println("enter age");
                String age = scan.nextLine();
                s.setAge(Integer.parseInt(age));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("illegal name or age");
            }
        }
        System.out.println(s.getName() + " " + s.getAge());
    }

    public class Student {
        private String name;
        private int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) throws NameFormatException {
            if (name == null || name.length() < 3 || name.length() > 10) {
                throw new NameFormatException("Name cannot be null or empty");
            }
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            if (age < 0 || age > 40) {
                // two function of exception:
                // 1. throw an exception and notify the caller what happened down there
                // 2.help us to debug the code
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.age = age;
        }

        public class NameFormatException extends Exception {
            public NameFormatException() {
            }

            public NameFormatException(String message) {
                super(message);
            }
        }
    }


}
