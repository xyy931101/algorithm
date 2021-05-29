package algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 114. 二叉树展开为链表
 * @Author: Xiongyy
 * @Date: 2021/5/2 23:26
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FlattenBinaryTreeToLinkedList114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

            prev = curr;
        }
    }


}
