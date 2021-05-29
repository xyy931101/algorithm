package algorithm.leetcode.linkedList;

/**
 * @author xiongyayun
 * @date 2021/5/18 21:56
 */
public class ReorderList143 {

    public static void main(String[] args) {
        reorderList(ListNode.getHead());
//        System.out.println();
    }

    public static void reorderList(ListNode head) {
        if (head == null ||head.next == null) {
            return;
        }
        
        ListNode mid = getMid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeTwoList(l1, l2);

    }

    private static void mergeTwoList(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            ListNode next = l1.next;
            ListNode next2 = l2.next;

            l1.next = l2;
            l1 = next;
            l2.next = l1;
            l2 = next2;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
