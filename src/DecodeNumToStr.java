/**
 * Created by jack on 2017/5/7.
 */
public class DecodeNumToStr {
    public static void main(String[] args) {
        System.out.println(numDecodings("12120"));
    }
    //本题类似青蛙跳台阶
    public static int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            if(s.charAt(0) <= '0'){
                return 0;
            }
            return 1;
        }
        char[] chars = s.toCharArray();
        int back = 1;
        int front = 0;
        if(chars[0] == '0' || chars[0] > '2' && chars[1] == '0'){
            return 0;
        }
        //从递增的角度出发 ，如果当前字符是多少，对前面的两个会有影响
        if(chars[1] != '0' && (chars[0] == '1' || chars[0] == '2' && chars[1] <= '6')){
            back = 1;
            front = 2;
        }
        else{
            back = 1;
            front = 1;
        }
        for(int i = 2; i < chars.length; i++){
            if(chars[i] == '0'){
                if(chars[i - 1] > '2' || chars[i - 1] == '0'){
                    return 0;
                }
                //要改变上一个与前一个，上一个减小
                //当前为0，上一个一定为1或2，如果前一个为1或2时，上一个的值要减小
                if(chars[i - 2] == '1' || chars[i - 2] == '2'){
                    int tmp = back;
                    back = front - back;
                    front = tmp;
                }
                //如果前一个不等于1或2，上一个和前一个的值都不用变
                else if(chars[i - 1] == '0' || chars[i - 1] > '6'){
                    return 0;
                }
            }
            else if(chars[i] <= '6' && chars[i - 1] == '2' || chars[i - 1] == '1'){//可以随便分的情况
                int tmp = front;
                front = front + back;
                back = tmp;
            }
            else{
                back = front;//如果继续往前走，比如24726，从7跳到6和从2跳到6
            }
        }
        return front;
    }
}
