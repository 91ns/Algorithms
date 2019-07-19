import java.util.Arrays;

public class sum3BS {
    private static int[] a = new int[]{-40, -20, -10, 0, 5, 10, 30, 40};


    private static int pairs = 0;

    public static void main(String[] arg) {

        System.out.println("We are live!");


        for (int i = 0; i< a.length; i++) {
            
            for(int j = 0; j < a.length; j++){

                int key = -(a[i] + a[j]);

                if(a[i] < a[j] && a[j] < key){ //


                    System.out.println("\nKey :" + key);

                    int result = binarySearch(key, a);
                    System.out.println("\nResult :" + result);


                    if(result != -1){
                        pairs++;
                        System.out.println("We found: " + a[i] + " " + a[j] + " " + a[result]);

                    }

                }
            }
        }
        System.out.println("\nPairs :" + pairs);

    }



    public static int binarySearch(int key, int[] arr){

        int lo = 0;
        int hi = arr.length - 1;


        while (lo <= hi) {
        
            int mid = lo + ((hi - lo) / 2);
            System.out.println("\nMid :" + mid);

            int midValue = a[mid];

            if (key < midValue) {

                hi = mid -1;

            }else if(key > midValue){

                lo = mid + 1;

            }else{
                return mid;
            }

        }
        return -1;
    }



    public void printArray(int[] arr) {
        // Arrays.toString(array)
        System.out.println(Arrays.toString(arr));
    }
}