import java.util.Scanner;

/**
 * Created by jack on 2017/3/11.
 */
public class aaa {
    static int minX = 0;
    static int minY = 0;//当前连通分量的最小值
    static int curCount = 0;//当前的个数
    static int row = 0;
    static int col = 0;
    public static void main(String[] argv){
        Scanner s1 = new Scanner(System.in);
        row = s1.nextInt();
        col = s1.nextInt();
        s1.nextLine();
        String[][] origin = new String[row][col];//输入
        for(int i=0; i<row; i++){
            String temp= s1.nextLine();
            for(int j=0; j<col; j++){
                origin[i][j] = temp.charAt(j) + "";
            }
        }
        int[][] a = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                a[i][j] = -1;
            }
        }

        //测试N,15个
        int[] nx1={0,0,0,0,0,1,2,3,4,5,6,6,6,6,6};
        int[] ny1={0,1,2,3,4,0,1,2,3,4,4,3,2,1,0};//第一种
        int[] nx2={0,1,2,3,4,4,3,2,1,0,0,1,2,3,4};
        int[] ny2={0,0,0,0,0,1,2,3,4,5,6,6,6,6,6};//第一种

        //T,11
        int[] tx1={0,1,2,3,4,5,6,3,3,3,3};
        int[] ty1={0,0,0,0,0,0,0,1,2,3,4};
        int[] tx2={0,1,2,3,4,4,4,4,4,4,4};
        int[] ty2={0,0,0,0,0,-1,-2,-3,1,2,3};
        int[] tx3={0,0,0,0,0,-1,-2,-3,1,2,3};
        int[] ty3={0,1,2,3,4,4,4,4,4,4,4};
        int[] tx4={0,0,0,0,0,0,0,1,2,3,4};
        int[] ty4={0,1,2,3,4,5,6,3,3,3,3};

        //E,23
        int[] ex1={0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,0};
        int[] ey1={0,0,0,0,0,0,0,2,2,2,2,2,2,2,4,4,4,4,4,4,4,1,3};
        int[] ex2={0,0,0,0,0,0,0,2,2,2,2,2,2,2,4,4,4,4,4,4,4,1,3};
        int[] ey2={0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,0};
        int[] ex3={0,0,0,0,0,0,0,2,2,2,2,2,2,2,4,4,4,4,4,4,4,1,3};
        int[] ey3={0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,1,2,3,4,5,6,6,6};
        int[] ex4={0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,1,2,3,4,5,6,6,6};
        int[] ey4={0,0,0,0,0,0,0,2,2,2,2,2,2,2,4,4,4,4,4,4,4,1,3};

        //S,23
        int[] sx1={0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,6};
        int[] sy1={0,0,0,0,0,0,0,2,2,2,2,2,2,2,4,4,4,4,4,4,4,1,3};
        int[] sx2={0,0,0,0,0,0,0,2,2,2,2,2,2,2,4,4,4,4,4,4,4,1,3};
        int[] sy2={0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,1,2,3,4,5,6,0,6};

        int n = 0;
        int s = 0;
        int e = 0;
        int t = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(origin[i][j].equalsIgnoreCase("#")){
                    minX = col;
                    minY = row;
                    curCount = 0;
                    //开始找连通分量
                    findConnect(origin, i, j, a);
                    //找到了一个连通分量
                    //minXminY,curCount测试这个连通分量
                    switch (curCount) {
                        case 15://N
                            int found = 1;
                            for(int k = 0; k < 15; k++){
                                if(minY+ny1[k] <=0 || minY+ny1[k] >= row || minX+nx1[k]<=0 || minX+nx1[k]>=col || !origin[minY+ny1[k]][minX+nx1[k]].equalsIgnoreCase("#")){//不匹配
                                    found = 0;
                                    break;
                                }
                            }
                            if(found == 1){
                                n++;break;
                            }
                            else{
                                for(int k = 0; k < 15; k++){
                                    if(minY+ny2[k] <=0 || minY+ny2[k] >= row || minX+nx2[k]<=0 || minX+nx2[k]>=col || !origin[minY+ny2[k]][minX+nx2[k]].equalsIgnoreCase("#")){//不匹配
                                        found = 0;
                                        break;
                                    }
                                }
                            }
                            if(found == 1){
                                n++;break;
                            }
                            break;
                        case 11://T
                            int foundT = 1;
                            for(int k = 0; k < 11; k++){
                                if(minY+ty1[k] <=0 || minY+ty1[k] >= row || minX+tx1[k]<=0 || minX+tx1[k]>=col || !origin[minY+ty1[k]][minX+tx1[k]].equalsIgnoreCase("#")){//不匹配
                                    foundT = 0;
                                    break;
                                }
                            }
                            if(foundT == 1){
                                t++;break;
                            }
                            else{
                                for(int k = 0; k < 11; k++){
                                    if(minY+ty2[k] <=0 || minY+ty2[k] >= row || minX+tx2[k]<=0 || minX+tx2[k]>=col || !origin[minY+ty2[k]][minX+tx2[k]].equalsIgnoreCase("#")){//不匹配
                                        foundT = 0;
                                        break;
                                    }
                                }
                            }
                            if(foundT == 1){
                                t++;break;
                            }
                            else{
                                for(int k = 0; k < 11; k++){
                                    if(minY+ty3[k] <=0 || minY+ty3[k] >= row || minX+tx3[k]<=0 || minX+tx3[k]>=col || !origin[minY+ty3[k]][minX+tx3[k]].equalsIgnoreCase("#")){//不匹配
                                        foundT = 0;
                                        break;
                                    }
                                }
                            }
                            if(foundT == 1){
                                t++;break;
                            }
                            else{
                                for(int k = 0; k < 11; k++){
                                    if(minY+ty4[k] <=0 || minY+ty4[k] >= row || minX+tx4[k]<=0 || minX+tx4[k]>=col ||!origin[minY+ty4[k]][minX+tx4[k]].equalsIgnoreCase("#")){//不匹配
                                        foundT = 0;
                                        break;
                                    }
                                }
                            }
                            if(foundT == 1){
                                t++;break;
                            }
                            break;
                        case 23://E,S
                            int foundE = 1;
                            for(int k = 0; k < 11; k++){
                                if(!origin[minY+ey1[k]][minX+ex1[k]].equalsIgnoreCase("#")){//不匹配
                                    foundE = 0;
                                    break;
                                }
                            }
                            if(foundE == 1){
                                e++;break;
                            }
                            else{
                                for(int k = 0; k < 11; k++){
                                    if(!origin[minY+ey2[k]][minX+ex2[k]].equalsIgnoreCase("#")){//不匹配
                                        foundE = 0;
                                        break;
                                    }
                                }
                            }
                            if(foundE == 1){
                                e++;break;
                            }
                            else{
                                for(int k = 0; k < 11; k++){
                                    if(!origin[minY+ey3[k]][minX+ex3[k]].equalsIgnoreCase("#")){//不匹配
                                        foundE = 0;
                                        break;
                                    }
                                }
                            }
                            if(foundE == 1){
                                e++;break;
                            }
                            else{
                                for(int k = 0; k < 11; k++){
                                    if(!origin[minY+ey4[k]][minX+ex4[k]].equalsIgnoreCase("#")){//不匹配
                                        foundE = 0;
                                        break;
                                    }
                                }
                            }
                            if(foundE == 1){
                                e++;break;
                            }



                            int foundS = 1;
                            for(int k = 0; k < 11; k++){
                                if(!origin[minY+sy1[k]][minX+sx1[k]].equalsIgnoreCase("#")){//不匹配
                                    foundS = 0;
                                    break;
                                }
                            }
                            if(foundS == 1){
                                s++;break;
                            }
                            else{
                                for(int k = 0; k < 11; k++){
                                    if(!origin[minY+sy2[k]][minX+sx2[k]].equalsIgnoreCase("#")){//不匹配
                                        foundS = 0;
                                        break;
                                    }
                                }
                            }
                            if(foundS == 1){
                                s++;break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        System.out.println("N:"+n);
        System.out.println("T:"+t);
        System.out.println("E:"+e);
        System.out.println("S:"+s);
    }
    public static void findConnect(String[][] origin, int i, int j, int[][] a){
        a[i][j] = 1;
        if(i < minY){
            minY = i;
        }
        if(j < minX){
            minX = j;
        }
        curCount++;
        for(int x = -1; x < 2; x++){
            for(int y=-1;y<2;y++){
                try {
                    if (i + y >= 0 && i + y < row && j + x >= 0 && j + x < col && origin[i + y][j + x].equalsIgnoreCase("#") && a[i + y][j + x] != 1) {
                        findConnect(origin, i + y, j + x, a);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
