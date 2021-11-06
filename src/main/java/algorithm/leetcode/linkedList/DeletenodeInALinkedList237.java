package algorithm.leetcode.linkedList;

/**
 * 237. 删除链表中的节点
 * @author: xiongyayun
 * @date: 2021/11/2 8:29
 */
public class DeletenodeInALinkedList237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
    