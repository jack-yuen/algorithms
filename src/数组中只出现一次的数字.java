/**
 * Created by jack on 2017/6/5.
 * 数组里出现 两个只出现 一次的数字
 * 两个完全相同的数字进行异或xor(exclusive or)运算，结果为0
 * 先求算法数的XOR，得出的不为0，肯定是这两个 数的XOR，然后对其第一位1，分成组
 */
public class 数组中只出现一次的数字 {
    public static void main(String[] args){
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result = solve(arr);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] solve(int[] arr){
        int[] result = new int[2];
        if(arr == null || arr.length == 0){
            return result;
        }
        int xor = 0;
        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];
        }
        int firt1 = getFirt1(xor);
        for(int i = 0; i < arr.length; i++){
            if(isByte1(arr[i], firt1)){
                result[0]^= arr[i];
            }
            else{
                result[1]^=arr[i];
            }
        }
        return result;
    }
    public static int getFirt1(int n){
        int index = 0;
        while((n & 1)==0 && index < Integer.toBinaryString(n).length()){
            n = n >> 1;
            index++;
        }
        return index;
    }
    public static boolean isByte1(int n, int index){
        n = n>>index;
        return (n&1)==1;
    }
}

