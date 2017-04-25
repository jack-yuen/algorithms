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
                if(mark[i][j] == true){
                    continue;
                }
                boolean margin = false;
                if(board[i][j] == 'O'){
                    if(findMargin(i, j, board, mark) == true){
                        pts.add(new Point(i,j));
                    }
                }
            }
        }
        for(int i = 0; i < pts.size(); i++){
            search(pts.get(i), board);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(board[i][j]);
            }
            System.out.print('\n');
        }
    }
    public static void search(Point pt, char board[][]){
        int x = pt.i;
        int y = pt.j;
        if(x >= board.length || y >= board[0].length){
            return;
        }
        if(board[x][y] == 'O'){
            search(new Point(x, y+1), board);
            search(new Point(x + 1, y), board);
        }
        board[x][y] = 'X';
    }
    /**
     * true if surrounded
     */
    public static boolean findMargin(int i, int j, char board[][], boolean mark[][]){
        if(i >= board.length || j >= board[0].length){
            return true;
        }
        mark[i][j] = true;
        if(board[i][j] == 'X'){
            return true;
        }
        else if(board[i][j] == 'O'){
            if(i == 0 || j == 0 || i >= board.length - 1 || j >= board[0].length - 1){
                return false;
            }
            else if(findMargin(i, j+1, board, mark) && findMargin(i + 1, j, board, mark) && findMargin(i - 1, j, board, mark)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] s = {"OOOOXX".toCharArray(),"OOOOOO".toCharArray(),"OXOXOO".toCharArray(),"OXOOXO".toCharArray(),"OXOXOO".toCharArray(),"OXOOOO".toCharArray()};
        solve(s);
    }
}
