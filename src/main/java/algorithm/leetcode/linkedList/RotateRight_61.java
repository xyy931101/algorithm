package algorithm.leetcode.linkedList;

/**
 * @Author: Xiongyy
 * @Date: 2021/3/27 22:11
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RotateRight_61 {

    public static void main(String[] args) {
//        ListNode four = new ListNode(4);
//        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1, two);

        System.out.println(rotateRight(one, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        ListNode fast = head,slow = head;
        //1.先走K步
        while (k != 0){
            if (fast.next == null) {
                fast = head;
            }else {
                fast = fast.next;
            }
            k--;
        }
        if (fast == head) {
            return head;
        }
        //2.快慢指针一起走,当快指针走到尾节点结束
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;

        fast.next = head;
        return newHead;
    }

}
