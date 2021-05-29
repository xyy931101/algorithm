package algorithm.swordFingerOffer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 * @Author: Xiongyy
 * @Date: 2021/2/17 22:10
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class DeleteNode_18 {


    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        System.out.println(deleteNode(head, 5).value);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        ListNode nextNode = head;
        while (nextNode != null && nextNode.value != val){
            nextNode = nextNode.next;
            temp = temp.next;
        }

        temp.next = nextNode.next;
        return pre.next;
    }
}
