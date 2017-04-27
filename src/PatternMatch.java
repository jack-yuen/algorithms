import java.util.Scanner;
public class PatternMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String destStr = sc.nextLine();
        String filterStr = sc.nextLine();
        System.out.println(isMatch(destStr , filterStr));
    }

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