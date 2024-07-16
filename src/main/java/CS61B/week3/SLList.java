package CS61B.week3;

public class SLList {
    Node sentinel;

    public SLList() {
        this.sentinel = new Node();
    }

    public int[][] grid(int rows, int cols) {
        int[][] grid = new int[rows][cols];
        gridHelper(grid, sentinel.next, 0);
        return grid;
    }

    private void gridHelper(int[][] grid, Node curr, int numFilled) {
        if (curr == sentinel || numFilled >= grid.length * grid[0].length) {
            return;
        }

        int row = numFilled / grid[0].length;
        int col = numFilled % grid[0].length;
        grid[row][col] = curr.item;

        gridHelper(grid, curr.next, numFilled + 1);
    }

    private static class Node {
        int item;
        Node next;
    }
}
