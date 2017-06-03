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
public class 非递归中序遍历 {
    public static void main(String[] argv){
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = null;
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        root.right = node2;
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node2.left = node3;
        node2.right = null;
        List<Integer> ss = inorderTraversal(root);
        for(int i = 0; i < ss.size(); i++) {
            System.out.println(ss.get(i));
        }
    }
    public static List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<BinaryTreeNode> s = new Stack();
        while(root != null || !s.isEmpty()){//初始节点不为空或者栈不空时继续
            while(root != null){
                s.push(root);
                root = root.left;
            }
            if(!s.isEmpty()){
                BinaryTreeNode cur = s.pop();
                results.add(cur.val);
                root = cur.right;//给出右边一个初始节点（当前出节点的右子树），继续上面的遍历
            }
        }
        return results;
    }
}