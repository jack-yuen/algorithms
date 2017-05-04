/**
 * Created by jack on 2017/5/2.
 */
public class testFinal {
    int t;
    static int i;
    //final static int j;
    //final int k;
    public testFinal(){
        i = 3;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8};
        testArr(arr);
        testArr2(arr);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        //结果说明这两个都可以对arr改变
    }
    public static void testArr(int[] arr){
        arr[0] = 7;
        arr[1] = 7;
        arr[2] = 7;
    }
    public static void testArr2(int arr[]){
        arr[2] = 999;
    }
}
