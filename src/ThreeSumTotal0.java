import java.util.*;

/**
 * Created by jack on 2017/5/9.
 * 找个三个数的和=0的所有组合，数组不能重复
 * 思想是先排序，然后从小到大遍历，对于每一个数（找一个low和一个high计算两个的和，+》大了，就high--；+》小了就low++）
 */
public class ThreeSumTotal0 {
    public static void main(String[] args){
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> lst = threeSum(arr);
        Iterator<List<Integer>> it1 = lst.iterator();
        while(it1.hasNext()){
            List<Integer> lst2 = it1.next();
            Iterator<Integer> it2 = lst2.iterator();
            while(it2.hasNext()){
                System.out.print(it2.next());
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//[-1,-1,0,1,2,-4]
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            if(i >= 1 && nums[i] == nums[i-1]){//上面的-1，-1的这种情况只算一个
                continue;
            }
            int sum = -nums[i];
            int low = i+1;
            int high = nums.length-1;
            while(low<high){
                if(nums[low] + nums[high] == sum){
                    List<Integer> lst = new LinkedList<Integer>();
                    lst.add(nums[i]);
                    lst.add(nums[low]);
                    lst.add(nums[high]);
                    resultList.add(lst);
                    //加到没有重复
                    while(nums[low] + nums[high] == sum && low < high){
                        low++;
                    }
                }
                else if(nums[low] + nums[high] < sum){
                    low++;
                }
                else{
                    high--;
                }
            }
        }
        return resultList;
        // List<List<Integer>> resultList = new ArrayList();
        // Set<String> resultStrSet = new HashSet();
        // Map<Long, List<List<Integer>>> sumMap = new HashMap();
        // for(int i = 0; i < nums.length; i++){//计算所有和
        //     for(int j = i+1; j < nums.length; j++){
        //         long tmpSum = nums[i] + nums[j];
        //         if(sumMap.containsKey(tmpSum)){
        //             List<Integer> lst= new ArrayList<Integer>();
        //             lst.add(i);
        //             lst.add(j);
        //             sumMap.get(tmpSum).add(lst);
        //         }
        //         else{
        //             List<List<Integer>> sumList = new ArrayList();
        //             List<Integer> lst= new ArrayList<Integer>();
        //             lst.add(i);
        //             lst.add(j);
        //             sumList.add(lst);
        //             sumMap.put(tmpSum, sumList);
        //         }
        //     }
        // }
        // for(int i = 0; i < nums.length; i++){
        //     long negSum = (long)(-nums[i]);
        //     if(sumMap.containsKey(negSum)){
        //         List<List<Integer>> curList = sumMap.get(negSum);
        //         Iterator<List<Integer>> it = curList.iterator();
        //         while(it.hasNext()){
        //             List<Integer> numList = it.next();
        //             if(numList.get(0) != i && numList.get(1) != i){

        //                 int a1 = nums[numList.get(0)];
        //                 int a2 = nums[numList.get(1)];
        //                 int a3 = nums[i];
        //                 if(a1 > a2){
        //                     int tmp = a1;
        //                     a1 = a2;
        //                     a2 = tmp;
        //                 }
        //                 if(a2 > a3){
        //                     int tmp = a2;
        //                     a2 = a3;
        //                     a3= tmp;
        //                 }
        //                 if(a1 > a2){
        //                     int tmp = a1;
        //                     a1 = a2;
        //                     a2 = tmp;
        //                 }
        //                 if(!resultStrSet.contains(a1+","+a2+","+a3)){
        //                     resultStrSet.add(a1+","+a2+","+a3);
        //                 }
        //             }
        //         }
        //     }
        // }

        // Iterator<String> it = resultStrSet.iterator();
        // while(it.hasNext()){
        //     String curStr = it.next();
        //     String[] ss = curStr.split(",");
        //     List<Integer> resultSingle = new ArrayList();
        //     resultSingle.add(Integer.parseInt(ss[0]));
        //     resultSingle.add(Integer.parseInt(ss[1]));
        //     resultSingle.add(Integer.parseInt(ss[2]));
        //     resultList.add(resultSingle);
        // }
        // return resultList;
    }
}
