package algorithm.leetcode.linkedList;

/**
 * @author: xiongyayun
 * @date: 2021/6/8 12:09 上午
 */
public class SortList148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //找到链表的中间节点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            //如果左节点比有节点小,则将做有点作为h的下一个节点,并将左节点移位
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        //没有遍历完的左右两个链表
        h.next = left != null ? left : right;
        return res.next;
    }

}
