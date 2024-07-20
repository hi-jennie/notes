package CS61B.week4;

public class DMSList {
    private final IntNode sentinel;

    public DMSList() {
        // new LastIntNode serve as another sentinel(the end one)
        sentinel = new IntNode(-1000, new LastIntNode());
    }

    /* Returns 0 if a list is empty. Otherwise, returns the max element. */
    public int max() {
        // dynamic method calling:if a list is empty,sentinel.next will point at the LastInrNode, and call the max method of LastInrNode---return 0；
        // if not empty,sentinel.next will point at the IntNode and call the max method of IntNode.
        // when it walks through the list and reaches the end of the list, it will also call the max method of LastIntNode and terminate the recursion.
        return sentinel.next.max();
    }

    public void insertFront(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode h) {
            item = i;
            next = h;
        }

        public int max() {
            return Math.max(item, next.max());
        }
    }

    public class LastIntNode extends IntNode {
        public LastIntNode() {
            super(0, null);
        }

        @Override
        public int max() {
            return 0;  // 终止递归
        }
    }
}