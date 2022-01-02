package algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1609. 奇偶树
 * @author: xiongyayun
 * @date: 2021/12/25 14:13
 */
public class EvenOddTree1609 {

    public static void main(String[] args) {
        System.out.println(3 & 1);
    }

    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //记录层序是否为偶数
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size(), prev = flag ? 0 : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollLast();
                int cur = node.val;
                if (node.left != null) {
                    queue.push(node.left);
                }
                if (node.right != null) {
                    queue.push(node.right);
                }
                if (flag && ((cur & 1) == 0 || cur <= prev)) {
                    return false;
                }
                if (!flag && ((cur & 1) != 0 || cur >= prev)) {
                    return false;
                }
                prev = cur;
            }
            flag = !flag;
        }
        return true;
    }

}
