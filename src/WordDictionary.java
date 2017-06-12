import java.util.HashSet;

/**
 * Created by jack on 2017/6/12.
 * 此题超时，需要重写。leetcode211题
 * 应该改方法：改成基于字符查找树来写，查找的时候如果是.号，就搜索该TrieNode所有的子结点。否则用正常Trie的搜索方法
 */
public class WordDictionary {
    private HashSet<String> set = new HashSet<String>();
    /** Initialize your data structure here. */
    public WordDictionary() {
        set = new HashSet<String>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        set.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word.indexOf(".") == -1){
            return set.contains(word);
        }
        char[] arr = word.toCharArray();
        return searchArray(arr, 0);

    }
    private boolean searchArray(char[] arr, int start){
        String s = new String(arr);
        if(set.contains(s)){
            return true;
        }
        for(int i = start; i < arr.length; i++){
            if(arr[i] == '.'){
                for(char curChar = 'a'; curChar <= 'z'; curChar++){
                    arr[i] = curChar;
                    if(searchArray(arr, i + 1) == true){//当前点的下一个点
                        return true;
                    }
                    arr[i] = '.';
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        WordDictionary wd = new WordDictionary();
        wd.addWord("adds");
        System.out.println(wd.search("...s"));
    }
}