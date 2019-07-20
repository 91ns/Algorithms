import java.util.Arrays;

public class stack_array {

    private static String[] s;
    private static int N = 0;


    public static void main(String[] arg) {
        new stack_array();
        push("I");
        push("gotta");
        push("learn");
        push("how");
        push("to");
        push("love");
        push("without");
        push("you");

        pop();
        pop();
        pop();
        pop();
        pop();
        pop();

        push("carry");
        push("my");
        push("cross");
        push("without");
        push("you");

    }

    public stack_array(){
        s = new String[1];
    }

    public static boolean isEmpty(){
        return N == 0; 
    }

    public static void push(String item){

        if (N == s.length ) {
            int newCapacity = 2*s.length;
            resizeArray(newCapacity);
        }
        s[N++] = item;
        System.out.println(Arrays.toString(s));


    }

    public static String pop(){

        if(N < s.length/4){
            int newCapacity = s.length/4;
            resizeArray(newCapacity);
        }
        String item = s[--N];
        s[N] = null;
        return item;
    }
    


    public static void resizeArray(int newCapacity){

        String[] copy = s;
        s = new String[newCapacity];
        for(int i = 0; i < copy.length; i++){

            s[i] = copy[i];
        }

    }
}