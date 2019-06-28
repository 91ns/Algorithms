import java.util.Arrays;

public class Test {

    private static int[] id;
    private static int[] sz;

    public static void main(String[] arg) {

        System.out.println("We are live!");

        Test test = new Test();

        test.QuickUnionUF(10);
        test.union(8, 0);
        test.union(1, 6);
        test.union(2, 6);
        test.union(7, 1);
        test.union(9, 2);
        test.union(3, 5);
        test.union(5, 6);

        test.printArray(id);
        test.union(7, 0);
        test.printArray(id);

    }

    public void printArray(int[] arr) {
        // Arrays.toString(array)
        System.out.println(Arrays.toString(arr));
    }

    public void QuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        printArray(id);

    }

    private int root(int i) {
        // find the parent of all

        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }

        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j)
            return;

        if (sz[i] < sz[j]) {
            id[i] = j;

            sz[j] += sz[i];
        } else {
            id[j] = i;

            sz[i] += sz[j];
        }
    }

}