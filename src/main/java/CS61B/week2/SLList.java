package CS61B.week2;

public class SLList<T> {
    /**
     * we change first to a sentinel, making this class more general, we can avoid it that the first IntNode is a null
     * if the first IntNode is a null (using constructor with args),then the addLast method will produce an exception(.next)
     */
    private final Node<T> sentinel;
    private int size;

    public SLList() {
        // the item of the sentinel can be any number
        sentinel = new Node<T>(null, null);
        size = 0;
    }

    public SLList(T i) {
        sentinel = new Node<T>(null, null);
        sentinel.next = new Node<T>(i, null);
        size = 1;
    }

    public static void main(String[] args) {
        SLList<Integer> s = new SLList<>(15);
        s.addFirst(10);
        s.addFirst(5);
        s.addLast(20);
        System.out.println(s.getSize());
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    // add item to the beginning of the list;
    public void addFirst(T i) {
        sentinel.next = new Node<>(i, sentinel.next);
        size++;
    }

    // add item to the end of the list;
    public void addLast(T i) {
        Node<T> p = sentinel;
        // help us reach the end of the list
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node<T>(i, null);
        size++;
    }

    public Node<T> getLastNode() {
        if (sentinel.next == null) {
            return null;
        }
        Node<T> P = sentinel.next;
        while (P.next != null) {
            P = P.next;
        }
        return P;

    }

    public T removeLast() {
        Node<T> back = getLastNode();
        Node<T> p = sentinel;
        while (p.next != back) {
            p = p.next;
        }
        // p is the second to last node;
        p.next = null;
        return back.item;
    }

    // helper method

    /**
     * private static int size(IntNode p){
     * if(p.next==null){
     * return 1;
     * }
     * return 1+size(p.next);
     * }
     */

    // the true size() method that user can use,more readable;
    /*8
    public int size(){
        return size(first);
    }*/
    public int getSize() {
        return size;
    }

    // nested class
    // pay attention to the private and static modifier
    // private:the user of SLList don't have to know the details of the IntNode class
    // Static:IntNode class needn't know other instance fields and instance methods of SLList
    public static class Node<T> {
        public T item;
        public Node<T> next;

        public Node(T i, Node<T> n) {
            item = i;
            next = n;
        }
    }
}
