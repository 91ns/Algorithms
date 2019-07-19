import java.util.Arrays;

public class sum3BS {
    private static int[] a = new int[]{-40, -20, -10, 0, 5, 10, 30, 40};

    public static void main(String[] arg) {

        System.out.println("We are live!");


        for (int i = 0; i< a.length; i++) {
            
            for(int j = 0; j < a.length; j++){

                if(i != j){

                    int key = -(a[i] + a[j]);

                    System.out.println("\nKey :" + key);

                    int result = binarySearch(key, a);
                    System.out.println("\nResult :" + result);


                    if(result != -1){
                        System.out.println("We found: " + a[i] + " " + a[j] + " " + a[result]);

                    }

                }
            }
        }
    }



    public static int binarySearch(int key, int[] arr){

        int lo = 0;
        int hi = arr.length - 1;


        while (lo <= hi) {
        
            int mid = lo + ((hi - lo) / 2);
            System.out.println("\nMid :" + mid);


            if (key < a[mid]) {

                hi = mid -1;

            }else if(key > a[mid]){

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