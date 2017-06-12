import baseClass.BinaryTreeNode;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by jack on 2017/6/8.
 */
public class 序列化和反序列化二叉树 {
    public static void main(String[] args){
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        serialize(n1);
        System.out.println();
        BinaryTreeNode node = deserialize("1,2,4,$,$,$,3,5,$,$,6,$,$").node;
        serialize(node);
    }
    public static void serialize(BinaryTreeNode node){
        if(node == null){
            System.out.print("$,");
            return;
        }
        else {
            System.out.print(node.val + ",");
            serialize(node.left);
            serialize(node.right);
        }
    }
    public static DesResult deserialize(String s){
        if(s == null || s.length() == 0){
            return new DesResult(null, "");
        }
        if(s.startsWith("$")){
            if(s.length() == 1){
                return new DesResult(null, "");
            }
            else {
                return new DesResult(null, s.substring(2));
            }
        }
        int i = 0;
        while(s.charAt(i) != ','){
            i++;
        }
        int val = Integer.valueOf(s.substring(0, i));
        BinaryTreeNode node = new BinaryTreeNode(val);
        DesResult res1 = deserialize(s.substring(i + 1));//应该返回剩下的字符串
        node.left = res1.node;
        DesResult res2 = deserialize(res1.str);
        node.right = res2.node;
        return new DesResult(node, res2.str);
    }
}
class DesResult{
    public BinaryTreeNode node;
    public String str;
    public DesResult(BinaryTreeNode _n, String _str){
        this.node = _n;
        this.str = _str;
    }
}
