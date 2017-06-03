import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by jack on 2017/4/20.
 */
public class SortMethod {
    public static void main(String[] args){
        int[] a = {19, 3, 7, 9, 49, 52, 23, 1, 5, 8, 24, 4, 20, 6, 25, 53, 49};
        int[] b= a.clone();
        int[] c= a.clone();
        int[] d= a.clone();
        int[] e= a.clone();
        int[] f= a.clone();
        int[] g= a.clone();
        QuickSort(a, 0, a.length - 1);
        PrintResult(a, "快排");;
        BublleSort(b);
        PrintResult(b, "冒泡");
        SelectSort(c);
        PrintResult(c, "选择");
        insertSort(d);
        PrintResult(d, "插入");
        insertSort(e);
        PrintResult(e, "希尔");
        mergSort(f, 0, f.length - 1);
        PrintResult(f, "归并");
        heepSort(g);
        PrintResult(g, "堆排");
    }
    public static void PrintResult(int arr[], String name){
        for(int i = 0; i < arr.length; i++) {
            if(i == 0){
                System.out.println();
                System.out.print(name + ":");
            }
            System.out.print(arr[i] + ",");
        }
    }
    public static void SelectSort(int arr[]){
        for(int i= 0; i < arr.length - 1; i++){
            int curMin = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[curMin]){
                    curMin = j;
                }
            }
            Swap(arr, i, curMin);
        }
    }
    public static void insertSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int curVal = arr[i];
            int j;//记录最后该值应该处的位置
            for(j = i - 1; j >= 0 && arr[j] > curVal; j--){
                arr[j+1] = arr[j];
            }
            arr[j + 1] = curVal;
        }
    }
    public static void BublleSort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    Swap(arr, j, j+1);
                }
            }
        }
    }

    /**
     * 希尔排序，从步长为n/2开始，每次步长减半，从（步长~最终）用插入排序，O(n2)
     * @param arr
     */
    public static void shellSort(int arr[]){
        for(int increase = arr.length / 2; increase >= 1 ;increase /= 2){
            for(int i = increase; i < arr.length; i++){
                int curVal = arr[i];
                int j = 0;
                for(j = i - increase; j > increase && arr[j] > curVal; j -= increase){
                    if(arr[j] > arr[i]){
                        arr[j + increase] = arr[j];
                    }
                }
                arr[j + increase] = curVal;
            }
        }
    }

    /**
     * 二路归并排序
     * @param arr
     * @param start
     * @param end
     */
    public static void mergSort(int arr[], int start, int end){
        if(start == end){
            return;
        }
        int mid = (start + end) / 2;//如果只有两个元素，会变成较低的，因此分成...~mid, mid+1~...
        mergSort(arr, start, mid);
        mergSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public static void merge(int arr[], int start, int mid, int end){
        int[] mergArr = new int[end - start +1];
        int index = 0;
        int j = mid + 1;
        for(int i = start; i <= mid; i++){//把前一半的遍历完
            while(j <= end && arr[j] < arr[i]){//这里先加的是右边的。也可以先判断左边的加
                mergArr[index] = arr[j];
                j++;
                index++;
            }
            mergArr[index] = arr[i];
            index++;
        }
        while(j <= end){//后一半剩余的的加进去
            mergArr[index] = arr[j];
            index++;
            j++;
        }
        for(int i = 0; i < end - start + 1; i++){
            arr[start + i] = mergArr[i];
        }
    }
    public static void heepSort(int arr[]){
        createHeep(arr);
        for(int i = arr.length - 1; i > 0 ; i--){
            Swap(arr, 0, i);
            reHeep(arr, 0, i - 1);
        }
    }

    /**
     * 建大顶堆
     * @param arr
     */
    public static void createHeep(int arr[]){
        for(int i = (arr.length - 2) >> 1; i > 0; i--){
            if((i << 1) + 2 < arr.length - 1){
                if(arr[i] < arr[(i << 1) + 1]){
                    Swap(arr, i, i >> 1 + 1);
                }
            }
            else{
                if(arr[i] < arr[(i << 1) + 1] || arr[i] < arr[(i << 1) + 2]){
                    int maxIndex = arr[(i << 1) + 1] < arr[(i << 1) + 2] ? (i << 1) + 2 : (i << 1) + 1;
                    Swap(arr, i, maxIndex);
                }
            }
        }
    }
    public static void reHeep(int arr[], int node, int end){//reheep是从堆顶往堆底调，node表示当前要调的节点（与其子节点）
        if((node << 1) + 2 <= end){
            if(arr[node] < arr[(node << 1) + 2] || arr[node] < arr[(node << 1) + 1]){
                int maxIndex = arr[(node << 1) + 2] < arr[(node << 1) + 1] ? (node << 1) + 1 : (node << 1) + 2;
                Swap(arr, node, maxIndex);
                reHeep(arr, maxIndex, end);
            }
        }
        else if((node << 1) + 1 <= end){
            if(arr[node] < arr[(node << 1) + 1]){
                Swap(arr, node, (node << 1) + 1);
                reHeep(arr, (node << 1) + 1, end);
            }
        }
    }
    public static void QuickSort(int arr[], int start, int end){
        if(start >= end)
            return;
        int index = Partition(arr, start, end);
        if(index > start)
            QuickSort(arr, start, index - 1);
        if(index < end)
            QuickSort(arr, index + 1, end);
    }
    public static int Partition(int arr[], int start, int end){
        int index = (int)(Math.random() * (end - start)) + start;
        int low = start, high = end;
        int pivot = arr[index];
        Swap(arr, index, end);
        while(low < high){//左边取的是<=，右边取的是>。也就是说左边全是小于等于pivot，右边全是大于pivot
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
    public static void Swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
