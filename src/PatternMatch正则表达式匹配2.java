/**
 * Created by jack on 2017/6/7.
 * 待验证。
 * 如果模式的第二个字母为*，分别判断。例如bcd和b*cd，判断bcd和cd，以及cd与b*cd
 */
public class PatternMatch正则表达式匹配2 {
    public static void main(String[] args) {
        String str = "abbcd";
        String p = "ab*c.a*";
       System.out.println(isMatch(str, p));
    }
    public static boolean isMatch(String s, String p){
        if(s == null && p == null || s.isEmpty() && p.isEmpty()){
            return true;
        }
        if(p.isEmpty() && !s.isEmpty()){//模式没了还有字母，返回false，//但字母没了还有模式，不一定是false,比如a*结尾
            return false;
        }
        if(p.length() == 1){//长度为1时
            if((p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')){
                return true;
            }
            else{
                return false;
            }
        }
        if(p.charAt(1) != '*'){
            if((p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                String subS = s.substring(1);
                String subP = p.substring(1);
                return isMatch(subS, subP);
            }
            else {
                return false;
            }
        }
        else{
            if(s.length() == 0){
                return isMatch("", p.substring(2));
            }
            if((p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p)
                    || isMatch(s, p.substring(2))){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
