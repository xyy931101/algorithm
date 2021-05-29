package algorithm.swordFingerOffer;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * @Author: Xiongyy
 * @Date: 2021/2/24 22:53
 * .............................................
 * 佛祖保佑             永无BUG
 */

public class CopyRandomList_35 {

    public static void main(String[] args) {
        ListNode head = ListNode.getHead();
        System.out.println(JSONObject.toJSONString(copyRandomList(head)));
    }

    public static ListNode copyRandomList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            ListNode newCur = new ListNode(cur.value);
            cur.next = newCur;
            newCur.next = next;
            cur = next;
        }
        cur = head.next;
        ListNode pre = head, res = head.next;
        while (cur.next != null){
            if(pre.random != null){
                pre.next.random = pre.random.next;
            }
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;

        }
        pre.next = null;
        return res;
    }
}
