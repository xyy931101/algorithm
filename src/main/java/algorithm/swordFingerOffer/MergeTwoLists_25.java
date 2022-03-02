    package algorithm.swordFingerOffer;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/18 23:44
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MergeTwoLists_25 {

    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        ListNode head2 = ListNode.getHead();
        System.out.println(mergeTwoLists(head, head2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        while (l1.next != null || l2.next != null){
            if(l1.value < l2.value){
                pre .next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1.next == null ? l2: l1;
        return temp.next;
    }
}
