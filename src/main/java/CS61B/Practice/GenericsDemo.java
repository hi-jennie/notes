package CS61B.Practice;

import CS61B.week2.CS61BStudent;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Maine> maines = new ArrayList<>();
        ArrayList<CS61BStudent> students = new ArrayList<>();

        method(animals);
//      method(cats); error,because method only accept ArrayList<Animal>
//      method(maines);

        // the three lines below is OK because of the generic method
        // this is a problem because any type of the ArrayList can be passed in
        method1(animals);
        method1(cats);
        method1(maines);
        method1(students);

        method2(animals);
        method2(cats);
        method2(maines);

    }

    public static void method(ArrayList<Animal> list) {

    }

    public static <T> void method1(ArrayList<T> list) {

    }

    // <? extends Animal> represents that the type of the ArrayList must be a subclass of Animal,including Animal itself
    // <? super Animal> represents that the type of the ArrayList must be a superclass of Animal,including Animal itself
    public static void method2(ArrayList<? extends Animal> list) {

    }

    class Animal {

    }

    class Cat extends Animal {

    }

    class Maine extends Cat {

    }


}
