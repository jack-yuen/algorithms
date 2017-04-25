import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by jack on 2017/4/24.
 * 用一个Map存储之前的<余数，序号>，如果现在的余数等于之前某个位置的余数时，就说明已经开始repeat了，这样就在结果里找到开始循环的位置
 * 需要注意数的正负问题，和整数的边界问题
 * String.substring(开始包含，结束不包含）
 * ^表示异或
 * sb.insert(0, "x");表示sb把x插入成0位置
 *
 */
public class fractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(1^1);
        StringBuilder sb = new StringBuilder();
        sb.append("01234");
        sb.insert(0, "x");
        System.out.println(sb);
    }
}
