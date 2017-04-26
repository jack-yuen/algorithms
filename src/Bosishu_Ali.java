import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
public class Bosishu_Ali {
    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }
    // write your code here
    public static int resolve(String expr) {
        char[] s = expr.toCharArray();
        boolean hasNum = false;
        Stack<Integer> st = new Stack();
        int curvalue = 0;
        int count = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                if(hasNum == true){
                    count++;
                    if(count > 16){
                        return -2;
                    }
                    st.push(curvalue);
                    hasNum = false;
                    curvalue = 0;
                }
                continue;
            }
            else if(s[i] >= '0' && s[i] <= '9'){
                curvalue = curvalue * 10 + (s[i] - '0');
                hasNum = true;
            }
            else if(s[i] == '^'){
                if(hasNum == true){
                    count++;
                    if(count > 16){
                        return -2;
                    }
                    st.push(curvalue);
                    hasNum = false;
                    curvalue = 0;
                }
                if(st.isEmpty()){
                    return -1;
                }
                int i1 = st.pop();
                st.push(i1 + 1);
                hasNum = false;
                curvalue = 0;
            }
            else if(s[i] == '*'){
                if(hasNum == true){
                    count++;
                    if(count > 16){
                        return -2;
                    }
                    st.push(curvalue);
                    hasNum = false;
                    curvalue = 0;
                }
                if(st.isEmpty()){
                    return -1;
                }
                int i1 = st.pop();
                if(st.isEmpty()){
                    return -1;
                }
                int i2 = st.pop();
                st.push(i1 * i2);
                count--;
                hasNum = false;
                curvalue = 0;
            }
            else if(s[i] == '+'){
                if(hasNum == true){
                    count++;
                    if(count > 16){
                        return -2;
                    }
                    st.push(curvalue);
                    hasNum = false;
                    curvalue = 0;
                }
                if(st.isEmpty()){
                    return -1;
                }
                int i1 = st.pop();
                if(st.isEmpty()){
                    return -1;
                }
                int i2 = st.pop();
                st.push(i1 + i2);
                count--;
                hasNum = false;
                curvalue = 0;
            }
        }
        if(!st.isEmpty()){
            return st.pop();
        }
        return -1;
    }
}