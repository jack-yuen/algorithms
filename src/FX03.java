import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FX03 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            getPath(x, y);
        }
        sc.close();
    }

    public static void getPath(int x, int y){
        int M = 1000;
        int[][] matrix = {{0,2,10,5,3,M},{M,0,12,M,M,10},{M,M,0,M,7,M},{2,M,M,0,2,M},{4,M,M,1,0,M},{3,M,1,M,2,0}};
        List<Integer> target = new ArrayList<Integer>();
        target.add(1);
        target.add(2);
        target.add(3);
        target.add(4);
        target.add(6);
        if(!target.contains(x) || y>6 || y<0){//非法输入的讨论
            System.out.println(1000);
            System.out.println("[]");
            return;
        }
        if(y == 5){//大雾城市就是出发城市，肯定不可达
            System.out.println(1000);
            System.out.println("[]");
            return;
        }
        if(x == y){//目标城市和大雾城市相同，肯定是不可达
            System.out.println(1000);
            System.out.println("[]");
            return;
        }
        if(y == 0){//没有大雾的天气
            List<List<Integer>> result = new ArrayList<List<Integer>>();//取子集
            List<Integer> tempList = new ArrayList<Integer>();//临时存储
            List<List<Integer>> last = new ArrayList<List<Integer>>();//取所有的路径情况
            for(int i=1; i<=target.size(); i++)
                subSet(target, i, 0, result, tempList);
            for(int i=0; i<result.size(); i++){
                List<Integer> temp = result.get(i);
                rank(temp, tempList, last);
            }
            int min = matrix[4][x-1];//初始值为直达
            String str = "[5,";
            int index = -1;
            for(int i=0; i<last.size(); i++){
                List<Integer> temp=last.get(i);
                int sum = matrix[4][temp.get(0)-1];
                for(int j=1; j<temp.size(); j++)
                    sum += matrix[temp.get(j-1)-1][temp.get(j)-1];
                sum += matrix[temp.get(temp.size()-1)-1][x-1];
                if(min > sum){
                    min = sum;
                    index = i;
                }
            }
            //输出处理start
            if(index == -1){//如果在直达的情况最小
                if(min == 1000){//如果直到最小值是1000的话，则说明这条路径是没有的
                    System.out.println(1000);
                    System.out.println("[]");
                }
                else{//反之输出直达路径
                    System.out.println(min);
                    System.out.println(str + " " + x + "]");
                }
            }
            else{
                System.out.println(min);
                for(int i=0; i<last.get(index).size(); i++){
                    str += last.get(index).get(i) + ", ";
                }
                System.out.println(str + x + "]");
            }
            //输出处理end
        }
        else{//有大雾的天气，但是不是出发点，也不是目的地
            target.remove((Integer)x);
            target.remove((Integer)y);
            List<List<Integer>> result = new ArrayList<List<Integer>>();//取子集
            List<Integer> tempList = new ArrayList<Integer>();//临时存储
            List<List<Integer>> last = new ArrayList<List<Integer>>();//取所有的路径情况
            for(int i=1; i<=target.size(); i++)
                subSet(target, i, 0, result, tempList);
            for(int i=0; i<result.size(); i++){
                List<Integer> temp=result.get(i);
                rank(temp, tempList, last);
            }
            int min = matrix[4][x-1];//初始值为直达
            String str = "[5, ";
            int index = -1;
            for(int i=0; i<last.size(); i++){
                List<Integer> temp = last.get(i);
                int sum = matrix[4][temp.get(0)-1];
                for(int j=1; j<temp.size(); j++)
                    sum += matrix[temp.get(j-1)-1][temp.get(j)-1];
                sum += matrix[temp.get(temp.size()-1)-1][x-1];
                if(min > sum){
                    min = sum;
                    index = i;
                }
            }
            if(index == -1){
                if(min == 1000){
                    System.out.println(1000);
                    System.out.println("[]");
                }
                else{
                    System.out.println(min);
                    System.out.println(str + " " + x + "]");
                }
            }
            else{
                System.out.println(min);
                for(int i=0; i<last.get(index).size(); i++){
                    str += last.get(index).get(i) + ",";
                }
                System.out.println(str + " " + x + "]");
            }
        }
    }

    //计算所有的路径
    public static void subSet(List<Integer> target,int k,int start,List<List<Integer>> result,List<Integer> list){
        if(k < 0)
            return;
        else if(k == 0){
            result.add(new ArrayList<Integer>(list));
        }
        else{
            for(int i=start; i<target.size(); i++){
                list.add(target.get(i));
                subSet(target, k-1, i+1, result, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void rank(List<Integer> list,List<Integer> temp,List<List<Integer>> result){
        //路径的全排列
        if(temp.size() == list.size()){
            result.add(new ArrayList(temp));
        }
        else{
            for(int i=0; i<list.size(); i++){
                if(temp.contains(list.get(i)))
                    continue;
                temp.add(list.get(i));
                rank(list, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }
}
