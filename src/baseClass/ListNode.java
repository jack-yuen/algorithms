package baseClass;
/**
 * Created by jack on 2017/5/27.
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
    public static void PrintListNode(ListNode n){
        ListNode tmp = n;
        while(tmp != null){
            System.out.print(tmp.val);
            tmp = tmp.next;
            if(tmp != null) {
                System.out.print("->");
            }
            else{
                break;
            }
        }
    }
}