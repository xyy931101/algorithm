package algorithm.leetcode.linkedList;

/**
 * 反转一个单链表。
 * @Author: Xiongyy
 * @Date: 2021/3/13 15:40
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //翻转之的前一个节点
        ListNode prev = null;
        //当前要翻转的节点
        ListNode cur = head;
        while (cur != null){
            //先取到当前节点的下一个节点,方便后续翻转
            ListNode next = cur.next;
            //当前节点的next指向未翻转前一个节点
            cur.next = prev;
            //翻转后的前一个节点是当前节点
            prev = cur;
            //下一次的当前节点是未翻转前的下一个节点
            cur = next;
        }
        return prev.next;

    }
}
