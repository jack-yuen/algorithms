import java.util.Stack;
/**
 * Created by jack on 2017/4/23.
 * 返回时多个空格要变成一个
 * 前导和后置的空格要去掉
 * 栈的判空是isEmplty()
 */
public class ReverseSentence {
    public static String reverse(String str){
        String result="";
        Stack<String> st = new Stack<String>();
        String curStr = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                curStr+=str.charAt(i);
            }
            else{
                if(curStr.length() > 0)
                    st.push(curStr);
                curStr = "";
            }
        }
        if(curStr.length() > 0){
            st.push(curStr);
        }
        while(!st.isEmpty()){
            curStr = st.pop();
            result+=curStr + " ";
        }
        result = result.trim();
        return result;
    }

    public static void main(String[] args) {
        String s = "    a      b   ";
        System.out.println(reverse(s));
    }
}
