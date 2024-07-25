package CS61B.week5;

public class QucikUnionDS implements DisJointSets {
    private final int[] root;

    public QucikUnionDS(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = -1;
        }
    }

    // we try to fine the of p
    private int find(int p) {
        int r = p;
        if (root[r] > 0) {
            r = root[r];
        }
        return r;
    }

    @Override
    public void connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        // 将p的根结点指向q的根结点
        root[rootP] = rootQ;
        // root[rootQ] = rootP;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
