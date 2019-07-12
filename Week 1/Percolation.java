import java.util.Arrays;

public class Percolation {

    public static int[][] grid;
    private Test wqf;

    private static int N = 10;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        grid = new int[n][n];

        wqf = new Test();
        wqf.QuickUnionUF(n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                grid[i][j] = 0;

            }
        }
        printArray(grid);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N)
            return;

        grid[row][col] = 1;
        // neighbours
        int right = row + 1;
        if (0 <= right && right < N && isOpen(right, col)) {

            wqf.union(to1DId(row, col), to1DId(right, col));
        }

        int left = row - 1;
        if (0 <= left && left < N && isOpen(left, col)) {

            wqf.union(to1DId(row, col), to1DId(left, col));
        }

        int top = col + 1;
        if (0 <= top && top < N && isOpen(top, col)) {

            wqf.union(to1DId(row, col), to1DId(top, col));
        }

        int bottom = col - 1;
        if (0 <= bottom && bottom < N && isOpen(bottom, col)) {

            wqf.union(to1DId(row, col), to1DId(bottom, col));
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {

        if (isOpen(row, col)) {

            for (int i = 0; i < N; i++) {

                if (wqf.connected(to1DId(row, col), i)) {

                    return true;
                }
            }

        }

        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {

        int nOpenSites = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    nOpenSites++;
                }
            }
        }
        return nOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = 0; i < N; i++) {
            if (isFull(N - 1, i)) {
                return true;
            }
        }
        return false;
    }

    public void printArray(int[][] arr) {
        // Arrays.toString(array)

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(N);

        percolation.open(0, 1);
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(3, 1);
        percolation.open(4, 1);
        percolation.open(5, 1);
        percolation.open(6, 1);
        percolation.open(7, 1);
        percolation.open(8, 1);
        percolation.open(9, 1);

        System.out.println("\n\n");

        percolation.printArray(grid);
        System.out.println("\n\n");

        System.out.println(percolation.isOpen(1, 1));
        System.out.println(percolation.isOpen(1, 0));

        System.out.println(percolation.numberOfOpenSites());
        System.out.println(percolation.to1DId(1, 1));

        System.out.println(percolation.percolates());

    }

    public int to1DId(int i, int j) {
        return j + (N * i);
    }

}