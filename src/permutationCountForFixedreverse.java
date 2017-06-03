/**
 * Created by jack on 2017/5/27.
 * 求n个各不相等的数，有m对逆序数对的排列有多少种
 */
import java.util.Scanner;
import java.util.Arrays;
public class permutationCountForFixedreverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();
        int pairs = sc.nextInt();
        System.out.println(COUNT(numCount, pairs));
    }
    public static int COUNT(int numCount, int pairs){
        int[][] s = new int[numCount+1][pairs+1];
        for(int i = 1; i <= numCount; i++){
            s[i][0] = 1;//所有的逆对数为0的都只有一组
            s[i][1] = i - 1;//所有逆序数为1对的等于i-1，必须相临的换才可以（看看能不能换成递推）
        }
        for(int i = 1; i <= numCount; i++){
            for(int j = 2; j <= pairs; j++){//逆序数对为1的已经计算过了，这里从2对开始算
                if(j>=i){
                    s[i][j]= s[i-1][j]+s[i][j-1]-s[i-1][j-i];
                }
                else{
                    s[i][j] = s[i-1][j]+s[i][j-1];
                }
            }
        }
        return s[numCount][pairs];
    }
}

