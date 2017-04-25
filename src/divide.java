import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.Stack;
/**
 * Created by jack on 2017/4/23.
 * 主要思想是存一个一直将结果翻倍的栈和一个倍数栈，比如13/3，存3，6，12和1，2，4
 * 然后从大到小半数加，12+（6和3都太大），所以结果为4+（2和1都太大）
 * 另外要考虑整数边界问题
 */
public class divide {
    public static int posdivide(long dividend, long divisor,int pos){
        if(dividend < divisor){
            return 0;
        }
        long plus = divisor;
        long result = 1;
        Stack<Long> plusStack = new Stack();
        Stack<Long> resultStack = new Stack();

        while(plus << 1 <= dividend){
            plusStack.push(plus);
            resultStack.push(result);
            plus = plus << 1;
            result = result << 1;
        }
        while(!plusStack.isEmpty()){
            long topPlus = plusStack.pop();
            long topResult = resultStack.pop();
            if(plus + topPlus <= dividend){
                plus+= topPlus;
                result+= topResult;
            }
        }
        if(pos == 1 && result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(pos == 1){
            return (int)result;
        }
        else if(pos == -1 && result > (long)Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        }
        else{
            return (int)-result;
        }
    }
    public static int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        long d1 = dividend < 0 ? -(long)dividend : dividend;
        long d2 = divisor < 0 ? -(long)divisor : divisor;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            return posdivide(d1, d2, -1);
        }
        else{
            return posdivide(d1, d2, 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(divide(-8, 1));
    }
}
