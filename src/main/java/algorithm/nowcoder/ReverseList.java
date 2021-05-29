package algorithm.nowcoder;

import com.examplexyy.demo.algorithm.swordFingerOffer.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 * @author xiongyayun
 * @date 2021/5/12 20:43
 */
public class ReverseList {
    public static void main(String[] args) {
        System.out.println(ReverseList(ListNode.getHead()));
    }

    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
