import java.util.HashMap;

/**
 * Created by jack on 2017/5/2.
 * 与运算和移位运算用的是补码
 */
class testFinal2 {
    int t;
    static int i;
    //final static int j;
    //final int k;
    public testFinal2(){
        i = 3;
    }

    public static void main(String[] args) {
        int ts = 1;
        double max= 0;
        int cur = 0;
        while(ts < 100000){
            double tmp = (int)ts / (int)Math.sqrt(ts) - (int)Math.sqrt(ts);
            if(max < tmp) {
                cur = ts;
                max = tmp;
            }
            ts++;
        }
        System.out.print(cur);

//        int[] arr = {3,5,8};
//        testArr(arr);
//        testArr2(arr);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);
//        //结果说明这两个都可以对arr改变
//        System.out.println(-8 << 1);
//        System.out.println(2 << 1);
//        System.out.println((-7) & 3);
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
class Value3 {
    static int c = 0;
    Value3() {
        c = 15;
    }
    Value3(int i) {
        c = i;
    }
    static void inc() {
        c++;
    }
}
public class testFinal {
    public static void prt(String s) {
        System.out.println(s);
    }
    Value3 v = new Value3(10);
    static Value3 v1, v2;
    static {//此即为static块
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v1 = new Value3(27);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v2 = new Value3(15);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
    }

    public static void main(String[] args) {
        testFinal ct = new testFinal();
        prt("ct.c=" + ct.v.c);
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        v1.inc();
        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);
        prt("ct.c=" + ct.v.c);
    }
}