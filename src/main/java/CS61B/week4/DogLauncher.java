package CS61B.week4;

import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Sture", 9);
        Dog d3 = new Dog("Benjamin", 15);
        Dog[] dogs = new Dog[]{d1, d2, d3};

        Dog maxDog = Maximizer.max(dogs);
        System.out.println(maxDog.toString());

        //  convention:we often use get to instantiate to an inner class
        // instead of Dog.NameComparator nc = new Dog.NameComparator();
        Comparator<Dog> nc = Dog.getComparator();
        if (nc.compare(d1, d2) > 0) {
            d1.bark();
        } else {
            d2.bark();
        }
    }
}
