import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2017/4/24.
 */
public class SurroundedRegion {
    static class Point{
        public int i;
        public int j;
        Point(int i_, int j_){
            i = i_;
            j = j_;
        }
    }
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
                mark[i][j] = false;
            }
        }
        List<Point> pts = new ArrayList<Point>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mark[i][j] == true || board[i][j] == 'X'){//visited
                    continue;
                }
                Stack<Integer> xs = new Stack();
                Stack<Integer> ys = new Stack();
                int minx = i;
                int miny = j;
                xs.push(i);//=false
                ys.push(j);
                mark[i][j] = true;
                boolean tobefilled = true;
                while(!xs.isEmpty()){
                    int curx = xs.pop();
                    int cury = ys.pop();
                    if(curx == 0||curx == row - 1||cury == 0||cury == col - 1){
                        tobefilled = false;
                    }
                    if(curx + 1 <= row - 1 && mark[curx + 1][cury] == false && board[curx + 1][cury] == 'O'){
                        xs.push(curx + 1);
                        ys.push(cury);
                        mark[curx + 1][cury] = true;
                        minx = curx + 1 < minx ? curx + 1 : minx;
                        miny = cury < miny ? cury: miny;
                    }
                    if(curx - 1 >= 0 && mark[curx - 1][cury] == false && board[curx - 1][cury] == 'O'){
                        xs.push(curx - 1);
                        ys.push(cury);
                        mark[curx - 1][cury] = true;
                        minx = curx - 1 < minx ? curx - 1 : minx;
                        miny = cury < miny ? cury: miny;
                    }
                    if(cury + 1 <= col - 1 && mark[curx][cury + 1] == false && board[curx][cury + 1] == 'O'){
                        xs.push(curx);
                        ys.push(cury + 1);
                        mark[curx][cury + 1] = true;
                        minx = curx < minx ? curx : minx;
                        miny = cury + 1 < miny ? cury + 1: miny;
                    }
                    if(cury - 1 >= 0 && mark[curx][cury - 1] == false && board[curx][cury - 1] == 'O'){
                        xs.push(curx);
                        ys.push(cury - 1);
                        mark[curx][cury - 1] = true;
                        minx = curx < minx ? curx : minx;
                        miny = cury - 1 < miny ? cury - 1: miny;
                    }
                }
                if(tobefilled == true && board[minx][miny] == 'O'){//why must add =='O'
                    pts.add(new Point(minx,miny));
                }
            }
        }
        for(int i = 0; i < pts.size(); i++){
            search(pts.get(i), board);
            //System.out.println(pts.get(i).i + "," + pts.get(i).j);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }
    }
    public static void search(Point pt, char board[][]){
        int i = pt.i;
        int j = pt.j;
        Stack<Integer> xs = new Stack();
        Stack<Integer> ys = new Stack();
        xs.push(i);//=false
        ys.push(j);
        int row = board.length;
        int col = board[0].length;
        while(!xs.isEmpty()){
            int curx = xs.pop();
            int cury = ys.pop();
            board[curx][cury] = 'X';
            if(curx + 1 <= row - 1 && board[curx + 1][cury] == 'O'){
                xs.push(curx + 1);
                ys.push(cury);
                board[curx + 1][cury] = 'X';
            }
            if(curx - 1 >= 0 && board[curx - 1][cury] == 'O'){
                xs.push(curx - 1);
                ys.push(cury);
                board[curx - 1][cury] = 'X';
            }
            if(cury + 1 <= col - 1 && board[curx][cury + 1] == 'O'){
                xs.push(curx);
                ys.push(cury + 1);
                board[curx][cury + 1] = 'X';
            }
            if(cury - 1 >= 0 && board[curx][cury - 1] == 'O'){
                xs.push(curx);
                ys.push(cury - 1);
                board[curx][cury - 1] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] s = {"XOOXXXOXOO","XOXXXXXXXX","XXXXOXXXXX","XOXXXOXXXO","OXXXOXOXOX","XXOXXOOXXX","OXXOOXOXXO","OXXXXXOXXX","XOOXXOXXOO","XXXOOXOXXO"};
        solve(s);
    }
}
