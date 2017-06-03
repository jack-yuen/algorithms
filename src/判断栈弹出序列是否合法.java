/**
 * Created by jack on 2017/6/1.
 */
import java.util.Stack;
import java.util.Scanner;
public class 判断栈弹出序列是否合法 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solve(s1, s2));
    }
    public static boolean solve(String seq1, String seq2){
        if(seq1 == null || seq2 == null || seq1.length() != seq2.length()){
            return false;
        }
        Stack<Character> s = new Stack();
        int matchcnt = 0;
        for(int index2 = 0, index1 = 0; index2 < seq2.length(); index2++){
            while(!s.isEmpty() && s.peek() == seq2.charAt(index2)){
                s.pop();
                index2++;
                matchcnt++;
                if(matchcnt == seq1.length()){
                    return true;
                }
            }
            if(index1 == seq1.length()){//这一部分应该放在前面，因为如果放在后面直接判断完最后一个会index=length
                if(matchcnt < seq1.length()){
                    return false;
                }
                return true;
            }
            while(index1 < seq1.length()){
                if(seq1.charAt(index1) == seq2.charAt(index2)){
                    index1++;
                    matchcnt++;
                    break;
                }
                else {
                    s.push(seq1.charAt(index1));
                    index1++;
                    if(index1 == seq1.length()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
