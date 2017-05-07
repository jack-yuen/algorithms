import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by jack on 2017/5/5.
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci_Solve(33));
        System.out.println(efficientFibonacci(33));
    }
    public static long fibonacci_Solve(int n){
        if(n <= 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        int i = 3;
        long formerVal = 1;
        long curVal = 1;
        while(i <= n){
            long tmpVal = formerVal + curVal;
            formerVal = curVal;
            curVal = tmpVal;
            i++;
        }
        return curVal;
    }

    /**
     * 主要的思想是[f(n)      f(n-1)] =   [1    1]的(n-1)次方
     *             [f(n-1)    f(n-2)]     [1    0]
     * @param n
     * @return
     */
    public static long efficientFibonacci(int n){
        if(n <= 0){
            return 0;
        }
        if(n <= 2){
            return 1;
        }
        long[] result = calc(n - 1);
        return result[0];
    }
    public static long[] calc(int n){
        long[] result = new long[4];
        if(n == 1){
            result[0] = 1;
            result[1] = 1;
            result[2] = 1;
            result[3] = 0;
            return result;
        }
        long[] half = calc(n / 2);
        result = square(half, half);
        if(n % 2 != 0){
            long[] origin = {1, 1, 1, 0};
            result = square(result.clone(), origin);
        }
        return result;
    }
    public static long[] square(long[] half1, long[] half2){
        long[] result = new long[4];
        result[0] = half1[0] * half2[0] + half1[1] * half2[2];
        result[1] = half1[0] * half2[1] + half1[1] * half2[3];
        result[2] = half1[2] * half2[0] + half1[3] * half2[2];
        result[3] = half1[2] * half2[1] + half1[3] * half2[3];
        return result;
    }
}
