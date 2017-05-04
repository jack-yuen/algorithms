import java.util.HashMap;

/**
 * Created by jack on 2017/5/3.
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 */
public class containsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 0, -2, 2};
        int k = 2;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicate(arr, k, t));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0){
            return false;
        }
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        long perNum = (long)t + 1;//桶大小
        long[] arrs = new long[k];
        int insertIndex = 0;
        for(int i = 0; i < nums.length; i++){
            long index = (nums[i] - (long)Integer.MIN_VALUE) / perNum;
            if(map.containsKey(index) ||
                    map.containsKey(index + 1) && (long)map.get(index + 1) - nums[i] <= t ||
                    map.containsKey(index - 1) && nums[i] - (long)map.get(index - 1) <= t){
                return true;
            }
            if(map.keySet().size() >= k){
                map.remove(arrs[insertIndex]);
            }
            map.put(index, (long)nums[i]);
            arrs[insertIndex] = index;
            insertIndex++;
            if(insertIndex >= k){
                insertIndex = 0;
            }
        }
        return false;
    }
}
