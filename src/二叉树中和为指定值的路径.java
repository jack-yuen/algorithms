import java.util.Vector;
import baseClass.BinaryTreeNode;

/**
 * Created by jack on 2017/6/1.
 */
import java.util.List;
import java.util.ArrayList;
public class 二叉树中和为指定值的路径 {
    public static void main(String[] args){
        BinaryTreeNode b1 = new BinaryTreeNode(10);
        BinaryTreeNode b2 = new BinaryTreeNode(5);
        BinaryTreeNode b3 = new BinaryTreeNode(12);
        BinaryTreeNode b4 = new BinaryTreeNode(4);
        BinaryTreeNode b5 = new BinaryTreeNode(7);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        solve(b1, 22);
    }
    public static void solve(BinaryTreeNode node, int sum){
        List<BinaryTreeNode> path = new ArrayList<>();
        getPathValue(node, path, 0, sum);
    }
    public static void getPathValue(BinaryTreeNode node, List<BinaryTreeNode>path, int curVal, int sum){
        if(node == null){
            return;
        }
        path.add(node);
        if(node.left == null && node.right == null){
            if(curVal + node.val == sum){
                System.out.println();
                for(int i = 0; i < path.size() - 1; i++){
                    System.out.print(path.get(i).val + "->");
                }
                System.out.print(path.get(path.size() - 1).val);
            }
            path.remove(path.size() - 1);
            return;
        }
        getPathValue(node.left, path, curVal + node.val, sum);//对于不同的路径，这个path怎么解决
        getPathValue(node.right, path, curVal + node.val, sum);
        path.remove(path.size() - 1);
    }
}

