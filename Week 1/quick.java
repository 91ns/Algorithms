import java.util.Arrays;

public class quick {

    private static int[] id;

    private static int temp = -1;
    private static int largest = -1;

    private static int N = 10;

    public static void main(String[] arg) {

        System.out.println("We are live!");

        quick test = new quick();

        test.QuickUnionUF(N);
        test.union(8, 0);
        test.union(1, 6);
        test.union(2, 6);
        test.union(7, 1);
        test.union(7, 0);
        test.printArray(id);

        test.find(6);

    }

    public void find(int i) {

        largest = -1;
        temp = -1;
        System.out.println("\n\n");

        for (int n = 0; n < N; n++) {

            if (connected(i, n)) {
                System.out.println(i + " and " + n);
                System.out.println("temp: " + temp + "\n");

                largest = temp;

            }
        }

        System.out.println("\n\nlargest element: " + largest);

    }

    public void printArray(int[] arr) {
        // Arrays.toString(array)
        System.out.println(Arrays.toString(arr));
    }

    public void QuickUnionUF(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        printArray(id);

    }

    private int root(int i) {
        // find the parent of all

        while (i != id[i]) {

            if (i > temp) {

                temp = i;
            }

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

        id[i] = j;
    }

}