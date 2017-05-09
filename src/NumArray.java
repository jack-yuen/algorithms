/**
 * Created by jack on 2017/5/8.
 * 一个类，方面有3个：以数组构造，更改第n个位置的位置的值，计算i到j位置的和（后两个方法的调用频率相等）
 * 思想：将数组分成sqrt(n)段，计算从0到每一段的和，这样一来，计算i到j的和时就不用挨个相加了
 */
public class NumArray {
    final private int[] num_arr;
    //建sqrt(n)级索引
    private final int[] seg_sum;
    private int per_num;
    private final int seg_num;
    public NumArray(int[] nums) {
        num_arr = nums.clone();
        per_num = (int)Math.sqrt(nums.length);
        if(nums.length > per_num * per_num){
            seg_num = (nums.length % per_num == 0)?nums.length/per_num:nums.length/per_num+1;
        }
        else{
            seg_num = per_num;
        }
        seg_sum = new int[seg_num];
        for(int i = 0; i < seg_num; i++){
            for(int j = i * per_num; j < per_num * (i + 1) && j < nums.length; j++){
                seg_sum[i]= seg_sum[i] + nums[j];
            }
            if(i != 0){
                seg_sum[i] += seg_sum[i - 1];
            }
        }
    }

    public void update(int i, int val) {
        if(i < 0 || i >= num_arr.length){
            return;
        }
        int deff = val - num_arr[i];
        num_arr[i] = val;
        for(int j = i / per_num; j < seg_num; j++){
            seg_sum[j] += deff;
        }
    }

    public int sumRange(int i, int j) {
        if(i < 0 || i > j || j >= num_arr.length){
            return 0;
        }
        if(j == 0){
            return num_arr[0];
        }
        int sum = 0;
        //前后的点都已经计算完毕
        //两个都不要包含当前的段
        int beginSum = ((i + 1)% per_num == 0)?(i + 1)/per_num:(i + 1)/per_num+1;
        int endSum = (j+1)/ per_num - 1;
        int beforeSingle = (beginSum + 1) * per_num - 1;//最近加进来该点
        int afterSingle = (endSum + 1) * per_num;//最后包含进来
        if(beginSum > endSum){
            sum = 0;
        }
        else if(beginSum < 0){
            sum = seg_sum[endSum];
        }
        else {
            sum = seg_sum[endSum] - seg_sum[beginSum];
        }
        while(j >= afterSingle && j >=i){
            sum += num_arr[j];
            j--;
        }
        while(i <= beforeSingle && i <= j){
            sum += num_arr[i];
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {9,-8};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(1,1));
        //System.out.println(obj.sumRange(1,2));
        //System.out.println(obj.sumRange(0,2));
    }
}
