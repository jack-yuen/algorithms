/**
 * Created by jack on 2017/6/2.
 * 把搜索二叉树转换成为一个排序的双向链表，不新建节点。这里用的非递归中序遍历。存一个last节点
 * 非递归中序的while循环的条件是：last节点不为空或者stack不为空
 */
import java.util.Stack;
import baseClass.BinaryTreeNode;
public class 二叉搜索树转双向链表不新建 {
    public static void main(String[] args){
        BinaryTreeNode n1 = new BinaryTreeNode(10);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(14);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(8);
        BinaryTreeNode n6 = new BinaryTreeNode(12);
        BinaryTreeNode n7 = new BinaryTreeNode(16);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        BinaryTreeNode result = solve(n1);
        while(result != null){
            System.out.print((result.left==null?"()":"("+result.left.val+")") + result.val + "" + (result.right==null?"()":"("+result.right.val+")") + "->");
            result = result.right;
        }
    }
    public static BinaryTreeNode solve(BinaryTreeNode node){
        if(node == null){
            return null;
        }
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode head = null;
        BinaryTreeNode lastNode = null;
        while(node != null || !s.isEmpty()){
            while(node != null){
                s.push(node);
                node = node.left;
            }
            if(!s.isEmpty()){
                BinaryTreeNode top = s.pop();
                if(lastNode == null){
                    head = top;
                }
                top.left = lastNode;
                if(lastNode != null){
                    lastNode.right = top;
                }
                lastNode = top;
                node = top.right;
            }
        }
        return head;
    }
}
