/**
 * Created by jack on 2017/6/4.
 * 3XXXX
 * 对于第一位3，如果取（0，1，2），那么后面的每一位都可以从0到9随便取，所以有3* 4(位中的每位为1 ）*1000（另外3个随便取）
 * 除此之外，还要算上第1位为1的话，一共有10000个1
 * 除此之外，还要算是如果第1位是3，后面有多少种取法，也就成了子序列中的XXXX有多少个1
 * 综上所述：结果为第一位的10000 + 后面的 3 * 4 * 1000 + 子序列的个数
 */
public class 从1到n出现的1的个数 {
    public static void main(String[] args){
        System.out.println(solve(21345));
    }
    public static int solve(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        return solveStr(arr, 0);
    }
    public static int solveStr(char[] arr, int start){
        if(arr.length == 0 || start >= arr.length){
            return 0;
        }
        char firstChar = arr[start];
        int first = firstChar - '0';
        int firstTotal = 0;
        int followingZheng = 0;
        if(first == 1){
            firstTotal = Integer.valueOf(String.valueOf(arr, start + 1, arr.length - start - 1)) + 1;
        }
        else if(first >= 2){
            firstTotal = (int)Math.pow(10, arr.length - start - 1);
        }
        followingZheng = first * (int) Math.pow(10, arr.length - start - 2);
        return firstTotal + followingZheng + solveStr(arr, start+1);
    }
}
