package algorithm.leetcode.linkedList;

/**
 * 328. 奇偶链表
 * @author: xiongyayun
 * @date: 2022/3/29 10:53 下午
 */
public class OddEvenLinkedList328 {

    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode oPre = odd, ePre = even;
        int n = 1;
        while(head != null){
            if((n & 1) == 1) {
                oPre.next = head;
                oPre = oPre.next;
            }else {
                ePre.next = head;
                ePre = ePre.next;
            }
            head = head.next;
            n++;
        }
        ePre.next = null;
        oPre.next = even.next;
        return odd.next;
    }
}
