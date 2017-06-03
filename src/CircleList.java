import baseClass.ListNode;

/**
 * Created by jack on 2017/5/6.
 * 一个链表中包含环，请找出该链表的环的入口结点。未完成
 */
public class CircleList {
    public class Solution {
        public ListNode EntryNodeOfLoop(ListNode pHead)
        {
            if(pHead == null || pHead.next == null){
                return null;
            }
            ListNode pFirst = pHead.next;
            ListNode pSecond = pHead;
            while(pFirst.val != pSecond.val){
                if(pFirst.next == null || pFirst.next.next == null){
                    return null;
                }
                pFirst = pFirst.next.next;
                pSecond = pSecond.next;
            }
            int i = 1;
            pFirst = pFirst.next.next;
            pSecond = pFirst.next;
            while(pFirst.val != pSecond.val){
                pFirst = pFirst.next.next;
                pSecond = pSecond.next;
                i++;
            }
            pFirst = pHead;
            pSecond = pHead;
            for(int s = 0; s < i; s++){
                pFirst = pFirst.next;
            }
            while(pFirst.val != pSecond.val){
                pFirst = pFirst.next;
                pSecond = pSecond.next;
            }
            return pFirst;
        }
    }
}
