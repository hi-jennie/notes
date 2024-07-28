package CS61B.Practice;

public class Friend {
    private final String name;
    private final int age;
    private final double height;

    public Friend(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return STR."Friend{name='\{name}\{'\''}, age=\{age}, height=\{height}\{'}'}";
    }
//    @Override
//    public int compare(Friend o1, Friend o2) {
//        if (o1.age > o2.age) {
//            return 1;
//        } else if (o1.age < o2.age) {
//            return -1;
//        } else {
//            if (o1.height > o2.height) {
//                return 1;
//            } else if (o1.height < o2.height) {
//                return -1;
//            } else {
//                return o1.name.compareTo(o2.name);
//            }
//        }
//    }
//

}
