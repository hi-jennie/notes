package CS61B.week5;

// the real comparing value act as the index of the array,the element of the array present if the element is connected to another element
// if one connected to another,their element should be the same
public class QuickFindDS implements DisJointSets {
    private final int[] id;

    // initialize the id array, if the element is not connected to any other element, the value is -1
    // -1 also means the element is the root of the tree
    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = -1;
        }
    }

    @Override
    public void connect(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        if (pID == qID) {
            return;
        }
        // traverse the id array, change the elements of p to the element of q
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
