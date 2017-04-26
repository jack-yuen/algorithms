import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jack on 2017/4/24.
 * 二维boolean数组存是否已经访问过
 * 用stack找连通分量，pop时找到它四周的连通分量push进去。如果达到边界，说明这个连通分量有到边的，没被包围。
 * 找到的当前连通分量用stack存起来.如果被包围了，就直接更改成被包围
 */
public class SurroundedRegion {
    public static void solve(char[][] board) {
        int row = board.length;
        if(row == 0){
            return;
        }
        int col = board[0].length;
        if(col == 0){
            return;
        }
        boolean[][] mark = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mark[i][j] == true || board[i][j] == 'X'){//visited
                    continue;
                }
                Stack<Integer> xs = new Stack();
                Stack<Integer> ys = new Stack();
                Stack<Integer> resultXs = new Stack();
                Stack<Integer> resultYs = new Stack();
                xs.push(i);//=false
                ys.push(j);
                mark[i][j] = true;
                boolean tobefilled = true;
                while(!xs.isEmpty()){
                    int curx = xs.pop();
                    int cury = ys.pop();
                    resultXs.push(curx);
                    resultYs.push(cury);
                    if(curx == 0||curx == row - 1||cury == 0||cury == col - 1){
                        tobefilled = false;
                    }
                    if(curx + 1 <= row - 1 && mark[curx + 1][cury] == false && board[curx + 1][cury] == 'O'){
                        xs.push(curx + 1);
                        ys.push(cury);
                        mark[curx + 1][cury] = true;
                    }
                    if(curx - 1 >= 0 && mark[curx - 1][cury] == false && board[curx - 1][cury] == 'O'){
                        xs.push(curx - 1);
                        ys.push(cury);
                        mark[curx - 1][cury] = true;
                    }
                    if(cury + 1 <= col - 1 && mark[curx][cury + 1] == false && board[curx][cury + 1] == 'O'){
                        xs.push(curx);
                        ys.push(cury + 1);
                        mark[curx][cury + 1] = true;
                    }
                    if(cury - 1 >= 0 && mark[curx][cury - 1] == false && board[curx][cury - 1] == 'O'){
                        xs.push(curx);
                        ys.push(cury - 1);
                        mark[curx][cury - 1] = true;
                    }
                }
                if(tobefilled == true){
                    while(!resultXs.isEmpty()){
                        board[resultXs.pop()][resultYs.pop()] = 'X';
                    }
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        char[][] s = {"XOOXXXOXOO".toCharArray(),"XOXXXXXXXX".toCharArray(),"XXXXOXXXXX".toCharArray(),"XOXXXOXXXO".toCharArray(),"OXXXOXOXOX".toCharArray(),"XXOXXOOXXX".toCharArray(),"OXXOOXOXXO".toCharArray(),"OXXXXXOXXX".toCharArray(),"XOOXXOXXOO".toCharArray(),"XXXOOXOXXO".toCharArray()};
        solve(s);
    }
}
