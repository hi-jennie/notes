package CS61B.week5;

public class TYIterator extends OHIterator {
    public TYIterator(OHRequest queue) {
        super(queue);
    }

    @Override
    public OHRequest next() {
        OHRequest result = super.next();
        //  we can ensure that when two “thank u” are adjacent, the second one is skipped immediately after the first appears.
        if (result.description.contains("thank u")) {
            super.next();
        }
        return result;
    }


    /** pay attention to the difference between them
     *
     * The improved code will directly skip all OHRequest objects
     * whose descriptions contain “thank u” until it finds one whose description does not contain “thank u,” and then return that object.
     *
     * @Override
     * public OHRequest next() {
     *     OHRequest result = super.next();
     *     while (result.description.contains("thank u")) {
     *         result = super.next();
     *     }
     *     return result;
     * }
     */
}
