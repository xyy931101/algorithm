package algorithm.leetcode.linkedList;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @Author: Xiongyy
 * @Date: 2021/2/17 22:41
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null){
            if(fast.val == slow.val){
                slow.next = fast.next;
            }else{
                slow = slow.next;
            }
            fast = fast.next;
        }
        return head;
    }
}
