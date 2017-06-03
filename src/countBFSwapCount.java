import java.util.Scanner;

/**
 * Created by jack on 2017/5/10.
 * 计算逆序数（冒泡排序算法要交换的次数）
 */
public class countBFSwapCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int curCount = sc.nextInt();
        int[] curArr = new int[curCount];
        for(int j = 0; j < curCount; j++){
            curArr[j] = sc.nextInt();
        }
        System.out.println("Case 方法1: " + count(curArr));
        System.out.println("Case 方法2: " + count2(curArr));
}
    public static int count(int[] arr){//这一方法是一个一个地数
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
    public static int count2(int[] arr){//归并的思想
        return mergeSort(arr, 0, arr.length - 1);
    }
    public static int mergeSort(int[] arr, int start, int end){
        if(start == end){
            return 0;
        }
        int mid = (start + end) / 2;
        int count = 0;
        count+= mergeSort(arr, start, mid);
        count+= mergeSort(arr, mid + 1, end);
        return count+merge(arr, start, mid, end);
    }
    public static int merge(int[] arr, int start, int mid, int end){
        int[] mergArr = new int[end - start + 1];
        int lIndex = start;
        int rIndex = mid + 1;
        int mergIndex = 0;
        int count = 0;
        while(lIndex <= mid){
            while(rIndex <= end && arr[rIndex] < arr[lIndex]){
                mergArr[mergIndex] = arr[rIndex];
                rIndex++;
                mergIndex++;
                count+=mid-lIndex+1;
            }
            mergArr[mergIndex] = arr[lIndex];
            lIndex++;
            mergIndex++;
        }
        while(rIndex <= end){
            mergArr[mergIndex++] = arr[rIndex++];
        }
        for(int i = 0; i < mergArr.length; i++){
            arr[start + i] = mergArr[i];
        }
        return count;
    }
}
