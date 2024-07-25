package CS61B.week5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator<OHRequest> {
    private OHRequest curr;

    public OHIterator(OHRequest request) {
        curr = request;
    }

    public static boolean isGood(String description) {
        return description.length() >= 5;
    }

    public OHRequest getCurr() {
        return curr;
    }

    @Override
    public boolean hasNext() {
        // iterate with condition
        // before reach the end of the queue,wo skip all the item that isn't good(isGood);
        while (curr != null && !isGood(curr.description)) {
            curr = curr.next;
        }

        // used to check which condition stop the while loop;
        // if the curr!=null ,means that we reach an item that is good,return ture
        // 现在的curr 其实就是符合条件的下一个，可以next()中直接用
        return curr != null;
    }

    @Override
    public OHRequest next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        OHRequest temp = curr;
        curr = curr.next;
        return temp;
    }

}