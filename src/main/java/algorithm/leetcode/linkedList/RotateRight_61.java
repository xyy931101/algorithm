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
        if(k == 0 || head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        ListNode iter = head;
        int n = 1;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        k = k % n;
        while(k > 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

}
