package CS61B.week4;

import CS61B.week2.SLList;

public class VengefulSLList<Item> extends SLList<Item> {
    public SLList<Item> deletedItems;

    public VengefulSLList() {
        super();
        deletedItems = new SLList<>();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        vs1.addFirst(1);
        vs1.addFirst(2);
        vs1.addFirst(3);
        vs1.addFirst(4);

        vs1.removeLast();
        vs1.removeLast();
        SLList<Integer> deleted = vs1.deletedItems;
        System.out.println(deleted.getSize());
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addFirst(x);
        return x;
    }
}
