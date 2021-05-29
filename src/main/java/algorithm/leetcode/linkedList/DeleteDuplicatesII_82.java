package algorithm.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 排序是重点！！！
 *
 * @Author: Xiongyy
 * @Date: 2021/3/25 8:33
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class DeleteDuplicatesII_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //先构建一个前节点,方便后续的返回
        ListNode pre = new ListNode(0, head);
        Set<Integer> nodes = new HashSet<>();
        Set<Integer> duplicatesNodes = new HashSet<>();

        while (head != null){
            if(nodes.contains(head.val)){
                duplicatesNodes.add(head.val);
            }
            nodes.add(head.val);
        }

        //消除所有重复节点
        ListNode node = pre;
        while (node.next != null){
            if(duplicatesNodes.contains(node.next.val)){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }

        return pre.next;
    }

}
