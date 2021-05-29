package algorithm.leetcode.linkedList;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @Author: Xiongyy
 * @Date: 2021/3/9 22:21
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1){
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode current = newHead;

        while (current != null){
            ListNode temp = null;
            int tempIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if(node != null && (temp == null || node.val <= temp.val)){
                    tempIndex = i;
                    temp = node;
                }
            }
            current.next = temp;
            if(tempIndex >= 0){
                lists[tempIndex] = lists[tempIndex].next;
            }
            current = temp;
        }
        return newHead.next;
    }
}
