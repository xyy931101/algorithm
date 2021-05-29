package algorithm.swordFingerOffer;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/18 23:23
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ReverseList_24 {

    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        reverseList2(head);
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
