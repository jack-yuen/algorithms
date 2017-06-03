import java.util.LinkedList;
import java.util.Queue;
import baseClass.BinaryTreeNode;

/**
 * Created by jack on 2017/6/1.
 */
public class 上到下打印二叉树 {
    public static void main(String[] args){
        BinaryTreeNode b1 = new BinaryTreeNode(8);
        BinaryTreeNode b2 = new BinaryTreeNode(6);
        BinaryTreeNode b3 = new BinaryTreeNode(10);
        BinaryTreeNode b4 = new BinaryTreeNode(5);
        BinaryTreeNode b5 = new BinaryTreeNode(7);
        BinaryTreeNode b6 = new BinaryTreeNode(9);
        BinaryTreeNode b7 = new BinaryTreeNode(11);
        b1.left = b2;
        b2.left = b4;
        b1.right = b3;
        b2.right = b5;
        b3.left = b6;
        b3.right = b7;
        solve(b1);
    }
    public static void solve(BinaryTreeNode node){
        Queue<BinaryTreeNode> q = new LinkedList<>();
        if(node == null){
            return;
        }
        q.add(node);
        while(!q.isEmpty()){
            BinaryTreeNode curNode = q.poll();
            System.out.print(curNode.val);
            if(curNode.left != null){
                q.offer(curNode.left);
            }
            if(curNode.right != null){
                q.offer(curNode.right);
            }
        }
    }
}
