package algorithm.leetcode.linkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 445. 两数相加 II
 * @author: xiongyayun
 * @date: 2022/3/5 5:22 下午
 */
public class AddTwoNumbersII445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        while(l1 != null){
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            deque2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while(!deque1.isEmpty() || !deque2.isEmpty() || carry > 0){
            int l1v = deque1.isEmpty() ? 0 : deque1.pop();
            int l2v = deque2.isEmpty() ? 0 : deque2.pop();
            int sum = carry + l1v + l2v;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

}
