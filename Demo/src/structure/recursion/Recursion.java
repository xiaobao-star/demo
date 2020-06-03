package structure.recursion;

/**
 *
 */
public class Recursion {
    public static void main(String[] args) {
        test(4);
    }

    public static void test(int n){
        if(n > 2){
            test(n -1);
        }
            System.out.println("n="+n);
    }
}
