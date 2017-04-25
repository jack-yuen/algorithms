import java.util.Scanner;

/**
 * Created by jack on 2017/4/23.
 * 转换的时候要考虑int的最大值2147483647，超出就等于int的最小值，和最小值-2147483648
 * long的最大值9223372036854775809，超出就等于1
 * String.trim得到的是前后都去空导符，原字符不变
 */
public class StrToInt {
    public static int myAtoi(String str) {
        long result = 0;
        int multi = 1;
        if(str != null){
            str = str.trim();
            if(str.length() != 0){
                if(str.charAt(0) == '-'){
                    str = str.substring(1);
                    multi = -1;
                }
                else if(str.charAt(0) == '+'){
                    str = str.substring(1);
                }
                for(int i = 0; i < str.length(); i++){
                    char cur = str.charAt(i);
                    if(cur < '0' || cur > '9'){
                        break;
                    }
                    else{
                        result = result * 10 + (cur - '0');
                        if(result > (long)Integer.MAX_VALUE + 1){
                            result = (long)Integer.MAX_VALUE + 1;
                            break;
                        }
                    }
                }
            }
        }
        if(multi == 1){
            if(result > Integer.MAX_VALUE){
                result = Integer.MAX_VALUE;
            }
        }
        else if(multi == -1){
            if(result > (long)Integer.MAX_VALUE + 1){
                result = -((long)Integer.MAX_VALUE + 1);
            }
            else{
                result = -result;
            }
        }
        return (int)result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(myAtoi(s));
    }
}
