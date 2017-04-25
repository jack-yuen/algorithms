/**
 * Created by jack on 2017/3/25.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class cinMatrix {
    /**
     * 输入并返回矩阵
     * @return
     */
    public static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];//这里是行数和列数
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        List<String> lstStr = new ArrayList<String>();
        return matrix;
    }
    public static void main(String[] argv){
        int[][] s = inputMatrix();
    }
}
