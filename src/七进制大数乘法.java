import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by jack on 2017/5/31.
 */
public class 七进制大数乘法 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(multiply(s1, s2));
    }
    public static String multiply(String s1, String s2){
        BigInteger bi1 = Sev2Dec(s1);
        BigInteger bi2 = Sev2Dec(s2);
        BigInteger resultBi = bi1.multiply(bi2);
        return resultBi.toString(7);
    }
    public static BigInteger Sev2Dec(String s){
        BigInteger bi = new BigInteger("0");
        for(int i = 0; i < s.length(); i++){
            bi= bi.multiply(new BigInteger("7")).add(new BigInteger(s.charAt(i) + ""));
        }
        return bi;
    }
}
