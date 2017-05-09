/**
 * Created by jack on 2017/5/9.
 * 判断两个版本谁大，比如1<1.01=1.1<1.2<1.3<1.021<1.30
 */
public class versionCompare {
    public int compareVersion(String version1, String version2) {
        char[] charStr1 = version1.toCharArray();
        char[] charStr2 = version2.toCharArray();
        int i = 0;
        int j = 0;
        while(i < charStr1.length && j < charStr2.length){
            while(i < charStr1.length && charStr1[i] == '0'){//这里要加上索引的范围小于数组长度
                i++;
            }
            while(j < charStr2.length && charStr2[j] == '0'){
                j++;
            }
            if(i == charStr1.length || j == charStr2.length){//这里要加上判断是否超过，超过直接跳出
                break;
            }
            int k = i; //接下来要判断两个点之间的去掉前导0的长度是否一样
            while(k < charStr1.length){
                if(charStr1[k] == '.'){
                    break;
                }
                k++;
            }
            int l = j;
            while(l < charStr2.length){
                if(charStr2[l] == '.'){
                    break;
                }
                l++;
            }
            if(k - i > l -j){
                return 1;
            }
            else if(k -i < l - j){
                return -1;
            }//如果一样，接下来就判断两个谁大
            if(charStr1[i] > charStr2[j]){
                return 1;
            }
            else if(charStr1[i] < charStr2[j]){
                return -1;
            }
            else{
                i++;
                j++;
            }
        }
        if(i < charStr1.length){
            if(charStr1[i] != '.'){
                return 1;
            }
        }
        else if(j < charStr2.length){
            if(charStr2[j] != '.'){
                return -1;
            }
        }
        while(i < charStr1.length){
            if(charStr1[i] != '0' && charStr1[i] != '.'){
                return 1;
            }
            i++;
        }
        while(j < charStr2.length){
            if(charStr2[j] != '0' && charStr2[j] != '.'){
                return -1;
            }
            j++;
        }
        return 0;
    }
}