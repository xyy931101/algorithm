package algorithm.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 排序是重点！！！
 *
 * @Author: Xiongyy
 * @Date: 2021/3/25 8:33
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class DeleteDuplicatesII_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = head.next;
        while(fast != null){
            if(fast.val != slow.next.val){
                fast = fast.next;
                slow = slow.next;
            }else {
                while(fast != null && slow.next.val == fast.val) {
                    fast = fast.next;
                }
                slow.next = fast;
                if(fast != null){
                    fast = fast.next;
                }
            }
        }
        return dummy.next;
    }

}
