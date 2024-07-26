package CS61B.DS;

public class BlockSearch {
    public static void main(String[] args) {
        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 38, 61, 52, 73, 66};
        Block b1 = new Block(21, 0, 5);
        Block b2 = new Block(45, 6, 11);
        Block b3 = new Block(73, 12, 17);

        Block[] blocks = {b1, b2, b3};

        int i = getIndex(arr, blocks, 21);
        System.out.println(i);
    }

    private static int getIndex(int[] arr, Block[] blocks, int i) {
        int blockIndex = getBlockIndex(blocks, i);

        if (blockIndex < 0) {
            System.out.println("can't find");
            return -1;
        }
        Block cur = blocks[blockIndex];

        for (int j = cur.startIndex; j <= cur.endIndex; j++) {
            if (arr[j] == i) {
                return j;
            }
        }
        return -1;
    }

    private static int getBlockIndex(Block[] blocks, int i) {
        for (int j = 0; j < blocks.length; j++) {
            if (i <= blocks[j].maxItem) {
                return j;
            }
        }
        return -1;
    }

    public static class Block {
        int maxItem;
        int startIndex;
        int endIndex;

        public Block(int maxItem, int startIndex, int endIndex) {
            this.maxItem = maxItem;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }
}
