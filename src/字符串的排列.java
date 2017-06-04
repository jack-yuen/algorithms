import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jack on 2017/6/3.
 * 给出一堆不同的字母，打印出所有的排列。
 * 递归，不同的字母放在第一个位置时，剩下的字母序列有多少种组合。
 */
public class 字符串的排列<T> {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String txt = sc.next();
        solve(txt);
        Stack s = new Stack();
    }
    public static void solve(String str){
        char[] charArr = str.toCharArray();
        Permutation(charArr, 0);
    }
    public static void Permutation(char[] arr, int begin){
//        if(begin >= arr.length){
//            return;
//        }
//        System.out.print(arr[begin]);
        if(begin == arr.length){
            System.out.println(new String(arr));
            return;
        }
        for(int i = begin; i < arr.length; i++){
            swap(arr, begin, i);//以第二个开头的剩下的所有排列，以第三个开头的剩下的所有排列……
            Permutation(arr, begin + 1);
            swap(arr, begin, i);//换回来
        }
    }
    public static void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
