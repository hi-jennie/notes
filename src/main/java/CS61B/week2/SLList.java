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

    /**
     * we change first to a sentinel, making this class more general, we can avoid it that the first IntNode is a null
     * if the first IntNode is a null (using constructor with args),then the addLast method will produce an exception(.next)
     */
    private IntNode sentinel;
    private int size;

    public SLList(){
        // the item of the sentinel can be any number
        sentinel = new IntNode(0,null);
        size = 0;
    }
    public SLList(int i){
        sentinel = new IntNode(0,null);
        sentinel.next = new IntNode(i,null);
        size = 1;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    // add item to the beginning of the list;
    public void addFirst(int i){
        sentinel.next = new IntNode(i, sentinel.next);
        size++;
    }

    // add item to the end of the list;
    public void addLast(int i){
        IntNode p = sentinel;
        // help us reach the end of the list
        while(p.next!=null){
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
