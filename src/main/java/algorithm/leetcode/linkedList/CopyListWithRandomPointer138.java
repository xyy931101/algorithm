package algorithm.leetcode.linkedList;


import algorithm.leetcode.common.Node;

/**
 * 138. 复制带随机指针的链表
 * @author: xiongyayun
 * @date: 2021/6/6 13:41
 */
public class CopyListWithRandomPointer138 {

    public static void main(String[] args) {
        System.out.println(copyRandomList(Node.getInstance()));
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node newCur = new Node(cur.val);
            newCur.next = next;
            cur.next = newCur;
            cur = next;
        }

        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head.next;
        Node res = head.next, pre = head;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null;
        return res;
    }
}
