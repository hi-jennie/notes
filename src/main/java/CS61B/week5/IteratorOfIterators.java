package CS61B.week5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorOfIterators implements Iterator<Integer> {
    LinkedList<Iterator<Integer>> iterators;

    public IteratorOfIterators(List<Iterator<Integer>> a) {
        iterators = new LinkedList<>();
        for (Iterator<Integer> integerIterator : a) {
            // if integerIterator.hasNext() == false, it represents that the current integerIterator is a sentinel
            // we don't need to add a sentinel
            // 过滤中间和首尾的空的iterator；
            if (integerIterator.hasNext()) {
                iterators.add(integerIterator);
            }
        }

    }

    /**
     * // solution 2:we get all the items at first(change the hasNext() and next() accordingly——will be easier than the first solution
     * private LinkedList<Integer> l;
     * public IteratorOfIterators(List<Iterator<Integer>> a) {
     * LinkedList<Integer> l;// 应该写在instance variable位置
     * l = new LinkedList<>();
     * // always get the first item ,just like pop();
     * // when there is no useful item in any of the iterator,we stop the loop
     * while (!a.isEmpty()) {
     * // in this situation,we may get an iterator that with no item
     * Iterator<Integer> iterator = a.removeFirst();
     * // if cur iterator hasNext,get the next item and add to the last of a(probably add an empty iterator)
     * if (iterator.hasNext()) {
     * l.addLast(iterator.next());
     * a.addLast(iterator);
     * }
     * }
     */
    @Override
    public boolean hasNext() {
        return !iterators.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Iterator<Integer> iterator = iterators.removeFirst();
        int ans = iterator.next();
        // Because we always append to the end only when the Integer iterator has a next element,
        // we can always ensure （int ans = iterator.next();）has next；
        if (iterator.hasNext()) {
            iterators.addLast(iterator);
        }
        return ans;
    }
}
