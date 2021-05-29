package algorithm.leetcode.linkedList;

/**
 * 找到两个单链表相交的起始节点
 * @Author: Xiongyy
 * @Date: 2021/2/8 20:09
 * .............................................
 * 佛祖保佑             永无BUG
 *
 *         ListNode ha = headA, hb = headB;
 *         while (ha != hb) {
 *             ha = ha != null ? ha.next : headB;
 *             hb = hb != null ? hb.next : headA;
 *         }
 *         return ha;
 *
 */

class MyLinkList{
    ListNode head = new ListNode(0);

    public void add(ListNode listnode) {
        ListNode tmp = head;
        while(tmp.next!=null) {
            tmp =tmp.next;
        }
        tmp.next =listnode;
    }
}

public class IntersectionNode {

    public static void main(String[] args) {
        ListNode node8= new ListNode(8);
        ListNode node4= new ListNode(4);
        ListNode node5= new ListNode(5);
        MyLinkList list = new MyLinkList();
        list.add(new ListNode(4));
        list.add(new ListNode(1));
        list.add(node8);
        list.add(node4);
        list.add(node5);
        MyLinkList list1 = new MyLinkList();
        list1.add(new ListNode(5));
        list1.add(new ListNode(0));
        list1.add(new ListNode(1));
        list1.add(node8);

        ListNode node = getIntersectionNode(list.head,list1.head);
        System.out.println(node.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       int aLength = 0;
       int bLength = 0;
       ListNode a = headA;
       ListNode b = headB;
       while (a != null){
           a = a.next;
           aLength = aLength + 1;
       }
        while (b != null){
            b = b.next;
            bLength = bLength + 1;
        }
        int abs = Math.abs(aLength - bLength);
        if(aLength > bLength){
            for (int i = 0; i < abs; i++) {
                headA = headA.next;
            }
        }else{
            for (int i = 0; i < abs; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
