package algorithm.leetcode.linkedList;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/9 23:24
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
