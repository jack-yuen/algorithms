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
        wordSet.addAll(wordList);
        HashMap<String, List<String>> neighborList = new HashMap<String, List<String>>();
        findNeiOfStr(beginWord, neighborList, wordSet);
        calcWordDist(neighborList, wordSet);

        int dist = 0;
        Set<String> reached = new HashSet<String>();
        Stack<String> lastReached = new Stack();
        Stack<String> curReached = new Stack();
        lastReached.push(beginWord);
        boolean useCur = false;
        while(useCur ? !curReached.isEmpty() : !lastReached.isEmpty()){
            String curPoped = useCur ? curReached.pop() : lastReached.pop();
            List<String> curList = neighborList.get(curPoped);
            if(curList == null || curList.isEmpty()){
                continue;
            }
            Iterator<String> it = curList.iterator();
            while(it != null && it.hasNext()){
                String curNei = it.next();
                if(curNei.equals(endWord)){
                    return dist + 1;
                }
                if(!reached.contains(curNei)){
                    if(useCur){
                        lastReached.add(curNei);
                    }
                    else{
                        curReached.add(curNei);
                    }
                }
            }
            if(useCur && curReached.isEmpty()){
                useCur = false;
                dist++;
            }
            else if(!useCur && lastReached.isEmpty()){
                useCur = true;
                dist++;
            }
        }
        return 0;
    }
    public static void calcWordDist(HashMap<String, List<String>> neighborList, Set<String>wordSet){
        Iterator<String> it = wordSet.iterator();
        while(it.hasNext()){
            String str = it.next();
            findNeiOfStr(str, neighborList, wordSet);
        }
    }
    public static void findNeiOfStr(String str, HashMap<String, List<String>> neighborList, Set<String> wordSet){
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            chars = str.toCharArray();
            char oldChar = chars[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c == oldChar){
                    continue;
                }
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
