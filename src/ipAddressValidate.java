/**
 * Created by jack on 2017/5/9.
 * String.split会自动忽略到空的字符串比如"345.6."只会分成两个字符串，最后一个点之后的会省略掉
 * 给定一个字符串，看是不是IPv6或IPv4类型的IP地址
 */
public class ipAddressValidate {
    public static void main(String[] args) {
        System.out.println(validIPAddress("01.01.01.01"));
    }
    public static String validIPAddress(String IP) {
        if(IP.indexOf(":") != -1){//V6
            String[] arrs = IP.split(":");
            if(arrs.length != 8 || IP.indexOf("::") != -1 || IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':'){
                return "Neither";
            }
            for(int i = 0; i < arrs.length ; i++){
                if(check6(arrs[i]) == false){
                    return "Neither";
                }
            }
            return "IPv6";
        }
        else{//v4
            String[] arrs = IP.split("\\.");
            if(arrs.length != 4 || IP.indexOf("..") != -1 || IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.'){
                return "Neither";
            }
            for(int i = 0; i < arrs.length ; i++){
                if(check4(arrs[i]) == false){
                    return "Neither";
                }
            }
            return "IPv4";
        }
    }
    public static boolean check4(String part){
        char firstChar = part.charAt(0);
        if(!(firstChar >= '1' && firstChar <='9') && part.length() > 1){
            return false;
        }
        try{
            int s = Integer.parseInt(part);
            if(s > 255){
                return false;
            }
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public static boolean check6(String part){
        if(part.length() > 4){
            return false;
        }
        for(int i = 0; i < part.length(); i++){
            char c = part.charAt(i);
            if(!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F')){
                return false;
            }
        }
        return true;
    }
}
