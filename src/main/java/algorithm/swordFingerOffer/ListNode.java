package algorithm.swordFingerOffer;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/6 15:33
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ListNode{

    public int value;
    public ListNode next;
    public ListNode random;

    public ListNode(int v){
        this.value = v;
    }

    public static ListNode getHead(){
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;
        ListNode head4 = new ListNode(4);
        head3.next = head4;
//        ListNode head5 = new ListNode(5);
//        head4.next = head5;

        return head;
    }
}
