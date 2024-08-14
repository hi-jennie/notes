package CS61B.Practice;

public class JavaException {
    public static void main(String[] args) {
        JavaException je = new JavaException();
        Student s = je.new Student("Alice", 20);
        s.setAge(-1);
    }

    public class Student {
        private final String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setAge(int age) {
            if (age < 0) {
                // two function of exception:
                // 1. throw an exception and notify the caller what happened down there
                // 2.help us to debug the code
                throw new IllegalArgumentException("Age cannot be negative");
            }
            this.age = age;
        }
    }
}
