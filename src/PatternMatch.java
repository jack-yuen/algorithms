import java.util.Scanner;
public class PatternMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String destStr = sc.nextLine();
        String filterStr = sc.nextLine();
        System.out.println(Fit(destStr , filterStr));
    }

    public static int Fit(String str, String pattern){
        if(str.length() == 0 && pattern.length() == 0){
            return 1;
        }

        int i = 0;
        int j = 0;
        for(; i < pattern.length() && j < str.length(); i++, j++){
            char curChar = pattern.charAt(i);
            if(curChar == '*'){
                for(int k = j + 1; k <= str.length(); k++){
                    if(Fit(str.substring(k), pattern.substring(i + 1)) == 1){//只要有一个符合
                        return 1;
                    }
                }
            }
            else if(curChar == '?'){
                continue;
            }
            else{
                if(curChar != str.charAt(j)){
                    return 0;
                }
                else if(i == pattern.length() - 1 && j == str.length() - 1){
                    return 1;
                }
            }
        }
        if(i == pattern.length() && j == str.length()){
            return 1;
        }
        else{
            return 0;
        }
    }
}