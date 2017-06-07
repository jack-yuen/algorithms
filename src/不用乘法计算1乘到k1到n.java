/**
 * Created by jack on 2017/6/7.
 */
public class 不用乘法计算1乘到k1到n {
    public static void main(String[] args){
        int[] A = {1,2,3,4,5,6,7};
        int[] B = new int[7];
        solve(A,B);
        for(int i = 0; i < B.length; i++){
            System.out.println(B[i]);
        }
    }
    public static void solve(int[] A, int[] B){
        if(A.length != B.length || A.length == 0){
            return;
        }
        B[0] = 1;
        for(int i = 1; i < B.length; i++){
            B[i] = B[i-1] * A[i - 1];
        }

        int later = 1;
        for(int i = A.length - 1; i >= 1; i--){
            later*= A[i];
            B[i - 1] *= later;
        }
    }
}
