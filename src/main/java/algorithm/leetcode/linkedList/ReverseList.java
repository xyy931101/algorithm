package algorithm.leetcode.linkedList;

import java.util.Stack;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/8 21:26
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode newHead = reverseList(one);
        System.out.println(newHead);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        System.out.println(head.val);
        return p;
    }
}
