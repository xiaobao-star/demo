package structure.recursion;

/**
 * 8皇后问题
 */
public class qenen8 {
    int max = 8;
    int [] arr = new int [max];
    public static void main(String[] args) {
        qenen8 qenen8 = new qenen8();
        qenen8.check(0);
    }

    private void check(int n){
        if(n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
