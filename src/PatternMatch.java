import java.util.Scanner;
public class PatternMatch {
    public static void main(String[] args) {
        //System.out.println("***".replaceAll("\\*\\*", "*"));
        Scanner sc = new Scanner(System.in);
        String destStr = sc.nextLine();
        String filterStr = sc.nextLine();
        //System.out.println(isMatch(destStr , filterStr));
        System.out.println(linearPatternMatch(destStr , filterStr));
    }

    public static boolean linearPatternMatch(String str, String pattern){
        pattern = pattern.replaceAll("\\*\\*", "*").replaceAll("\\*\\*", "*");
        //match存与星号后面的第一个相匹配的字符
        //lastStarIndex存的是上一个星号的位置
        char[] strSeq = str.toCharArray();
        char[] patternSeq = pattern.toCharArray();
        int s = 0, p = 0, match = 0, lastStarIndex = -1;
        while(s < strSeq.length){
            //以str的长度为条件，如果p>pattern的长度，那么看最后一次*，继续往前排。
            //否则，就比较pattern当前的值和str当前的值
            if(p < patternSeq.length && patternSeq[p] != '*' &&(patternSeq[p] == '?' || patternSeq[p] == strSeq[s])){
                p++;
                s++;
            }
            else if(p < patternSeq.length && patternSeq[p] == '*'){
                lastStarIndex = p;
                p++;
                match = s;
            }
            else if(lastStarIndex != -1){
                match++;
                s = match;
                p = lastStarIndex + 1;
            }
        }
        while(p < patternSeq.length){
            if(patternSeq[p] != '*'){
                return false;
            }
            p++;
        }
        return true;
    }

    /**
     * 下面是递归写法，可能有错。时间复杂度太高
     * @param str
     * @param pattern
     * @return
     */
    public static boolean isMatch(String str, String pattern) {
        if(str.length() == 0 && pattern.length() == 0){
            return true;
        }
        int i = 0;
        int j = 0;
        pattern = pattern.replaceAll("\\*\\*", "*");
        for(; i < pattern.length(); i++, j++){
            char curChar = pattern.charAt(i);
            if(curChar == '*'){
                for(int k = j; k <= str.length(); k++){
                    if(isMatch(str.substring(k), pattern.substring(i + 1))){//只要有一个符合
                        return true;
                    }
                }
            }
            else if(curChar == '?'){
                continue;
            }
            else{
                if(j >= str.length() || curChar != str.charAt(j)){
                    return false;
                }
                else if(i == pattern.length() - 1 && j == str.length() - 1){
                    return true;
                }
            }
        }
        if(i == pattern.length() && j == str.length()){
            return true;
        }
        else{
            return false;
        }
    }
}