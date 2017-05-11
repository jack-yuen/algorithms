import java.util.Scanner;

/**
 * Created by jack on 2017/5/10.
 * 计算逆序数（冒泡排序算法要交换的次数）从大到小排序
 */
public class countBFSwapCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groupCount = sc.nextInt();
        int[] result = new int[groupCount];
        for(int i = 0; i < groupCount; i++){
            int curCount = sc.nextInt();
            int[] curArr = new int[curCount];
            for(int j = 0; j < curCount; j++){
                curArr[j] = sc.nextInt();
            }
            result[i] = count(curArr);
        }
        for(int i = 0; i < result.length; i++){
            System.out.println("Case #" + (i+1) + ": " + result[i]);
        }
    }
    public static int count(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
