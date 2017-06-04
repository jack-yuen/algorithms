import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

/**
 * Created by jack on 2017/6/3.
 */
public class 数组中超过一半的数字 {
    public static void main(String[] args){
        int[] arr = {1,2,3,2,2,2,6,4,2};
        System.out.println(solve(arr));
    }
    public static int solve(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while(index != arr.length / 2){
            if(index > arr.length / 2){
                end = index - 1;
                index = partition(arr, start, end);
            }
            else{
                start = index + 1;
                index = partition(arr, start, end);
            }
        }
        if(checkValid(arr, arr[index])){
            return arr[index];
        }
        return 0;
    }
    public static boolean checkValid(int[] arr, int val){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(val == arr[i]){
                count++;
                if(count > arr.length / 2){
                    return true;
                }
            }
        }
        return false;
    }

    public static int partition(int[] arr, int start, int end){
        int index = start + (int)(Math.random() * (end - start));
        int low = start;
        int high = end;
        int pivot = arr[index];
        arr[index] = arr[high];
        while(low < high){
            while(arr[low] <= pivot && low < high){
                low++;
            }
            arr[high] = arr[low];
            while(arr[high] > pivot && high > low){
                high--;
            }
            arr[low] = arr[high];
        }
        arr[low] = pivot;
        return low;
    }
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[j] - arr[i];
        arr[j] = arr[j] - arr[i];
        arr[i] = arr[j] + arr[i];
    }
}