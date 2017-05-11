import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jack on 2017/5/10.计算包含n个节点的树的平均高度
 * 算法思想:当前树的高度=（左树x个节点的种数）*（右树n-x-1个节点的种数）*当前树的高度，所有求和之后，除以总种数
 * 自底向上计算
 * BigInteger,BigDecimal.divide(BigDecimal, 小数位保留数，BigDecimal.ROUND_HALF_UP)
 * String.valueOf
 * DecimalFormat df = new DecimalFormat("#.00");df.format(f);
 * String.format("%.2f",f)
 * BigDecimal bd;bd.setScale(2, BigDecimal.ROUNT_HALF_UP).doubleValue();
 */
public class AVGTreeHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int i = 1;
        while(true){
            max = sc.nextInt();
            float[] arr = new float[max + 1];
            BigInteger[] treeCount = new BigInteger[max];
            calcCombineCount(max, treeCount);
            calcAvgHeight(max, arr, treeCount);
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println("Case #" + i + ": " + df.format(arr[max]));
            i++;
        }
    }
    public static void calcAvgHeight(int n, float[] arr, BigInteger[] zuheshu){//fei di jian
        arr[0] = 0;
        if(n > 1) {
            arr[1] = 1;
        }
        for(int i = 2; i <= n; i++){
            BigDecimal totalHeightBD = new BigDecimal("0");
            BigDecimal totalCountBD = new BigDecimal("0");
            for(int j = 0; j <= i -1; j++) {
                BigInteger curCount = zuheshu[i-j-1].multiply(zuheshu[j]);
                if (j < i - 1 - j) {//right higher
                    totalHeightBD = totalHeightBD.add(new BigDecimal(String.valueOf(arr[i-1-j])).multiply(new BigDecimal(curCount.toString())));
                } else {//left higher
                    totalHeightBD = totalHeightBD.add(new BigDecimal(String.valueOf(arr[j])).multiply(new BigDecimal(curCount.toString())));
                }
                totalCountBD = totalCountBD.add(new BigDecimal(String.valueOf(curCount)));
            }
            arr[i] = Float.parseFloat(totalHeightBD.divide(totalCountBD, 5, BigDecimal.ROUND_HALF_UP).toString()) + 1;
        }
    }
    public static void calcCombineCount(int n, BigInteger[] treeCount){
        treeCount[0] = new BigInteger("1");
        if(n > 1) {
            treeCount[1] = new BigInteger("1");
        }
        for(int i = 2; i < n; i++){
            treeCount[i] = new BigInteger("0");
        }
        for(int i = 2; i <n; i++){
            for(int j = 0; j < i; j++){
                treeCount[i] = treeCount[i].add(treeCount[j].multiply(treeCount[i-j-1]));
            }
        }
    }
}
