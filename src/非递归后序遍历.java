import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import baseClass.BinaryTreeNode;

/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 *     int val;
 *     BinaryTreeNode left;
 *     BinaryTreeNode right;
 *     BinaryTreeNode(int x) { val = x; }
 * }
 */
public class 非递归后序遍历 {
    public static List<Integer> postorderTraversal(BinaryTreeNode root) {
        /*整体思想是：
        *如果有右子，先加右子，再加左子，直到加到没有子结点时，开始弹出
        *弹出的如果是左子，那下一个有可能是右子(兄弟)，也有可能是父结点=====》如果下一个是右子，此时右子继续加它的右子和左子
        *弹出的如果是右子，那下一个肯定是父结点
        */
        List<Integer> results = new ArrayList<Integer>();
        if(root == null){
            return results;
        }
        Stack s = new Stack();
        Stack direction = new Stack();//0表示是左子，1表示右子，2表示只有左子
        s.push(root);
        direction.push(1);
        int d = 0;//表示上一0个跳出时的类型
        boolean bPoped = false;
        while(s.empty() == false){
            BinaryTreeNode topNode = (BinaryTreeNode)s.peek();
            if((bPoped == true && d > 0) || (topNode.right == null && topNode.left == null)){
                s.pop();
                results.add(topNode.val);
                d = (int)direction.pop();
                bPoped = true;
                continue;
            }
            else{
                bPoped = false;
            }
            boolean containR = false;
            if(topNode.right != null){
                s.push(topNode.right);
                direction.push(1);
                containR = true;
            }
            if(topNode.left != null){
                s.push(topNode.left);
                if(containR == false){
                    direction.push(2);
                }
                else{
                    direction.push(0);
                }
            }
        }
        return results;
    }


    public static void main(String[] argv){
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = null;
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        root.right = node2;
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node2.left = node3;
        node2.right = null;
        List<Integer> ss = postorderTraversal(root);
        for(int i = 0; i < ss.size(); i++) {
            System.out.println(ss.get(i));
        }
    }
}