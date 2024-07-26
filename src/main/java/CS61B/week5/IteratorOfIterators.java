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
            if (integerIterator.hasNext()) {
                iterators.add(integerIterator);
            }
        }

    }

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
