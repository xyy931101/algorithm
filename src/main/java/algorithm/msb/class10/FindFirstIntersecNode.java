package algorithm.msb.class10;

import algorithm.swordFingerOffer.ListNode;

/**
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null   【要求】
 * 如果两个链表长度之和为N，时间复杂度请达到O(N)，额外空间复杂度 请达到O(1)。
 * @author: xiongyayun
 * @date: 2021/7/27 7:59 下午
 */
public class FindFirstIntersecNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2){
        return null;
    }


    //找到链表中是否有环
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast) {
            //有环链表不可能为空
            if (fast.next == null || fast.next.next == null) return null;

            fast = fast.next.next;
            slow = slow.next;
        }

        //两个链表相交之后
        fast = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
