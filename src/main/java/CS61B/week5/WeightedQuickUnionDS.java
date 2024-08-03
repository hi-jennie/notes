package CS61B.week5;

public class WeightedQuickUnionDS implements DisJointSets {
    private final int[] root;
    private final int[] size;

    public WeightedQuickUnionDS(int n) {
        root = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = -1; // 每个节点的根初始化为-1
            size[i] = 1; // 每个集合的初始大小为1
        }
    }

    // solution 2
    private static int find2(int val) {
        int p = root(val);
        if (p == -1) {
            return val;
        } else {
            int r = find2(p);
            // using path compression. 
            setParent(val, r);
            return r;
        }

    }

    private static void setParent(int val, int r) {
    }

    public static int root(int i) {
        return 1;
    }

    // 查找操作， 带路径压缩
    private int find(int p) {
        if (root[p] != -1) {
            root[p] = find(root[p]); // 路径压缩
            // p = root[p]; ——前移动一位
            // p = find(p);
        }
        return root[p];
    }

    @Override
    public void connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            // 将小树连接到大树上
            if (size[rootP] < size[rootQ]) {
                root[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                root[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
