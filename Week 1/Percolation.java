import java.util.Arrays;

public class Percolation {

    public static int[][] grid;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {

        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                grid[i][j] = 0;

            }
        }
        printArray(grid);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        grid[row][col] = 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {

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
        Percolation percolation = new Percolation(10);

        percolation.open(1, 1);
        percolation.open(1, 9);

        System.out.println("\n\n");

        percolation.printArray(grid);
        System.out.println("\n\n");

        System.out.println(percolation.isOpen(1, 1));
        System.out.println(percolation.isOpen(1, 0));

        System.out.println(percolation.numberOfOpenSites());

    }
}