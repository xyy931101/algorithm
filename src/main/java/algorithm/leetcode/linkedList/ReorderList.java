package algorithm.leetcode.linkedList;

import java.util.HashMap;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * @Author: Xiongyy
 * @Date: 2021/2/9 23:01
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        HashMap<ListNode, Integer> indexMap = new HashMap<>(16);
        int i = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            indexMap.put(temp, ++i);
        }
    }
}
