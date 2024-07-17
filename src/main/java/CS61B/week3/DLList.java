package CS61B.week3;

public class DLList {
    Node sentinel;

    public DLList() {

    }

    public void removeDuplicates() {
        Node ref = sentinel.next;
        Node checker;
        while (ref != sentinel) {
            // ref is the node we are checking for duplicates;
            
            // checker is used to traverse the rest of the list
            checker = ref.next;
            while (checker != sentinel) {
                if (checker.item == ref.item) {
                    // use checkerPrev and checkerNext to avoid null pointer exception
                    Node checkerPrev = checker.prev;
                    Node checkerNext = checker.next;

                    checkerPrev.next = checker.next;
                    checkerNext.prev = checker.prev;
                    checker = checkerNext;
                } else {
                    checker = checker.next;
                }
            }
            ref = ref.next;
        }
    }

    public class Node {
        int item;
        Node prev;
        Node next;
    }
}
