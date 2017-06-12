/**
 * Created by jack on 2017/6/9.
 */
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Iterator;
public class 有相同字条的串组成一队 {
    public static void main(String[] args){
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println(1);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap();
        for(int i = 0; i < strs.length; i++){
            String curStandardStr = standardString(strs[i]);
            if(map.containsKey(curStandardStr)){
                ArrayList<String> lst = map.get(curStandardStr);
                lst.add(strs[i]);
            }
            else{
                ArrayList<String> lst = new ArrayList<String>();
                lst.add(strs[i]);
                map.put(curStandardStr, lst);
            }
        }

        Iterator<Map.Entry<String,ArrayList<String>>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,ArrayList<String>> entry = it.next();
            result.add(entry.getValue());
        }
        return result;
    }
    public static String standardString(String str){
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for(int i = 0; i< str.length(); i++){
            arr[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
