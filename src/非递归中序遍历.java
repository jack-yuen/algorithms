import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 非递归中序遍历 {
    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode node2 = new TreeNode(2);
        root.right = node2;
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;
        node2.right = null;
        List<Integer> ss = inorderTraversal(root);
        for(int i = 0; i < ss.size(); i++) {
            System.out.println(ss.get(i));
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if(root == null){
            return results;
        }
        Stack s = new Stack();
        s.push(root);
        boolean lEmpty = false;//用来判定是不是左子树遍历完了才跳出的，如果是，那么栈顶的就不用继续判断左子树了
        while(s.empty() == false){
            TreeNode topNode = (TreeNode)(s.peek());
            if(topNode.left != null && lEmpty == false){
                s.push(topNode.left);
            }
            else{
                topNode = (TreeNode)(s.pop());
                results.add(topNode.val);
                lEmpty = true;
                if(topNode.right != null){
                    s.push(topNode.right);
                    lEmpty = false;
                }
            }
        }
        return results;
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }