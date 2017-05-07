import java.util.*;

/**
 * Created by jack on 2017/5/6.
 */
public class WordLadder {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        lst.add("hot");
        lst.add("dot");
        lst.add("dog");
        lst.add("lot");
        lst.add("log");
        lst.add("cog");
        System.out.println(ladderLength("hit", "cog", lst));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>();
        for(int i = 0; i < wordList.size(); i++){
            wordSet.add(wordList.get(i));
        }
        HashMap<String, List<String>> neighborList = new HashMap<String, List<String>>();
        calcWordDist(neighborList, wordSet);

        //把wordList中的字符串加入HashMap，计算每个与他们两两之间的距离
        //整体dijkstra
        //for(int i = 0; i < wordList.size(); i++){
        //    addNeighborhood(neighborList, beginWord, wordList.get(i));
        //    for(int j = i; j < wordList.size(); j++){
        //        addNeighborhood(neighborList, wordList.get(i), wordList.get(j));
        //    }
        // }
        int dist = 1;
        List<String> curNeigh = new ArrayList<String>();
        HashSet<String> calcedMap = new HashSet<String>();
        Stack<String> strStack = new Stack<String>();
        Stack<String> curStack = new Stack<String>();
        strStack.push(beginWord);
        while(!strStack.isEmpty()){
            curNeigh = neighborList.get(strStack.pop());
            for(int j = 0; j < curNeigh.size(); j++){
                if(curNeigh.get(j).equals(endWord)){
                    dist++;
                    return dist;
                }
                if(!calcedMap.contains(curNeigh.get(j))){
                    curStack.push(curNeigh.get(j));
                }
            }
            if(strStack.isEmpty()){
                while(!curStack.isEmpty()){
                    strStack.push(curStack.pop());
                }
                dist++;//为空表示一轮走完
            }
        }
        return 0;
    }

    public static void addNeighborhood(HashMap<String, List<String>> neighborList, String str1, String str2){
        if(neighborTwoWords(str1, str2) == true){
            if(neighborList.containsKey(str1)){
                neighborList.get(str1).add(str2);
            }
            else{
                List<String> strList = new ArrayList<String>();
                strList.add(str2);
                neighborList.put(str1, strList);
            }
            if(neighborList.containsKey(str2)){
                neighborList.get(str2).add(str1);
            }
            else{
                List<String> strList = new ArrayList<String>();
                strList.add(str1);
                neighborList.put(str2, strList);
            }
        }
    }
    public static void calcWordDist(HashMap<String, List<String>> neighborList, Set<String>wordSet){
        Iterator<String> it = wordSet.iterator();
        while(it.hasNext()){
            String str = it.next();
            char[] chars = str.toCharArray();
            for(int i = 0; i < chars.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    chars[i] = c;//改变某一位,26*长度次
                    String changeStr = new String(chars);
                    if(wordSet.contains(changeStr)){
                        if(neighborList.containsKey(str)){
                            neighborList.get(str).add(changeStr);
                        }
                        else{
                            List<String> strList = new ArrayList<String>();
                            strList.add(changeStr);
                            neighborList.put(str, strList);
                        }
                    }
                }
            }
        }
    }
    /**
     *看两个字符串是不是邻居
     */
    public static boolean neighborTwoWords(String str1, String str2){
        boolean found = false;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                if(found == true){
                    return false;
                }
                else{
                    found = true;
                }
            }
        }
        return found;
    }
}
