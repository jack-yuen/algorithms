import baseClass.BinaryTreeNode;

/**
 * Created by jack on 2017/6/5.
 * 如果通过 子树的高度来计算的话，在计算子树是否平衡的时候需要重复计算子树的高度
 * 所以在计算子树高度的时候同时把子树是否是平衡二叉树计算出来
 */
public class 判断是不是平衡二叉树 {

    public static void main(String[] args){
        BinaryTreeNode b1 = new BinaryTreeNode(10);
        BinaryTreeNode b2 = new BinaryTreeNode(5);
        BinaryTreeNode b3 = new BinaryTreeNode(12);
        BinaryTreeNode b4 = new BinaryTreeNode(4);
        BinaryTreeNode b5 = new BinaryTreeNode(7);
        BinaryTreeNode b6 = new BinaryTreeNode(4);
        BinaryTreeNode b7 = new BinaryTreeNode(7);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        //b3.left = b6;
        //b3.right = b7;
        b4.left = b6;
        solve(b1);
    }
    public static void solve(BinaryTreeNode node){
        System.out.println(IsBalanced(node).isbalanced);;
    }
    public static BalanceResult IsBalanced(BinaryTreeNode node){
        BalanceResult br = new BalanceResult(false, 0);
        if(node == null){
            br.isbalanced = true;
            br.height = 0;
            return br;
        }
        else{
            BalanceResult left = IsBalanced(node.left);
            if(left.isbalanced == false){
                br.isbalanced = false;
                br.height = left.height + 1;
            }
            else {
                BalanceResult right = IsBalanced(node.right);
                if(right.isbalanced == true && Math.abs(left.height - right.height) <= 1){
                    br.isbalanced = true;
                    br.height = Math.max(left.height, right.height) + 1;
                }
            }
        }
        return br;
    }
}
class BalanceResult{
    boolean isbalanced;
    int height;
    public BalanceResult(boolean _b, int _h){
        this.isbalanced = _b;
        this.height = _h;
    }
}

