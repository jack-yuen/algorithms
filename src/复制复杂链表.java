/**
 * Created by jack on 2017/6/2.
 */
import baseClass.ComplexListNode;
public class 复制复杂链表 {
    public static void main(String[] args){
        ComplexListNode n1 = new ComplexListNode(1);
        ComplexListNode n2 = new ComplexListNode(2);
        ComplexListNode n3 = new ComplexListNode(3);
        ComplexListNode n4 = new ComplexListNode(4);
        ComplexListNode n5 = new ComplexListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.sibling = n3;
        n2.sibling = n5;
        n4.sibling = n2;
        ComplexListNode curNode = solve(n1);
        while(curNode != null){
            System.out.print(curNode.val + "" + ((curNode.sibling == null)?"()":"("+curNode.sibling.val+")") + "->");
            curNode = curNode.next;
        }
    }
    public static ComplexListNode solve(ComplexListNode node){
        ComplexListNode result = null;
        if(node == null){
            return null;
        }
        cloneAndInsert(node);
        linkSiblings(node);
        result = seperateNode(node);
        return result;
    }
    public static void cloneAndInsert(ComplexListNode node){
        while(node != null){
            ComplexListNode newNode = new ComplexListNode(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
    }
    public static void linkSiblings(ComplexListNode node){
        boolean odd = true;
        while(node != null){
            if(odd && node.sibling != null){
                node.next.sibling = node.sibling.next;
            }
            node = node.next;
            odd = !odd;
        }
    }
    public static ComplexListNode seperateNode(ComplexListNode node){
        ComplexListNode head = node.next;
        while(node != null && node.next != null){
            ComplexListNode tmpNode = node.next;
            node.next = node.next.next;
            node = tmpNode;
        }
        return head;
    }
}
