package CS61B.week2;

public class SLList {
    // nested class
    // pay attention to the private and static modifier
    // private:the user of SLList don't have to know the details of the IntNode class
    // Static:IntNode class needn't know other instance fields and instance methods of SLList
    private static class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i,IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode first;
    private int size;

    public SLList(int i){
        first = new IntNode(i,null);
        size = 1;
    }

    public int getFirst(){
        return first.item;
    }

    // add item to the beginning of the list;
    public void addFirst(int i){
        first = new IntNode(i,first);
        size++;
    }

    // add item to the end of the list;
    public void addLast(int i){
        IntNode p = first;
        // help us reach the end of the list
        while(!(p.next==null)){
            p = p.next;
        }
        p.next = new IntNode(i,null);
        size++;
    }

    // helper method
    /**
    private static int size(IntNode p){
        if(p.next==null){
            return 1;
        }
        return 1+size(p.next);
    }*/

    // the true size() method that user can use,more readable;
    /*8
    public int size(){
        return size(first);
    }*/

    public int size(){
        return size;
    }
    public static void main(String[] args) {
        SLList s = new SLList(15);
        s.addFirst(10);
        s.addFirst(5);
        s.addLast(20);
        System.out.println(s.size());
    }
}
