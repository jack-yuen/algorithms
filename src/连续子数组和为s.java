/**
 * Created by jack on 2017/6/6.
 */
public class 连续子数组和为s {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        testBook217(arr, 15);
    }
    public static void solve(int[] arr, int s){
        if(arr == null){
            return;
        }
        int start = 0, end = 1;
        int curSum = arr[start] + arr[end];
        while(start < end && end < arr.length && arr[start] <= s / 2){
            if(curSum == s){
                printPartArr(arr, start, end);
                curSum-=arr[start];
                start++;
            }
            if(curSum < s){
                end++;
                curSum+= arr[end];
            }
            if(curSum > s){
                curSum-= arr[start];
                start++;
            }
        }
    }
    public static void printPartArr(int[] arr, int start, int end){
        while(start <= end){
            System.out.print(arr[start]);
            if(start != end){
                System.out.print(",");
            }
            else{
                System.out.println();
            }
            start++;
        }
    }
    public static void testBook217(int[] arr, int sum){//有问题，书上的是1——n
        int small = 1;
        int big = 2;
        int middle = (1+sum)/2;
        int curSum = small + big;
        while(small < middle){
            if(curSum == sum){
                printPartArr(arr, small, big);
            }
            while(curSum > sum && small < middle){
                curSum-= small;
                small++;
                if(curSum==sum){
                    printPartArr(arr, small,big);
                }
                big++;
                curSum+=big;
            }
        }
    }
}
