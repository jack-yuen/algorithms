import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABSame{
    public static void Quicksort(int[] a,int Left,int Right){
        int left,right,temp,middle;
        middle=a[(Left+Right)/2];
        left=Left;
        right=Right;
        do{
            //从左边寻找大于中间值的下标
            while(left<Right&&a[left]<middle){
                left++;
            }
            //从右边寻找小于中间值的下标
            while(right>Left&&a[right]>middle){
                right--;
            }
            //找到一对，对换他们
            //注意：如果少了等于号，会长生死循环
            if(left<=right){
                temp=a[left];
                a[left]=a[right];
                a[right]=temp;
                left++;
                right--;
            }

        }while(right>=left); //直到左右对换

        if(Left<right){
            Quicksort(a,Left,right);
        }

        if(Right>left){
            Quicksort(a,left,Right);
        }
    }
    /*
 5      * 循环实现二分查找算法arr 已排好序的数组x 需要查找的数-1 无法查到数据
 6      */
      public static int binarySearch(int[] arr, int x) {
          int low = 0;
          int high = arr.length - 1;
          while (low <= high) {
              int middle = (low + high) / 2;
              if (x == arr[middle]) {
                  return middle;
              } else if (x < arr[middle]) {
                  high = middle - 1;
              } else {
                  low = middle + 1;
              }
          }
          return -1;
      }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int an = sc.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = sc.nextInt();
        }
        int bn = sc.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = sc.nextInt();
        }
        Quicksort(a, 0, an - 1);

        boolean first = true;
        for (int i = 0; i < bn; i++) {
            if (binarySearch(a, b[i]) != -1) {
                if (first == true) {
                    first = false;
                    System.out.print(b[i]);
                } else {
                    System.out.print(" " + b[i]);
                }
            }
        }
    }
}