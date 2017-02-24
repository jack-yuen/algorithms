import java.lang.Math;

/**
 * 体力值不能小于1
 */
public class 左上右下跳方格 {
    public static void main(String[] argv){
        int[][] d = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int i = calculateMinimumHP(d);
        System.out.println(i);
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] results = new int[dungeon.length][dungeon[0].length];
        for(int r = height -1; r >= 0; r--){//从右下到左上计算
            for(int c = width -1; c >= 0; c--){
                if(r == height - 1 && c == width - 1){
                    results[r][c] = dungeon[r][c] <= 0 ? 1-dungeon[r][c] : -dungeon[r][c];
                }
                else if(r == height - 1){
                    results[r][c] = calcMin(dungeon[r][c], results[r][c+1], Integer.MAX_VALUE);
                }
                else if(c == width -1){
                    results[r][c] = calcMin(dungeon[r][c], results[r+1][c], Integer.MAX_VALUE);
                }
                else{
                    results[r][c] = calcMin(dungeon[r][c], results[r+1][c], results[r][c+1]);
                }
            }
        }
        return results[0][0] <= 0 ? 1 : results[0][0];
    }
    public static int calcMin(int cur, int right, int down){//根据右边和下边各需要多少（才能在以后顺利通过），来计算这个格需要多少
        int min = Math.min(right, down);
        if(min <= 0){
            min = (cur <= 0)? 1-cur : -cur;
        }
        else{
            min = (cur>=min)?-cur: min-cur;
        }
        return min;
    }
}