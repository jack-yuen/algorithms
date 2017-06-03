import baseClass.ListNode;

/**
 * Created by jack on 2017/5/27.
 * 剑指Offer32题，114页，反转链表
 * 要将首节点的next指向空，否则会最后一起循环
 */
public class ReverseListTest {
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next= node3;
        node3.next = node4;
        node4.next = node5;
        ListNode t = ReverseList(node1);
        ListNode.PrintListNode(t);
    }

    public static ListNode ReverseList(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode tmpNode = pHead;
        ListNode afterNode = pHead.next;
        pHead.next = null;//这里要将首节点的next指向空，否则会最后一起循环
        while(afterNode != null){
            tmpNode = afterNode.next;
            afterNode.next = pHead;
            pHead = afterNode;
            afterNode = tmpNode;
        }
        return pHead;
    }
}
