/**
 * Created by jack on 2017/6/6.
 * 分成三步：1.先计算每一位的和：把每一位异或：0+0=0，1+1=0，0+1和1+0都等于1
 * 2.计算两个的进位：用与：1与1产生1，其它全产生0。
 * 3.把进位的值与和值再进行求和，直到进位为0为止
 */
public class 不用加减做加法 {
    public static void main(String[] args){
        int a = 35;
        int b = 372;
        System.out.println(add(a, b));
    }
    public static int add(int a, int b){
        //int extra = 0
        while(true){
            int sum = a ^ b;
            int extra = a & b;
            a = sum;
            b = extra << 1;
            if(extra == 0){
                break;
            }
        }
        return a;
    }
}
