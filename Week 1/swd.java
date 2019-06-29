import java.util.Arrays;

// Successor with delete. Given a set of nn integers S = \{ 0, 1, ... , n-1
// \}S={0,1,...,n−1} and a sequence of requests of the following form:

// Remove xx from SS
// Find the successor of xx: the smallest yy in SS such that y \ge xy≥x.
// design a data type so that all operations (except construction) take
// logarithmic time or better in the worst case.

public class swd {

    private static int[] S;
    private static int N = 10;
    private static int successor = -1;

    public static void main(String[] arg) {

        System.out.println("We are live!");

        swd test = new swd();
        test.inializeSet(N);

        test.remove(4);

    }

    public void inializeSet(int size) {

        S = new int[N];

        for (int i = 0; i < N; i++) {
            S[i] = i;
        }

        printArray(S);
    }

    public void remove(int x) {
        N -= 1;
        S = new int[N];
        successor = -1;

        if (N == 0) {
            return;
        } else {
            for (int i = 0; i < N; i++) {

                if (i < x) {
                    S[i] = i;
                } else {

                    S[i] = i + 1;

                    if (successor == -1)
                        successor = S[i];
                }
            }
        }

        printArray(S);
        System.out.println("successor :" + successor);

    }

    public void printArray(int[] arr) {
        // Arrays.toString(array)
        System.out.println(Arrays.toString(arr));
    }
}