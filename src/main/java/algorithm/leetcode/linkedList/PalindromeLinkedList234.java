package algorithm.leetcode.linkedList;

/**
 * 234. 回文链表
 * @author xiongyayun
 * @date 2021/5/14 22:39
 */
public class PalindromeLinkedList234 {


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;

        while (fast != null && fast.next != null) {
            //跳两个节点
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
            pre.next = prepre;
            prepre = pre;
        }
        while (fast.next != null) {
            slow = slow.next;
        }
        while (slow != null && pre != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }
}
