import java.util.List;
import java.util.ArrayList;
import baseClass.BinaryTreeNode;
/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

        For example,
        Given n = 3, your program should return all 5 unique BST's shown below.

        1         3     3      2      1
        \       /     /      / \      \
        3     2     1      1   3      2
        /     /       \                 \
        2     1         2                 3
        */
//给一个整数，列出所有的广度优先遍历不同的树======〉也就是列出所有可能的排列
/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 *     int val;
 *     BinaryTreeNode left;
 *     BinaryTreeNode right;
 *     BinaryTreeNode(int x) { val = x; }
 * }
 */
public class 二叉排序树的所有结构 {
    public static void main(String[] argv){
        List<BinaryTreeNode> s = generateTrees(4);
        System.out.println(3);
    }
    public static List<BinaryTreeNode> generateTrees(int n) {
        if(n <= 0){
            return new ArrayList<BinaryTreeNode>();
        }
        List<BinaryTreeNode>[][] arr = new List[n+1][n+1];//arr[i][j] is a list,stores all the rootNode that length is i,&&starts at j
        for(int i = 0; i < n+1; i++){
            arr[0][i] = new ArrayList<BinaryTreeNode>();//all list with length of 0 is empty
            arr[1][i] = new ArrayList<BinaryTreeNode>();
            arr[1][i].add(new BinaryTreeNode(i));
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= n-i+1; j++){//计算每一个长度为i，从j开始的列表集(end at j+i-1)
                arr[i][j] = new ArrayList<BinaryTreeNode>();
                for(int k = j; k <= j + i - 1; k++){//length is i, start from j, and top at k
                    //left array cross right array
                    if(k == j){//left is empty
                        for(int l = 0; l < arr[i-1][k+1].size(); l++){
                            BinaryTreeNode topNode = new BinaryTreeNode(k);
                            topNode.right = arr[j+i-1 - k][k+1].get(l);
                            arr[i][j].add(topNode);
                        }
                    }
                    else if(k == j + i -1){//right is empty
                        for(int l = 0; l < arr[i-1][j].size(); l++){
                            BinaryTreeNode topNode = new BinaryTreeNode(k);
                            topNode.left = arr[i-1][j].get(l);
                            arr[i][j].add(topNode);
                        }
                    }
                    else{
                        for(int leftL = 0; leftL < arr[k-j][j].size(); leftL++){
                            for(int rightL = 0; rightL < arr[j + i -1 -k][k+1].size(); rightL++){
                                BinaryTreeNode topNode = new BinaryTreeNode(k);
                                topNode.left = arr[k-j][j].get(leftL);
                                topNode.right = arr[j + i -1 -k][k+1].get(rightL);
                                arr[i][j].add(topNode);
                            }
                        }
                    }

                }
            }
        }
        return arr[n][1];
    }
}